package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultCommon;
import com.tsv.diz.service.interfaces.ScrapperOlxRec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScrapperOlxRecImpl implements ScrapperOlxRec {

    // ScrapperOlx,
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";

    @Override
    public List searchOlxRec(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa
            , String anFabrPanaLa, String orasParam) {
        Document page = null;
        try {

            List<SearchResultCommon> resultList1 = new ArrayList<SearchResultCommon>();

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


//                Elements pageSearch = page2.select(".fixed.offers.breakword.offers--top.redesigned > tbody > .wrap");
                Elements pageSearch2 = page2.select(".fixed.offers.breakword.redesigned > tbody > .wrap");
                Elements pageSearch3 = page2.select(".wrapper > .content");
                System.out.println(pageSearch3.select(".c41.lheight24").text());

                if ((pageSearch3.select(".c41.lheight24").text()).equals("Ne pare rau. Nu am gasit rezultate.")) {
                    System.out.println("A intrat aici");
                    return resultList1;
                }

//                String imgSrc = "";
                String imgSrc2 = "";

/*

                for (j = 0; j < pageSearch.size(); j++) {
                    String title = pageSearch.get(j).select("td > .offer-wrapper > table > tbody > tr >.title-cell > .space.rel > h3 > a > strong").text();
                    String price = pageSearch.get(j).select("td > .offer-wrapper > table > tbody > tr >.wwnormal.tright.td-price > div > .price > strong").text();
                    String city = pageSearch.get(j).select(".breadcrumb.x-normal > span").get(0).text();
                    String url = pageSearch.get(j).select("td > .offer-wrapper > table > tbody > tr > td[width=150] > a").attr("href");

                    boolean withoutImage = pageSearch.get(j).hasClass(".nophoto");
                    if (!withoutImage) {
                        imgSrc = pageSearch.get(j).select("td > .offer-wrapper > table > tbody > tr > td[width=150] > a > img").attr("src");
                        if (imgSrc.isEmpty()) {
                            imgSrc = "https://s3.publi24.ro/vertical-ro-f646bd5a/no_img.gif";
                        }
                    } else {
                        imgSrc = "https://s3.publi24.ro/vertical-ro-f646bd5a/no_img.gif";
                    }

                    resultList1.add(new SearchResultCommon(title, price, imgSrc, url, city));
                }
*/

                for (int k = 0; k < pageSearch2.size(); k++) {
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

                    resultList1.add(new SearchResultCommon(title2, price2, imgSrc2, url2, city2));
                }

            }

            // REINITIALIZATIONS
            System.out.println(resultList1);
            return resultList1;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
