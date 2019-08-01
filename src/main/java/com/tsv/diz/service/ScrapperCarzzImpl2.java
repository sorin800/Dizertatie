package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultCarzz;
import com.tsv.diz.service.interfaces.ScrapperCarzz2;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.*;
@Service
public class ScrapperCarzzImpl2 implements ScrapperCarzz2 {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private int pageFinalNumber = 0;
    private String number = "";
    private String poze = "";

    @Override
    public List searchCarzz(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa, String anFabrPanaLa, String orasParam, int count) {

        try {
            List<SearchResultCarzz> lista = new ArrayList<>();
            List<String> linksImg = new ArrayList<>();

            for (int i = 1; i <= 1; i++) {
                String iChanging = Integer.toString(count);

                Document page2 = Jsoup.connect("https://carzz.ro/autoturisme-" + URLEncoder.encode(marca, "UTF-8") + "-"
                        + URLEncoder.encode(model, "UTF-8") + "_" + URLEncoder.encode(orasParam, "UTF-8") + "pret-de-la-"
                        + URLEncoder.encode(pretDeLa, "UTF-8") + "-pana-la-" + URLEncoder.encode(pretPanaLa, "UTF-8") +
                        "_" + URLEncoder.encode(iChanging, "UTF-8")
                        +".html?yf=" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "&yt="
                        + URLEncoder.encode(anFabrPanaLa, "UTF-8")).userAgent(USER_AGENT).get();

                Elements pageSearchTitle1 = page2.select("div[id=list_cart_wrapper]>.list_grid>a");

                Elements pageSearchTitle2 = page2.select("div[id=list_cart_wrapper]>.list_grid>a[id^=promo_item]");
                System.out.println(pageSearchTitle2.size());
                if (pageSearchTitle2.size() > 0) {
                    for (int x = 0; x < pageSearchTitle2.size(); x++) {
                        String image = pageSearchTitle2.get(x).select(".placeholder>.overflow_image>img").attr("src");
                        linksImg.add(image);
                    }
                }

                // Images

                Elements pageSearchLink = page2.getElementsByTag("script");
                for (Element element : pageSearchLink) {
                    if (element.data().contains("window['ads_imgs']")) {
                        poze = element.data();
                    }
                }

                String pozeNou = poze.replace("window['ads_imgs'] = ", "");
                String pozeNou2 = pozeNou.replaceAll("['|;|]", "");

                JSONParser parser = new JSONParser();
//					JSONObject json = (JSONObject) parser.parse(pozeNou2);

                ContainerFactory orderedKeyFactory = new ContainerFactory() {

                    public List creatArrayContainer() {
                        return new LinkedList();
                    }

                    public Map createObjectContainer() {
                        return new LinkedHashMap();
                    }

                };

                Object obj = parser.parse(pozeNou2, orderedKeyFactory);
                LinkedHashMap map = (LinkedHashMap) obj;

                for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
                    String key = (String) iterator.next();
//					    System.out.println(map.get(key));
                    linksImg.add((String) map.get(key));
                }

                System.out.println(pageSearchTitle1.size());
                for (int j = 0; j < pageSearchTitle1.size(); j++) {
                    String link = pageSearchTitle1.get(j).attr("href");
//					System.out.println(link);
                    String title = pageSearchTitle1.get(j).select("span[class=title]").text();
//					System.out.println(title);
                    String price = pageSearchTitle1.get(j).select(".price").text();
//					System.out.println(price);
                    String city = pageSearchTitle1.get(j).select(".location_area>.location").text();
//					System.out.println(city);

                    lista.add(new SearchResultCarzz(title, price, city, link, linksImg.get(j)));
                }

            }
/*
            for (int z = 0; z < lista.size(); z++) {
                System.out.println(lista.get(z).getTitle());
                System.out.println(lista.get(z).getImg());
                System.out.println(lista.get(z).getOras());
                System.out.println(lista.get(z).getPrice());
                System.out.println(lista.get(z).getUrl());
            }
*/
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
