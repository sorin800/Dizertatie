package com.tsv.diz.service;

import com.tsv.diz.model.Crawlers.SearchResultCarzz;
import com.tsv.diz.service.interfaces.ScrapperCarzz;
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
public class ScrapperCarzzImpl implements ScrapperCarzz {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
    private int pageFinalNumber = 0;
    private String number = "";
    private String poze = "";

    @Override
    public List searchCarzz(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa, String pretDeLa, String pretPanaLa) {


        try {
            Document page = Jsoup.connect("https://carzz.ro/autoturisme-" + URLEncoder.encode(marca, "UTF-8") + "-"
                    + URLEncoder.encode(model, "UTF-8") + "_" + URLEncoder.encode(oras, "UTF-8") + "pret-de-la-"
                    + URLEncoder.encode(pretDeLa, "UTF-8") + "-pana-la-" + URLEncoder.encode(pretPanaLa, "UTF-8")
                    + ".html?yf=" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "&yt="
                    + URLEncoder.encode(anFabrPanaLa, "UTF-8")).userAgent(USER_AGENT).get();

            try {
                number = page.select(".last_page").text();
                if (number != null && !number.isEmpty() && !number.equals("")) {
                    pageFinalNumber = Integer.parseInt(number);
                } else if (number.isEmpty() || number.equals("")) {
                    pageFinalNumber = 1;
                }
            } catch (NullPointerException e) {
                pageFinalNumber = 1;
            }

            List<SearchResultCarzz> lista = new ArrayList<>();
            List<String> linksImg = new ArrayList<>();

            String noAds = page.select("div[id=list_cart_wrapper]>.list_grid>span").text().toString();
            System.out.println(noAds);
            if(noAds.startsWith("Nu am găsit anunțuri conform căutării tale")){
                return lista;
            }

            for (int i = 1; i <= 1; i++) {
                String iChanging = Integer.toString(i);

//				Document page2 = Jsoup.connect("https://carzz.ro/autoturisme-" + URLEncoder.encode(query, "UTF-8") + "_"
//						+ URLEncoder.encode(iChanging, "UTF-8") + ".html").userAgent(USER_AGENT).get();

                Elements pageSearchTitle1 = page.select("div[id=list_cart_wrapper]>.list_grid>a[id^=item_]");

                Elements pageSearchTitle2 = page.select("div[id=list_cart_wrapper]>.list_grid>a[id^=promo_item]");
                System.out.println(pageSearchTitle2.size());
                if (pageSearchTitle2.size() > 0) {
                    for (int x = 0; x < pageSearchTitle2.size(); x++) {
                        String image = pageSearchTitle2.get(x).select(".placeholder>.overflow_image>img").attr("src");
                        linksImg.add(image);
                    }
                }

                // Images

                Elements pageSearchLink = page.getElementsByTag("script");
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
                    linksImg.add((String) map.get(key));
                }

                System.out.println("DIMENSIUNE LINK_URI: " + linksImg.size());
                System.out.println("DIMENSIUNE PAGESEARCH: " + pageSearchTitle1.size());
                for (int j = 0; j < pageSearchTitle1.size(); j++) {
                    String link = pageSearchTitle1.get(j).attr("href");
                    String title = pageSearchTitle1.get(j).select("span[class=title]").text();
                    String price = pageSearchTitle1.get(j).select(".price").text();
                    String city = pageSearchTitle1.get(j).select(".location_area>.location").text();

                    lista.add(new SearchResultCarzz(title, price, city, link, linksImg.get(j)));
                }

            }

            // System.out.println(lista);
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List numarAnunturiScarzz(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                    String anFabrPanaLa, String orasParam) {

        Document page = null;
        try {

            page = Jsoup.connect("https://carzz.ro/autoturisme-" + URLEncoder.encode(marca, "UTF-8") + "-"
                    + URLEncoder.encode(model, "UTF-8") + "_" + URLEncoder.encode(orasParam, "UTF-8") + "pret-de-la-"
                    + URLEncoder.encode(pretDeLa, "UTF-8") + "-pana-la-" + URLEncoder.encode(pretPanaLa, "UTF-8")
                    + ".html?yf=" + URLEncoder.encode(anFabrDeLa, "UTF-8") + "&yt="
                    + URLEncoder.encode(anFabrPanaLa, "UTF-8")).userAgent(USER_AGENT).get();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            number = page.select(".last_page").text();
            if (number != null && !number.isEmpty() && !number.equals("")) {
                pageFinalNumber = Integer.parseInt(number);
            } else if (number.isEmpty() || number.equals("")) {
                pageFinalNumber = 1;
            }
        } catch (NullPointerException e) {
            pageFinalNumber = 1;
        }

        List listaNrPagini = new ArrayList<>();
        listaNrPagini.add(pageFinalNumber);

        return listaNrPagini;
    }

}
