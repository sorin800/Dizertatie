package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultCommon;
import com.tsv.diz.service.interfaces.ScrapperAutovitRec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScrapperAutovitRecImpl implements ScrapperAutovitRec {

    private String lastPage = "";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private int pageFinalNumber;
    public String pretDeLa = "";
    public String pretPanaLa = "";
    public String anFabrDeLa = "";
    public String anFabrPanaLa = "";
    public String orasParam = "";
    private int countShow;

    private String img = "";
    private String price = "";
    private String city = "";
    private String url = "";
	private String title = "";

    @Override
    public List searchAutovitRec(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                 String anFabrPanaLa, String orasParam) {
        System.out.println(marca + model + pretDeLa + pretPanaLa + anFabrDeLa + anFabrPanaLa + orasParam);
        try {
            List<SearchResultCommon> resultList1 = new ArrayList<SearchResultCommon>();

                for (int i = 1; i <= 1; i++) {
                    String iChanging = Integer.toString(i);
                    Document page2 = null;
                    if (!anFabrDeLa.isEmpty()) {
                        page2 = Jsoup.connect("https://www.autovit.ro/autoturisme/" + URLEncoder.encode(marca, "UTF-8")
                                + "/" + URLEncoder.encode(model, "UTF-8") + "/" + "de-la-"
                                + URLEncoder.encode(anFabrDeLa, "UTF-8") + "/" + URLEncoder.encode(orasParam, "UTF-8") + "/"
                                + "?search%5Bfilter_float_price%3Afrom%5D=" + URLEncoder.encode(pretDeLa, "UTF-8")
                                + "&search%5Bfilter_float_price%3Ato%5D=" + URLEncoder.encode(pretPanaLa, "UTF-8")
                                + "&search%5Bfilter_float_year%3Ato%5D=" + URLEncoder.encode(anFabrPanaLa, "UTF-8")
                                + "&page=" + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();
                    } else {
                        page2 = Jsoup.connect("https://www.autovit.ro/autoturisme/" + URLEncoder.encode(marca, "UTF-8")
                                + "/" + URLEncoder.encode(model, "UTF-8") + "/" + URLEncoder.encode(orasParam, "UTF-8")
                                + "/" + "?search%5Bfilter_float_price%3Afrom%5D=" + URLEncoder.encode(pretDeLa, "UTF-8")
                                + "&search%5Bfilter_float_price%3Ato%5D=" + URLEncoder.encode(pretPanaLa, "UTF-8")
                                + "&search%5Bfilter_float_year%3Ato%5D=" + URLEncoder.encode(anFabrPanaLa, "UTF-8")
                                + "&page=" + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();
                    }

                    System.out.println(page2.select(".criteriaChangeWarning > span").text());
                    if ((page2.select(".criteriaChangeWarning > span").text()).equals("Nu sunt suficiente rezultate in zona selectata. Am marit aria de cautare pentru a-ti putea afisa mai multe anunturi relevante.")) {
                        return resultList1;
                    }

                    Elements pageSearchPrice = page2.select("article[class~=adListingItem]");
                    for (int j = 0; j < pageSearchPrice.size(); j++) {
                        price = pageSearchPrice.get(j).select(".offer-item__content > .offer-item__price > .offer-price > .offer-price__number").text();
                        title = pageSearchPrice.get(j).select(".offer-item__content > .offer-item__title > .offer-title > a").text();
                        city = pageSearchPrice.get(j).select(".offer-item__content > .offer-item__bottom-row > div[class~=fright] > .offer-item__location > h4").text();
                        url = pageSearchPrice.get(j).select(".offer-item__photo > a").attr("href");

                        boolean withImage = pageSearchPrice.get(j).select(".offer-item__photo > a[class=offer-item__photo-link] > img").hasAttr("data-srcset");
                        if (!withImage) {
//							resultList1.get(jdex).setImg("NoPhoto");
                            img = "No-Photo";
                        } else {
                            img = pageSearchPrice.get(j).select(".offer-item__photo > a[class=offer-item__photo-link] > img").attr("data-srcset");

                        }


                        resultList1.add(new SearchResultCommon(title,price,img,url,city));
                    }
                }
            System.out.println(resultList1);
                return resultList1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

