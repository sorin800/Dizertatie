package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultAuto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapperAuto implements com.tsv.diz.service.interfaces.ScrapperAuto {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private int pageFinalNumber;

    @Override
    public List searchAuto(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa,
                           String pretDeLa, String pretPanaLa) {

        System.out.println("Marca in auto: " + marca);
        System.out.println("Model in auto: " + model);

        if (anFabrDeLa.isEmpty() || anFabrDeLa == null) {
            anFabrDeLa = "1900";
        }

        if (pretDeLa.isEmpty() || pretDeLa == null) {
            pretDeLa = "0";
        }

        try {
/*
            Document page = Jsoup.connect("http://auto.ro/" + URLEncoder.encode(marca, "UTF-8") + "-" + URLEncoder.encode(model, "UTF-8")
                    + "/" + URLEncoder.encode(oras, "UTF-8") + "-pret~" + URLEncoder.encode(pretDeLa, "UTF-8") + "_"
                    + URLEncoder.encode(pretPanaLa, "UTF-8") + "-an~" + URLEncoder.encode(anFabrDeLa, "UTF-8")
                    + "_" + URLEncoder.encode(anFabrPanaLa, "UTF-8") + ".html"
            ).userAgent(USER_AGENT)
                    .get();

            try {
                String ceva = page.select("#paginatie > a[title=ultima pagina]").attr("href").toString();
                String numar2 = ceva.substring(ceva.lastIndexOf("-") + 1).trim();
                System.out.println("Ce extrage:" + numar2);
                String numberOnly = numar2.replaceAll("[^0-9]", "");
                pageFinalNumber = Integer.parseInt(numberOnly);

            } catch (Exception e) {
                pageFinalNumber = 1;
            }
*/

//			 System.out.println("Nr pagini: "+pageFinalNumber);

            List<SearchResultAuto> lista = new ArrayList<>();

            for (int i = 1; i <= 1; i++) {
                String iChanging = Integer.toString(i);

                Document page2 = Jsoup
                        .connect("http://auto.ro/" + URLEncoder.encode(marca, "UTF-8") + "-" + URLEncoder.encode(model, "UTF-8") +
                                "/" + URLEncoder.encode(oras, "UTF-8") + "-pret~"
                                + URLEncoder.encode(pretDeLa, "UTF-8") + "_" + URLEncoder.encode(pretPanaLa, "UTF-8") +
                                "-an~" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "_" + URLEncoder.encode(anFabrPanaLa, "UTF-8") + "-pagina-"
                                + URLEncoder.encode(iChanging, "UTF-8") + ".html")
                        .userAgent(USER_AGENT).get();

                        //auto.ro/dacia-logan/-pret~2000_-an~1900_2012-pagina-1.html

                Elements pageSearchTitle1 = page2.select(".listing_cars.listing_cars_red > .listing_cars.listing_cars_red");

                for (int j = 0; j < pageSearchTitle1.size(); j++) {

                    String title = pageSearchTitle1.get(j).select(".red_offer > .right > h2 > a").text();
                    String pret = pageSearchTitle1.get(j).select(".red_offer > .right > span[class~=list_pret]").text();
                    String city = pageSearchTitle1.get(j).select(".red_offer > .right > .zoom_list > div[class=listing_flag]").attr("fori");
                    String img = pageSearchTitle1.get(j).select(".red_offer > a[class=car_img] > img").attr("src");
                    String url = pageSearchTitle1.get(j).select(".red_offer > a[class=car_img]").attr("href");
                    lista.add(new SearchResultAuto(title, pret, city, url, img));
                }

                Elements pageSearchTitle2 = page2.select("div[class=listing_cars]");
                for (int k = 0; k < pageSearchTitle2.size(); k++) {
                    String title = pageSearchTitle2.get(k).select("div[class~=offer] > .right > h2 > a").text();
                    String pret = pageSearchTitle2.get(k).select("div[class~=offer] > .right > span[class~=list_pret]").text();
                    String city = pageSearchTitle2.get(k).select("div[class~=offer] > .right > .zoom_list > div[class=listing_flag]").attr("fori");
                    String img = pageSearchTitle2.get(k).select("div[class~=offer] > a[class=car_img] > img").attr("src");
                    String url = pageSearchTitle2.get(k).select("div[class~=offer] > a[class=car_img]").attr("href");
                    lista.add(new SearchResultAuto(title, pret, city, url, img));
                }

            }

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List numarAnuturiAuto(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa, String anFabrPanaLa, String orasParam) throws UnsupportedEncodingException, IOException {


        if (anFabrDeLa.isEmpty() || anFabrDeLa == null) {
            anFabrDeLa = "1900";
        }

        if (pretDeLa.isEmpty() || pretDeLa == null) {
            pretDeLa = "0";
        }

        Document page = null;
        try {

            page = Jsoup.connect("http://auto.ro/" + URLEncoder.encode(marca, "UTF-8") + "-" + URLEncoder.encode(model, "UTF-8")
                    + "/" + URLEncoder.encode(orasParam, "UTF-8") + "-pret~" + URLEncoder.encode(pretDeLa, "UTF-8") + "_"
                    + URLEncoder.encode(pretPanaLa, "UTF-8") + "-an~" + URLEncoder.encode(anFabrDeLa, "UTF-8")
                    + "_" + URLEncoder.encode(anFabrPanaLa, "UTF-8") + ".html"
            ).userAgent(USER_AGENT)
                    .get();


        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            String ceva = page.select("#paginatie > a[title=ultima pagina]").attr("href").toString();
            String numar2 = ceva.substring(ceva.lastIndexOf("-") + 1).trim();
            System.out.println("Ce extrage:" + numar2);
            String numberOnly = numar2.replaceAll("[^0-9]", "");
            pageFinalNumber = Integer.parseInt(numberOnly);
        }catch(Exception e){
            pageFinalNumber = 1;
        }

        List listaNrPagini = new ArrayList<>();
        listaNrPagini.add(pageFinalNumber);

        return listaNrPagini;
    }
}
