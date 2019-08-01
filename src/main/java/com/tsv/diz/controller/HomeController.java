package com.tsv.diz.controller;

import com.tsv.diz.model.Crawlers.*;
import com.tsv.diz.model.*;
import com.tsv.diz.repository.OptionRepository;
import com.tsv.diz.repository.ResultRepository;
import com.tsv.diz.repository.SavedAdRepository;
import com.tsv.diz.repository.SearchHistoryRepository;
import com.tsv.diz.service.GenerateScoreImpl;
import com.tsv.diz.service.ScrapperAuto;
import com.tsv.diz.service.ScrapperAutovitRecImpl;
import com.tsv.diz.service.ScrapperOlxRecImpl;
import com.tsv.diz.service.interfaces.*;
import com.tsv.diz.util.*;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
public class HomeController {

    // INJECTED VARIABLES
    @Autowired
    private ScrapperAutovit scrapperAutovit;
    @Autowired
    private ScrapperAutovit2 scrapperAutovit2;
    @Autowired
    private ScrapperOlx scrapperOlx;
    @Autowired
    private ScrapperOlx2 scrapperOlx2;
    @Autowired
    private ScrapperPubli24 scrapperPubli24;
    @Autowired
    private ScrapperPubli242 scrapperPubli242;
    @Autowired
    private ScrapperBestAuto scrapperBestAuto;
    @Autowired
    private ScrapperBestAuto2 scrapperBestAuto2;
    @Autowired
    private ScrapperAuto scrapperAuto;
    @Autowired
    private ScrapperAuto2 scrapperAuto2;
    @Autowired
    private OptionRepository optionRepo;
    @Autowired
    private ResultRepository resultRepo;
    @Autowired
    private SavedAdRepository savedAdRepository;
    @Autowired
    private ClusterJustOneUser clusterJustOneUser;
    @Autowired
    private ClusterNewUser clusterNewUser;
    @Autowired
    private GenerateScoreImpl generateScoreImpl;
    //Recomandari
    @Autowired
    private ScrapperAutovitRecImpl scrapperAutovitRec;

    @Autowired
    private ScrapperOlxRecImpl scrapperOlxRec;
/*
    @Autowired
    private ScrapperPubli24Rec scrapperPubli24Rec;*/

    @Autowired
    private ScrapperBestAutoRec scrapperBestAutoRec;

