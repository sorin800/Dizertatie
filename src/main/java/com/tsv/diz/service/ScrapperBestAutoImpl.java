package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultBestAuto;
import com.tsv.diz.service.interfaces.ScrapperBestAuto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ScrapperBestAutoImpl implements ScrapperBestAuto {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private String lastPage = "";
    private int pageFinalNumber;
    private int countShow;
    private String title, price, city, url, result, img;

    @Override
    public List searchBestAuto(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa,
                               String pretDeLa, String pretPanaLa) {

        List<SearchResultBestAuto> lista = new ArrayList<>();

        try {
            for (int i = 1; i <= 1; i++) {
                String iChanging = Integer.toString(i);
                Document page2 = null;
                page2 = Jsoup.connect("https://www.bestauto.ro/auto/" + URLEncoder.encode(marca, "UTF-8") + "/"
                        + model + "/" + URLEncoder.encode(oras, "UTF-8")
                        + "/?carregistrationdate=" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "-"
                        + URLEncoder.encode(anFabrPanaLa, "UTF-8") + "&pag=" + URLEncoder.encode(iChanging, "UTF-8")
                        + "&pagesize=50&" + "minprice=" + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                        + URLEncoder.encode(pretPanaLa, "UTF-8")).userAgent(USER_AGENT).get();

                Elements pageSearch = page2.select(".listing.radius > li[itemtype=https://schema.org/Offer]");

                for (int j = 0; j < pageSearch.size(); j++) {
                    title = pageSearch.get(j).select("a[itemprop=name]").text();
                    price = pageSearch.get(j).select("strong[class~=price]").text();
                    city = pageSearch.get(j).select("span[itemprop=name]").text();
                    img = pageSearch.get(j).select(".listing-image").attr("style");
                    url = pageSearch.get(j).select(".listing-image").attr("href");
                    result = img.substring(22, img.length() - 3);
                    lista.add(new SearchResultBestAuto(title, price, result, url, city));
                }
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List numarAnuturiBestAuto(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa,
                                     String pretDeLa, String pretPanaLa) {

        List listaNrPaginiBestAuto = new ArrayList<>();

            try {
                Document page = Jsoup.connect("https://www.bestauto.ro/auto/" + URLEncoder.encode(marca, "UTF-8") + "/"
                        + model + "/" + URLEncoder.encode(oras, "UTF-8")
                        + "/?carregistrationdate=" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "-"
                        + URLEncoder.encode(anFabrPanaLa, "UTF-8")
                        + "&pagesize=50&" + "minprice=" + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                        + URLEncoder.encode(pretPanaLa, "UTF-8")).userAgent(USER_AGENT).get();

                Elements pageSearchPageNumber = page.select("ul[class=pagination radius] > li");
                // System.out.println(pageSearchPageNumber.size());

                if (pageSearchPageNumber.size() == 0) {
                    pageFinalNumber = 1;
                } else {
                    for (int i = 0; i < pageSearchPageNumber.size() - 1; i++) {
                        lastPage = pageSearchPageNumber.get(i).text();
                        // System.out.println(lastPage);
                    }
                    pageFinalNumber = Integer.parseInt(lastPage);
                }

                listaNrPaginiBestAuto.add(pageFinalNumber);
                System.out.println("PAGINI BESTAUTO: " + pageFinalNumber);
                return listaNrPaginiBestAuto;
            } catch (Exception e) {
                e.printStackTrace();
            }

        return Collections.emptyList();
    }

}
