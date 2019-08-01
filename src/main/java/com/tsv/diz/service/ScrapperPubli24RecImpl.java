package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultCommon;
import com.tsv.diz.service.interfaces.ScrapperPubli24Rec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
@Service
public class ScrapperPubli24RecImpl implements ScrapperPubli24Rec {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private String title, price, img, url, city, result;

    @Override
    public List searchPubli24Rec(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa, String anFabrPanaLa, String orasParam) {

        List<SearchResultCommon> lista = new ArrayList<>();

        if ((anFabrDeLa.isEmpty() || anFabrPanaLa == null) && (anFabrPanaLa.isEmpty() || anFabrPanaLa == null)) {

            try {
//				Primul Caz De Iteratii

                for (int i = 1; i <= 1; i++) {
                    String iChanging = Integer.toString(i);
                    Document page2 = null;
                    page2 = Jsoup.connect("https://www.publi24.ro/anunturi/auto-moto/masini-second-hand/"
                            + URLEncoder.encode(marca, "UTF-8") + "/" + model + "/"
                            + URLEncoder.encode(orasParam, "UTF-8") + "/?carregistrationdate="
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
                        lista.add(new SearchResultCommon(title, price, result, url, city));
                    }
                }
                return lista;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else if (!anFabrDeLa.isEmpty() && anFabrPanaLa.isEmpty()) {
            for(int i = Integer.parseInt(anFabrDeLa); i <= 2018; i++){
                String anFabrDeLaConverted = Integer.toString(i);
                try {

                    for (int j = 1; j <= 1; j++) {
                        String iChanging = Integer.toString(i);
                        Document page2 = null;
                        page2 = Jsoup.connect("https://www.publi24.ro/anunturi/auto-moto/masini-second-hand/"
                                + URLEncoder.encode(marca, "UTF-8") + "/" + URLEncoder.encode(model, "UTF-8") + "/"
                                + URLEncoder.encode(orasParam, "UTF-8") + "/?carregistrationdate="
                                + URLEncoder.encode(anFabrDeLaConverted, "UTF-8") + "&minprice="
                                + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                                + URLEncoder.encode(pretPanaLa, "UTF-8") + "&pagesize=150&pag="
                                + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();



                        Elements pageSearch = page2.select(".listing.radius > li[itemtype=https://schema.org/Offer]");

                        for (int k = 0; k < pageSearch.size(); k++) {
                            title = pageSearch.get(k).select("a[itemprop=name]").text();
                            price = pageSearch.get(k).select("strong[class~=price]").text();
                            city = pageSearch.get(k).select("span[itemprop=name]").text();
                            img = pageSearch.get(k).select(".listing-image").attr("style");
                            url = pageSearch.get(k).select(".listing-image").attr("href");
                            result = img.substring(22, img.length() - 3);
                            lista.add(new SearchResultCommon(title, price, result, url, city));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return lista;
        } else if (!anFabrDeLa.isEmpty() && !anFabrPanaLa.isEmpty()) {

            for (int i = Integer.parseInt(anFabrDeLa); i <= Integer.parseInt(anFabrPanaLa); i++) {

                String anFabrDeLaConverted = Integer.toString(i);

                try {

                    for (int j = 1; j <= 1; j++) {
                        String iChanging = Integer.toString(i);
                        Document page2 = null;
                        page2 = Jsoup.connect("https://www.publi24.ro/anunturi/auto-moto/masini-second-hand/"
                                + URLEncoder.encode(marca, "UTF-8") + "/" + URLEncoder.encode(model, "UTF-8") + "/"
                                + URLEncoder.encode(orasParam, "UTF-8") + "/?carregistrationdate="
                                + URLEncoder.encode(anFabrDeLaConverted, "UTF-8") + "&minprice="
                                + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                                + URLEncoder.encode(pretPanaLa, "UTF-8") + "&pagesize=150&pag="
                                + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();

                        Elements pageSearch = page2.select(".listing.radius > li[itemtype=https://schema.org/Offer]");

                        for (int k = 0; k < pageSearch.size(); k++) {
                            title = pageSearch.get(k).select("a[itemprop=name]").text();
                            price = pageSearch.get(k).select("strong[class~=price]").text();
                            city = pageSearch.get(k).select("span[itemprop=name]").text();
                            img = pageSearch.get(k).select(".listing-image").attr("style");
                            url = pageSearch.get(k).select(".listing-image").attr("href");
                            result = img.substring(22, img.length() - 3);
                            lista.add(new SearchResultCommon(title, price, result, url, city));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return lista;

        } else if (anFabrDeLa.isEmpty() && !anFabrPanaLa.isEmpty()) {

            for (int i = 2000; i <= Integer.parseInt(anFabrPanaLa); i++) {
                String anFabrDeLaConverted = Integer.toString(i);

                try {
                    for (int j = 1; j <= 1; j++) {
                        String iChanging = Integer.toString(i);
                        Document page2 = null;
                        page2 = Jsoup.connect("https://www.publi24.ro/anunturi/auto-moto/masini-second-hand/"
                                + URLEncoder.encode(marca, "UTF-8") + "/" + URLEncoder.encode(model, "UTF-8") + "/"
                                + URLEncoder.encode(orasParam, "UTF-8") + "/?carregistrationdate="
                                + URLEncoder.encode(anFabrDeLaConverted, "UTF-8") + "&minprice="
                                + URLEncoder.encode(pretDeLa, "UTF-8") + "&maxprice="
                                + URLEncoder.encode(pretPanaLa, "UTF-8") + "&pagesize=150&pag="
                                + URLEncoder.encode(iChanging, "UTF-8")).userAgent(USER_AGENT).get();


                        Elements pageSearch = page2.select(".listing.radius > li[itemtype=https://schema.org/Offer]");

                        for (int k = 0; k < pageSearch.size(); k++) {
                            title = pageSearch.get(k).select("a[itemprop=name]").text();
                            price = pageSearch.get(k).select("strong[class~=price]").text();
                            city = pageSearch.get(k).select("span[itemprop=name]").text();
                            img = pageSearch.get(k).select(".listing-image").attr("style");
                            url = pageSearch.get(k).select(".listing-image").attr("href");
                            result = img.substring(22, img.length() - 3);
                            lista.add(new SearchResultCommon(title, price, result, url, city));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return lista;
        }

        return null;
    }
}