    @Autowired
    private ScrapperAutoRec scrapperAutoRec;
    @Autowired
    private ScrapperCarzz scrapperCarzz;
    @Autowired
    private ScrapperCarzz2 scrapperCarzz2;
    @Autowired
    private ScraperCarzzRec scraperCarzzRec;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    private double count;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Map search(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                      @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                      @RequestParam String orasParam, Principal principal) throws Exception {



        //CLASE HELPER
        OlxHelperClass oxlHelperClass = OlxUtil.olxHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);
        AutovitHelperClass autovitHelperClass = AutovitUtil.autovitHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);
        BestAutoHelperClass bestAutoHelperClass = BestAutoUtil.bestAutoHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);
        AutoHelperClass autoHelperClass = AutoUtil.autoHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);
        CarzzHelperClass carzzHelperClass = CarzzUtil.carzzHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        count = -10;
        double averageVectorScores = 0;
        List<SearchResultCommon> recommandationList = new ArrayList<>();
        long idUserRecommandation = 0;
        try {
            if (principal != null) {
                String nameOfTheSameUser = "";
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                SearchHistory searchHistory = new SearchHistory(marcaId,modelId,pretDeLa,pretPanaLa,anFabrDeLa,anFabrPanaLa,orasParam,user);
                searchHistoryRepository.save(searchHistory);

                System.out.println("SCORUL ESTE: " + generateScoreImpl
                        .generateResult(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa));
                Option option = new Option(
                        marcaId, modelId, anFabrDeLa,anFabrPanaLa,pretDeLa, pretPanaLa, orasParam, generateScoreImpl
                        .generateResult(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa),
                        user);
                optionRepo.save(option);

                // verific daca nu are alte cautari
                List<Option> options = optionRepo.findOptionByUserId(user.getId());
                System.out.println("DIMENSIUNE LISTA DE OPTIUNI VENITA: " + options.size());
                if (options.size() == 1) {
                    System.out.println("Utilizatorul nu are vreo cautare!!!, trebuie clusterizat");
                    clusterNewUser.clusterNewUser(user.getId());
                }

                // Grupez utilizatorul din nou
                // Doar in cazul in care are mai mult de o cautare
                if(options.size()>1){
                    clusterJustOneUser.clusterJustOneUserMethod(user.getId());
                }


                //Fac recomandare
                //aflu in ce cluster se afla utilizatorul logat
                Result resultUser = resultRepo.findResultByUserId(user.getId());
                //iau lista de utilizatori care se afla in acelasi cluster
                List<Result> usersFromTheSameCluster = resultRepo.findResultByClusterId(resultUser.getCluster());
                for (int i = 0; i < usersFromTheSameCluster.size(); i++) {
                    System.out.println("Lista de utilizatori din acelasi cluster este: " + usersFromTheSameCluster.get(i).getUser().getEmail());
                }
                if (usersFromTheSameCluster.size() > 1) {
                    for (int i = 0; i < usersFromTheSameCluster.size(); i++) {
                        if (user.getId() == usersFromTheSameCluster.get(i).getUser().getId()) {
                            continue;
                        } else {
                            //List<Option> optionsUsers = optionRepo.findOptionByUserId(usersFromTheSameCluster.get(i).getUser().getId());
                            List<Option> optionsUsers = usersFromTheSameCluster.get(i).getUser().getOptions();
                            System.out.println("Userul Logat: " + user.getEmail());
                            System.out.println("Userul Comparat: " + usersFromTheSameCluster.get(i).getUser().getEmail());
                            double[] vector = new double[optionsUsers.size()];
                            double[] vectorUtilizLogat = new double[options.size()];

                            for (int x = 0; x < optionsUsers.size(); x++) {
                                vector[x] = optionsUsers.get(x).getScore();
                                System.out.println("Vector1:" + vector[x]);
                            }
                            for (int y = 0; y < options.size(); y++) {
//                                vectorUtilizLogat[y] = user.getOptions().get(y).getScore();
                                vectorUtilizLogat[y] = options.get(y).getScore();
                                System.out.println("VectorUtilizLogat: " + vectorUtilizLogat[y]);
                            }

                            System.out.println("Vector1 dimensiune: " + vector.length);
                            System.out.println("Vector2 dimensiune: " + vectorUtilizLogat.length);

                            double corelatie = 0;
                            if (vectorUtilizLogat.length > vector.length) {

                                double[] vectorNou = new double[vectorUtilizLogat.length];

                                for (int y = 0; y < vector.length; y++) {
                                    vectorNou[y] = vector[y];
                                }
                                for (int j = vector.length; j < vectorUtilizLogat.length; j++) {
                                    vectorNou[j] = 0;
                                }

                                for (int z = 0; z < vectorNou.length; z++) {
                                    System.out.println("Valoare din vector utilizator opus" + z + " " + vectorNou[z]);
                                }
                                for (int w = 0; w < vectorUtilizLogat.length; w++) {
                                    System.out.println("Valoare din vector utilizator logat" + w + " " + vectorUtilizLogat[w]);
                                }

                                corelatie = new PearsonsCorrelation().correlation(vectorUtilizLogat, vectorNou);
                                System.out.println("Corelatie calculata in if: " + corelatie);
                            } else {

                                double[] vectorNou = new double[vector.length];

                                for (int y = 0; y < vectorUtilizLogat.length; y++) {
                                    vectorNou[y] = vectorUtilizLogat[y];
                                }
                                for (int j = vectorUtilizLogat.length; j < vector.length; j++) {
                                    vectorNou[j] = 0;
                                }

                                for (int z = 0; z < vectorNou.length; z++) {
                                    System.out.println("Valoare din vector utilizator logat" + z + " " + vectorNou[z]);
                                }
                                for (int w = 0; w < vector.length; w++) {
                                    System.out.println("Valoare din vector utilizator opus" + w + " " + vector[w]);
                                }

                                corelatie = new PearsonsCorrelation().correlation(vector, vectorNou);
                                System.out.println("Corelatie calculata in else: " + corelatie);
                            }


                            if (count < corelatie) {
                                count = corelatie;
                                System.out.println("Valoare Corelatie In Count: " + corelatie);
                                //ar trebui sa am si user id-ul aici
                                nameOfTheSameUser = usersFromTheSameCluster.get(i).getUser().getEmail();
                                idUserRecommandation = usersFromTheSameCluster.get(i).getUser().getId();
                                double vectorScores=0;
                                for(int z=0; z<vector.length; z++){
                                     vectorScores += vector[z];
                                }
                                averageVectorScores = vectorScores/vector.length;
                                DecimalFormat df = new DecimalFormat("#.##");
                                averageVectorScores = Double.valueOf(df.format(averageVectorScores));
                                System.out.println("PREDICTIA MEDIIEI ESTE: " + averageVectorScores);
                                System.out.println("Utilizatorul cu cele mai apropiate cautari este: " + nameOfTheSameUser);
                            }
                        }

                    }
                }
                String marcaRec ="";
                String modelRec = "";
                String pretDeLaRec = "";
                String pretPanaLaRec = "";
                String anFabrDeLaRec = "";
                String anFabrPanaLaRec = "";
                String orasRec = "";

                double differentValue = 0;
                if (!nameOfTheSameUser.isEmpty()) {
                    List<Option> optionListUserRec = optionRepo.findOptionByUserId(idUserRecommandation);
                    List<Option> optionListLoggedInUser = optionRepo.findOptionByUserId(user.getId());

                    double [] vectorUtilizatorRecomandare = new double[optionListUserRec.size()];
                    for(int i=0; i<optionListUserRec.size(); i++){
                        vectorUtilizatorRecomandare[i]=optionListUserRec.get(i).getScore();
                    }

                    double [] vectorUtilizatorLogat = new double[optionListLoggedInUser.size()];
                    for(int x=0; x<optionListLoggedInUser.size(); x++){
                        vectorUtilizatorLogat[x] = optionListLoggedInUser.get(x).getScore();
                    }

                    List<Double> valoriDiferiteVectori = new ArrayList<>();
                    double countFlag = 0;

                    for(int z=0; z<vectorUtilizatorRecomandare.length; z++){
                        for(int y=0; y<vectorUtilizatorLogat.length; y++){
                             if(vectorUtilizatorRecomandare[z] == vectorUtilizatorLogat[y]){
                                 countFlag=1;
                             }
                        }
                        if(countFlag == 0){
                            valoriDiferiteVectori.add(vectorUtilizatorRecomandare[z]);
                        }
                        countFlag = 0;
                    }

                    if(valoriDiferiteVectori.isEmpty()){
                        for(int i=0; i<vectorUtilizatorRecomandare.length; i++){
                            if(vectorUtilizatorRecomandare[i] > averageVectorScores){
                                averageVectorScores = vectorUtilizatorRecomandare[i];
                            }
                        }
                        List<Option>filtreRecomandare = optionRepo.findOptionByScore(averageVectorScores);
                        System.out.println("Scorul recomandat pentru medie este: " + averageVectorScores);
                        marcaRec =filtreRecomandare.get(0).getMarca();
                        modelRec = filtreRecomandare.get(0).getModel();
                        pretDeLaRec = filtreRecomandare.get(0).getPretDeLa();
                        pretPanaLaRec = filtreRecomandare.get(0).getPretPanaLa();
                        anFabrDeLaRec = filtreRecomandare.get(0).getAnFabrDeLa();
                        anFabrPanaLaRec = filtreRecomandare.get(0).getAnFabrPanaLa();
                        orasRec = filtreRecomandare.get(0).getOras();
                    }else{
                        Random random = new Random();
                        double recomandareScor = valoriDiferiteVectori.get(random.nextInt(valoriDiferiteVectori.size() - 1 - 0 + 1) + 0);
                        List<Option>filtreRecomandare = optionRepo.findOptionByScore(recomandareScor);
                        System.out.println("Scorul recomandat din multime este: " + recomandareScor);
                         marcaRec =filtreRecomandare.get(0).getMarca();
                         modelRec = filtreRecomandare.get(0).getModel();
                         pretDeLaRec = filtreRecomandare.get(0).getPretDeLa();
                         pretPanaLaRec = filtreRecomandare.get(0).getPretPanaLa();
                         anFabrDeLaRec = filtreRecomandare.get(0).getAnFabrDeLa();
                         anFabrPanaLaRec = filtreRecomandare.get(0).getAnFabrPanaLa();
                         orasRec = filtreRecomandare.get(0).getOras();
                    }

                    //CLASE HELPER RECOMANDARE
                    OlxHelperClass oxlHelperClassRec = OlxUtil.olxHelper(marcaRec, modelRec, pretDeLaRec, pretPanaLaRec, anFabrDeLaRec, anFabrPanaLaRec, orasRec);
                    AutovitHelperClass autovitHelperClassRec = AutovitUtil.autovitHelper(marcaRec, modelRec, pretDeLaRec, pretPanaLaRec, anFabrDeLaRec, anFabrPanaLaRec, orasRec);
                    BestAutoHelperClass bestAutoHelperClassRec = BestAutoUtil.bestAutoHelper(marcaRec, modelRec, pretDeLaRec, pretPanaLaRec, anFabrDeLaRec, anFabrPanaLaRec, orasRec);
                    AutoHelperClass autoHelperClassRec = AutoUtil.autoHelper(marcaRec, modelRec, pretDeLaRec, pretPanaLaRec, anFabrDeLaRec, anFabrPanaLaRec, orasRec);
                    CarzzHelperClass carzzHelperClassRec = CarzzUtil.carzzHelper(marcaRec, modelRec, pretDeLaRec, pretPanaLaRec, anFabrDeLaRec, anFabrPanaLaRec, orasRec);


                    List<SearchResultCommon> lista1 = scrapperAutovitRec.searchAutovitRec(autovitHelperClassRec.getMarca(), autovitHelperClassRec.getModel(), autovitHelperClassRec.getPretDeLa(), autovitHelperClassRec.getPretPanaLa()
                            , autovitHelperClassRec.getAnFabrDeLa(), autovitHelperClassRec.getAnFabrPanaLa(), autovitHelperClassRec.getOras());
                    List<SearchResultCommon> lista2 = scrapperOlxRec.searchOlxRec(oxlHelperClassRec.getMarca(), oxlHelperClassRec.getModel(), oxlHelperClassRec.getPretDeLa(), oxlHelperClassRec.getPretPanaLa()
                            , oxlHelperClassRec.getAnFabrDeLa(), oxlHelperClassRec.getAnFabrPanaLa(), oxlHelperClassRec.getOras());
                    List<SearchResultCommon> lista3 = scraperCarzzRec.searchAutoRec(carzzHelperClassRec.getMarca(), carzzHelperClassRec.getModel(),
                            carzzHelperClassRec.getPretDeLa(), carzzHelperClassRec.getPretPanaLa(), carzzHelperClassRec.getAnFabrDeLa(), carzzHelperClassRec.getAnFabrPanaLa(), carzzHelperClassRec.getOras());
                    List<SearchResultCommon> lista4 = scrapperBestAutoRec.searchBestAutoRec(bestAutoHelperClassRec.getMarca(), bestAutoHelperClassRec.getModel(), bestAutoHelperClassRec.getPretDeLa(), bestAutoHelperClassRec.getPretPanaLa()
                            , bestAutoHelperClassRec.getAnFabrDeLa(), bestAutoHelperClassRec.getAnFabrPanaLa(), bestAutoHelperClassRec.getOras());
                    List<SearchResultCommon> lista5 = scrapperAutoRec.searchAutoRec(autoHelperClassRec.getMarca(), autoHelperClassRec.getModel(), autoHelperClassRec.getPretDeLa(), autoHelperClassRec.getPretPanaLa()
                            , autoHelperClassRec.getAnFabrDeLa(), autoHelperClassRec.getAnFabrPanaLa(), autoHelperClassRec.getOras());

                    Random randomValue = new Random();
                    recommandationList.add(lista1.get(randomValue.nextInt(lista1.size() - 1 - 0 + 1) + 0));
                    recommandationList.add(lista2.get(randomValue.nextInt(lista2.size() - 1 - 0 + 1) + 0));
                    recommandationList.add(lista3.get(randomValue.nextInt(lista3.size() - 1 - 0 + 1) + 0));
                    recommandationList.add(lista4.get(randomValue.nextInt(lista4.size() - 1 - 0 + 1) + 0));
                    recommandationList.add(lista5.get(randomValue.nextInt(lista5.size() - 1 - 0 + 1) + 0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<SearchResultAutovit> lista = scrapperAutovit.searchAutovit(autovitHelperClass.getMarca(), autovitHelperClass.getModel(), autovitHelperClass.getPretDeLa(), autovitHelperClass.getPretPanaLa(), autovitHelperClass.getAnFabrDeLa(), autovitHelperClass.getAnFabrPanaLa(), autovitHelperClass.getOras());
        List<SearchResultOlx> listaOlx = scrapperOlx.searchOlx(oxlHelperClass.getMarca(), oxlHelperClass.getModel(), oxlHelperClass.getPretDeLa(), oxlHelperClass.getPretPanaLa(), oxlHelperClass.getAnFabrDeLa(), oxlHelperClass.getAnFabrPanaLa(), oxlHelperClass.getOras());
        List<SearchResultBestAuto> listaBestAuto = scrapperBestAuto.searchBestAuto(bestAutoHelperClass.getMarca(), bestAutoHelperClass.getModel(), bestAutoHelperClass.getOras(), bestAutoHelperClass.getAnFabrDeLa(), bestAutoHelperClass.getAnFabrPanaLa(), bestAutoHelperClass.getPretDeLa(), bestAutoHelperClass.getPretPanaLa());
        List<SearchResultAuto> listaAuto = scrapperAuto.searchAuto(autoHelperClass.getMarca(), autoHelperClass.getModel(), autoHelperClass.getOras(), autoHelperClass.getAnFabrDeLa(), autoHelperClass.getAnFabrPanaLa(), autoHelperClass.getPretDeLa(), autoHelperClass.getPretPanaLa());
        List<SearchResultCarzz> listaCarzz = scrapperCarzz.searchCarzz(carzzHelperClass.getMarca(), carzzHelperClass.getModel(), carzzHelperClass.getOras(), carzzHelperClass.getAnFabrDeLa(), carzzHelperClass.getAnFabrPanaLa(), carzzHelperClass.getPretDeLa(), carzzHelperClass.getPretPanaLa());

        Map<String, List<?>> listOfWebsites = new HashMap<>();
        listOfWebsites.put("listaAutovit", lista);
        listOfWebsites.put("adsNumberAutovit", scrapperAutovit.numarAnuturiAutovit(autovitHelperClass.getMarca(), autovitHelperClass.getModel(), autovitHelperClass.getPretDeLa(), autovitHelperClass.getPretPanaLa(), autovitHelperClass.getAnFabrDeLa(), autovitHelperClass.getAnFabrPanaLa(), autovitHelperClass.getOras()));
        listOfWebsites.put("listaOlx", listaOlx);
        listOfWebsites.put("adsNumberOlx", scrapperOlx.numarAnunturiOlx(oxlHelperClass.getMarca(), oxlHelperClass.getModel(), oxlHelperClass.getPretDeLa(), oxlHelperClass.getPretPanaLa(), oxlHelperClass.getAnFabrDeLa(), oxlHelperClass.getAnFabrPanaLa(), oxlHelperClass.getOras()));
        listOfWebsites.put("listaBestAuto", listaBestAuto);
        listOfWebsites.put("adsNumberBestAuto", scrapperBestAuto.numarAnuturiBestAuto(bestAutoHelperClass.getMarca(), bestAutoHelperClass.getModel(), bestAutoHelperClass.getOras(), bestAutoHelperClass.getAnFabrDeLa(), bestAutoHelperClass.getAnFabrPanaLa(), bestAutoHelperClass.getPretDeLa(), bestAutoHelperClass.getPretPanaLa()));
        listOfWebsites.put("listaAuto", listaAuto);
        listOfWebsites.put("adsNumberAuto", scrapperAuto.numarAnuturiAuto(autoHelperClass.getMarca(), autoHelperClass.getModel(), autoHelperClass.getPretDeLa(), autoHelperClass.getPretPanaLa(), autoHelperClass.getAnFabrDeLa(), autoHelperClass.getAnFabrPanaLa(), autoHelperClass.getOras()));
        listOfWebsites.put("listaCarzz", listaCarzz);
        listOfWebsites.put("adsNumberCarzz", scrapperCarzz.numarAnunturiScarzz(carzzHelperClass.getMarca(), carzzHelperClass.getModel(), carzzHelperClass.getPretDeLa(), carzzHelperClass.getPretPanaLa(), carzzHelperClass.getAnFabrDeLa(), carzzHelperClass.getAnFabrPanaLa(), carzzHelperClass.getOras()));

        if (!recommandationList.isEmpty()) {
            listOfWebsites.put("recommandationList", recommandationList);
        } else {
            listOfWebsites.put("recommandationList", Collections.emptyList());
        }
        return listOfWebsites;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchAutovit", method = RequestMethod.POST)
    @ResponseBody
    public Map searchAutovit(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                             @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                             @RequestParam String orasParam, @RequestParam int count) throws Exception {
        System.out.println("A intrat aici!");

        AutovitHelperClass autovitHelperClass = AutovitUtil.autovitHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        Map<String, List<?>> listOfWebsitesAutovit = new HashMap<>();

        List<SearchResultAutovit> listaAutovit2 = scrapperAutovit2.searchAutovit(autovitHelperClass.getMarca(), autovitHelperClass.getModel(), autovitHelperClass.getPretDeLa(), autovitHelperClass.getPretPanaLa(), autovitHelperClass.getAnFabrDeLa(), autovitHelperClass.getAnFabrPanaLa(),
                autovitHelperClass.getOras(), count);

        listOfWebsitesAutovit.put("listaAutovit", listaAutovit2);
        listOfWebsitesAutovit.put("adsNumberAutovitPage", scrapperAutovit.numarAnuturiAutovit(autovitHelperClass.getMarca(), autovitHelperClass.getModel(), autovitHelperClass.getPretDeLa(), autovitHelperClass.getPretPanaLa(), autovitHelperClass.getAnFabrDeLa(), autovitHelperClass.getAnFabrPanaLa(), autovitHelperClass.getOras()));

        System.out.println(count);

        return listOfWebsitesAutovit;

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchOlx", method = RequestMethod.POST)
    @ResponseBody
    public Map searchOlx(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                         @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                         @RequestParam String orasParam, @RequestParam int count) throws Exception {

        OlxHelperClass oxlHelperClass = OlxUtil.olxHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        Map<String, List<?>> listOfWebsitesOlx = new HashMap<>();
        List<SearchResultOlx> listaOlx2 = scrapperOlx2.searchOlx(oxlHelperClass.getMarca(), oxlHelperClass.getModel(), oxlHelperClass.getPretDeLa(), oxlHelperClass.getPretPanaLa(), oxlHelperClass.getAnFabrDeLa(), oxlHelperClass.getAnFabrPanaLa(), oxlHelperClass.getOras(), count);

        listOfWebsitesOlx.put("listaOlx", listaOlx2);
        listOfWebsitesOlx.put("adsNumberOlx", scrapperOlx.numarAnunturiOlx(oxlHelperClass.getMarca(), oxlHelperClass.getModel(), oxlHelperClass.getPretDeLa(), oxlHelperClass.getPretPanaLa(), oxlHelperClass.getAnFabrDeLa(), oxlHelperClass.getAnFabrPanaLa(), oxlHelperClass.getOras()));

        return listOfWebsitesOlx;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchCarzz", method = RequestMethod.POST)
    @ResponseBody
    public Map searchCarzz(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                           @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                           @RequestParam String orasParam, @RequestParam int count) throws Exception {

        Map<String, List<?>> listOfWebsitesCarzz = new HashMap<>();

        CarzzHelperClass carzzHelperClass = CarzzUtil.carzzHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        List<SearchResultCarzz> listaCarzz2 = scrapperCarzz2.searchCarzz(carzzHelperClass.getMarca(), carzzHelperClass.getModel(), carzzHelperClass.getPretDeLa(), carzzHelperClass.getPretPanaLa(), carzzHelperClass.getAnFabrDeLa(), carzzHelperClass.getAnFabrPanaLa(), carzzHelperClass.getOras(), count);
        listOfWebsitesCarzz.put("listaCarzz", listaCarzz2);
        listOfWebsitesCarzz.put("adsNumberCarzz", scrapperCarzz.numarAnunturiScarzz(carzzHelperClass.getMarca(), carzzHelperClass.getModel(), carzzHelperClass.getPretDeLa(), carzzHelperClass.getPretPanaLa(), carzzHelperClass.getAnFabrDeLa(), carzzHelperClass.getAnFabrPanaLa(), carzzHelperClass.getOras()));
        return listOfWebsitesCarzz;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/searchBestAuto", method = RequestMethod.POST)
    @ResponseBody
    public Map searchBestAuto(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                              @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                              @RequestParam String orasParam, @RequestParam int count) throws Exception {

        Map<String, List<?>> listOfWebsitesBestAuto = new HashMap<>();
        BestAutoHelperClass bestAutoHelperClass = BestAutoUtil.bestAutoHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        List<SearchResultBestAuto> listaBestAuto2 = scrapperBestAuto2.searchBestAuto2(bestAutoHelperClass.getMarca(), bestAutoHelperClass.getModel(), bestAutoHelperClass.getOras(), bestAutoHelperClass.getAnFabrDeLa(), bestAutoHelperClass.getAnFabrPanaLa(), bestAutoHelperClass.getPretDeLa(), bestAutoHelperClass.getPretPanaLa(), count);

        listOfWebsitesBestAuto.put("listaBestAuto", listaBestAuto2);
        listOfWebsitesBestAuto.put("adsNumberBestAuto", scrapperBestAuto.numarAnuturiBestAuto(bestAutoHelperClass.getMarca(), bestAutoHelperClass.getModel(), bestAutoHelperClass.getOras(), bestAutoHelperClass.getAnFabrDeLa(), bestAutoHelperClass.getAnFabrPanaLa(), bestAutoHelperClass.getPretDeLa(), bestAutoHelperClass.getPretPanaLa()));
        return listOfWebsitesBestAuto;
    }

    @RequestMapping(value = "/searchAuto", method = RequestMethod.POST)
    @ResponseBody
    public Map searchAuto(@RequestParam String marcaId, @RequestParam String modelId, @RequestParam String pretDeLa,
                          @RequestParam String pretPanaLa, @RequestParam String anFabrDeLa, @RequestParam String anFabrPanaLa,
                          @RequestParam String orasParam, @RequestParam int count) throws Exception {

        Map<String, List<?>> listOfWebsitesAuto = new HashMap<>();
        AutoHelperClass autoHelperClass = AutoUtil.autoHelper(marcaId, modelId, pretDeLa, pretPanaLa, anFabrDeLa, anFabrPanaLa, orasParam);

        List<SearchResultAuto> listaAuto = scrapperAuto2.searchAuto(autoHelperClass.getMarca(), autoHelperClass.getModel(), autoHelperClass.getPretDeLa(), autoHelperClass.getPretPanaLa(), autoHelperClass.getAnFabrDeLa(), autoHelperClass.getAnFabrPanaLa(), autoHelperClass.getOras(), count);

        listOfWebsitesAuto.put("listaAuto", listaAuto);
        listOfWebsitesAuto.put("adsNumberAuto", scrapperAuto.numarAnuturiAuto(autoHelperClass.getMarca(), autoHelperClass.getModel(), autoHelperClass.getPretDeLa(), autoHelperClass.getPretPanaLa(), autoHelperClass.getAnFabrDeLa(), autoHelperClass.getAnFabrPanaLa(), autoHelperClass.getOras()));
        return listOfWebsitesAuto;
    }
    @RequestMapping(value="/saveAd", method = RequestMethod.POST)
    @ResponseBody
    public String saveAd(@RequestParam String price, @RequestParam String city, @RequestParam String title, @RequestParam String img,@RequestParam String link, Principal principal){

        if(principal != null){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SavedAd savedAd = new SavedAd(title,price,city,img,link,user);
            savedAdRepository.save(savedAd);
            return "Ad was saved successfully!";
        }else{
            return "Please Register!";
        }

    }

}
