package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultOlx;
import com.tsv.diz.service.interfaces.ScrapperOlx;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ScrapperOlxImplementation implements ScrapperOlx {
    // ScrapperOlx,
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    // private final String query = "dacia";
    private String lastPage = "";
    private int pageFinalNumber;
    private int k, j;
    private int countShow;

    @Override
    public List searchOlx(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                          String anFabrPanaLa, String orasParam) {
        Document page = null;
        try {

            List<SearchResultOlx> list = new ArrayList<>();

            for (int i = 1; i <= 1; i++) {
                String iChanging = Integer.toString(i);

                Document page2 = Jsoup.connect("https://www.olx.ro/auto-masini-moto-ambarcatiuni/autoturisme/"
                        + URLEncoder.encode(marca, "UTF-8") + "/" + URLEncoder.encode(model, "UTF-8") + "/"
                        + URLEncoder.encode(orasParam, "UTF-8") + "/?search%5Bfilter_float_price%3Afrom%5D="
                        + URLEncoder.encode(pretDeLa, "UTF-8") + "&search%5Bfilter_float_price%3Ato%5D="
                        + URLEncoder.encode(pretPanaLa, "UTF-8") + "&search%5Bfilter_float_year%3Afrom%5D="
                        + URLEncoder.encode(anFabrDeLa, "UTF-8") + "&search%5Bfilter_float_year%3Ato%5D="
                        + URLEncoder.encode(anFabrPanaLa, "UTF-8") + "&page=" + URLEncoder.encode(iChanging, "UTF-8"))
                        .get();



                Elements pageSearch2 = page2.select(".fixed.offers.breakword.redesigned > tbody > .wrap");
                Elements pageSearch3 = page2.select(".wrapper > .content");

                if ((pageSearch3.select(".c41.lheight24").text()).equals("Ne pare rau. Nu am gasit rezultate.")) {
                    System.out.println("A intrat aici");
                    return list;
                }

                String imgSrc2 = "";


                for (k = 0; k < pageSearch2.size(); k++) {
                    String title2 = pageSearch2.get(k).select("td > .offer-wrapper > table > tbody > tr >.title-cell > .space.rel > h3 > a > strong").text();
                    String price2 = pageSearch2.get(k).select("td > .offer-wrapper > table > tbody > tr >.wwnormal.tright.td-price > div > .price > strong").text();
                    String city2 = pageSearch2.get(k).select(".breadcrumb.x-normal > span").get(0).text();
                    String url2 = pageSearch2.get(k).select("td > .offer-wrapper > table > tbody > tr > td[width=150] > a").attr("href");

                    boolean withoutImage = pageSearch2.get(k).hasClass(".nophoto");
                    if (!withoutImage) {
                        imgSrc2 = pageSearch2.get(k).select("td > .offer-wrapper > table > tbody > tr > td[width=150] > a > img").attr("src");
                        if (imgSrc2.isEmpty()) {
                            imgSrc2 = "https://s3.publi24.ro/vertical-ro-f646bd5a/no_img.gif";
                        }
                    } else {
                        imgSrc2 = "https://s3.publi24.ro/vertical-ro-f646bd5a/no_img.gif";

                    }

                    list.add(new SearchResultOlx(title2, url2, price2, imgSrc2, city2));
                }

            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        //return Collections.emptyList();

    }


    @Override
    public List numarAnunturiOlx(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                 String anFabrPanaLa, String orasParam) throws UnsupportedEncodingException, IOException {

        Document page = null;
        try {

            page = Jsoup.connect(
                    "https://www.olx.ro/auto-masini-moto-ambarcatiuni/autoturisme/" + URLEncoder.encode(marca, "UTF-8")
                            + "/" + URLEncoder.encode(model, "UTF-8") + "/" + URLEncoder.encode(orasParam, "UTF-8")
                            + "/?search%5Bfilter_float_price%3Afrom%5D=" + URLEncoder.encode(pretDeLa, "UTF-8")
                            + "&search%5Bfilter_float_price%3Ato%5D=" + URLEncoder.encode(pretPanaLa, "UTF-8")
                            + "&search%5Bfilter_float_year%3Afrom%5D=" + URLEncoder.encode(anFabrDeLa, "UTF-8")
                            + "&search%5Bfilter_float_year%3Ato%5D=" + URLEncoder.encode(anFabrPanaLa, "UTF-8"))
                    .get();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            lastPage = page.select(".item.fleft").last().text();
            if (lastPage != null) {
                pageFinalNumber = Integer.parseInt(lastPage);
            }
        } catch (NullPointerException e) {
            pageFinalNumber = 1;
        }

        List listaNrPagini = new ArrayList<>();
        listaNrPagini.add(pageFinalNumber);
        return listaNrPagini;
    }
}
