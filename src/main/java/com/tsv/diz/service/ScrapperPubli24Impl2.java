package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultPubli24;
import com.tsv.diz.service.interfaces.ScrapperPubli242;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapperPubli24Impl2 implements ScrapperPubli242 {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private String lastPage = "";
    private int pageFinalNumber;
    private String title, price, img, url, city, result;

    @Override
    public List searchPubli24(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa,
                              String pretDeLa, String pretPanaLa, int count) {

        List<SearchResultPubli24> lista = new ArrayList<>();
        if (anFabrDeLa.isEmpty() && anFabrPanaLa.isEmpty()) {
            try {
                for (int i = 1; i <= 1; i++) {
                    String iChanging = Integer.toString(count);
                    Document page2 = null;
                    page2 = Jsoup.connect("https://www.publi24.ro/anunturi/auto-moto/masini-second-hand/"
                            + URLEncoder.encode(marca, "UTF-8") + "/" + model + "/"
                            + URLEncoder.encode(oras, "UTF-8") + "/?carregistrationdate="
                            + URLEncoder.encode(anFabrDeLa, "UTF-8") + "&minprice="
                            + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                            + URLEncoder.encode(pretPanaLa, "UTF-8") + "&pagesize=50&pag="
                            + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();

                    Elements pageSearch = page2.select(".listing.radius > li[itemtype=https://schema.org/Offer]");

                    for (int j = 0; j < pageSearch.size(); j++) {
                        title = pageSearch.get(j).select("a[itemprop=name]").text();
                        price = pageSearch.get(j).select("strong[class~=price]").text();
                        city = pageSearch.get(j).select("span[itemprop=name]").text();
                        img = pageSearch.get(j).select(".listing-image").attr("style");
                        url = pageSearch.get(j).select(".listing-image").attr("href");
                        result = img.substring(22, img.length() - 3);
                        lista.add(new SearchResultPubli24(title, price, result, url, city));
                    }

                }

                return lista;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
