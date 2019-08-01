package com.tsv.diz.service;

import com.tsv.diz.bootstrap.Cluster;
import com.tsv.diz.model.Result;
import com.tsv.diz.model.User;
import com.tsv.diz.repository.OptionRepository;
import com.tsv.diz.repository.ResultRepository;
import com.tsv.diz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClusterNewUser implements com.tsv.diz.service.interfaces.ClusterNewUser {

    @Autowired
    private OptionRepository optionRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ResultRepository resultRepo;
    @Autowired
    private Cluster c1;

    private int count = 1;
    private int max = 1;
    private int numberCount=1;
    private double suma;
    private double media;
    private int fileNumber = 0;

    @Override
    public void clusterNewUser(Long id) throws Exception {

        fileNumber++;
        //clusterValue = 0;
        List<String> listaRezultate = new ArrayList<>();
        List<Integer> listaRezultateId = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        List<Object[]> options = optionRepo.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Object[] obj = options.get(i);
            String cautare = (String) obj[1];
            listaRezultate.add(cautare);
        }

        for (int i = 0; i < options.size(); i++) {
            Object[] obj = options.get(i);
            BigInteger result = (BigInteger) obj[0];
            int value = result.intValue();
            listaRezultateId.add(value);
        }

        count = 1;
        for (int i = 0; i < listaRezultate.size(); i++) {
            String valoare = listaRezultate.get(i);

            for (int j = 0; j < valoare.length(); j++) {
                if (valoare.charAt(j) == ',') {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
            count = 1;
        }

        for (int i = 0; i < listaRezultate.size(); i++) {
            String valoare = listaRezultate.get(i).toString();
            for (int j = 0; j < valoare.length(); j++) {

                if (valoare.charAt(j) != ',') {
                    sb.append(valoare.charAt(j));
                }
                if (valoare.charAt(j) == ',') {
                    numberCount++;
                    Double numar = Double.parseDouble(sb.toString());
                    sb = new StringBuilder();
                    suma += numar;
                }

            }
            if (numberCount == 1) {
                Double numar = Double.parseDouble(sb.toString());
                media = numar;
            } else {
                Double numar = Double.parseDouble(sb.toString());
                suma += numar;
                media = (double) (suma / numberCount);
            }
            media = Math.round(media * 1000.0) / 1000.0;
            String medieFinala = String.valueOf(media);

            if (numberCount != max) {
                int diferenta = max - numberCount;
                String str = new String(new char[diferenta]).replace("\0", "," + medieFinala);
                String valoareNoua = valoare.concat(str);
                listaRezultate.set(i, valoareNoua);
            }
            numberCount = 1;
            sb = new StringBuilder();
            suma = 0;
        }
        for (int i = 0; i < listaRezultate.size(); i++) {
            System.out.println("LIsta finala elemente: " + listaRezultate.get(i).toString());
        }
        // SCRIERE IN FISIER
        FileWriter writer = new FileWriter("outputNewUser"+ fileNumber +".arff");
        writer.write("@relation 'test'");
        writer.write(System.getProperty("line.separator"));
        writer.write(System.getProperty("line.separator"));
        for (int i = 0; i < max; i++) {
            writer.write("@attribute " + i + " numeric");
            writer.write(System.getProperty("line.separator"));
        }
        writer.write("@data");
        int size = listaRezultate.size();
        writer.write(System.getProperty("line.separator"));
        for (int i = 0; i < size; i++) {
            String str = listaRezultate.get(i).toString();
            writer.write(str);
            if (i < size - 1)// This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
        writer.close();

        // ALGORITM
        List<Integer> listaIntoarsa = c1.runAlgorithm("./outputNewUser"+ fileNumber +".arff");
        List<Result> rezultate = new ArrayList<>();
        for (int i = 0; i < listaIntoarsa.size(); i++) {
            System.out.println("LISTA INTOARSA DIM: " + listaIntoarsa.size());
            Optional<User> user = userRepo.findById(Long.valueOf(listaRezultateId.get(i)));
            System.out.println(i);
            Result result = new Result(listaIntoarsa.get(i), user.get());
            rezultate.add(result);
        }

        for(int x=0; x<rezultate.size(); x++) {

            if(rezultate.get(x).getUser().getId() == id) {
                System.out.println("Rezultat valoare user: "+rezultate.get(x).getUser().getId());
                System.out.println("Rezultat valoare id primit: "+id);
                //clusterValue = rezultate.get(x).getCluster();
//                resultRepo.updateUser(rezultate.get(x).getCluster(), id);
                resultRepo.save(rezultate.get(x));
                break;
            }
        }


    }
}
