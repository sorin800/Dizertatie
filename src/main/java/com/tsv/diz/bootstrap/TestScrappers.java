

package com.tsv.diz.bootstrap;

import com.tsv.diz.service.ScrapperPubli24Impl2;
import com.tsv.diz.service.interfaces.ScrapperAutovit;
import com.tsv.diz.service.interfaces.ScrapperOlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestScrappers implements CommandLineRunner {

    @Autowired
    private ScrapperAutovit scrapperAutovit;

    @Autowired
    private ScrapperOlx scrapperOlx;

    @Autowired
    private ScrapperPubli24Impl2 scrapperPubli24;


    @Override
    public void run(String... args) throws Exception {
//        OlxHelperClass olxHelperClass = OlxUtil.olxHelper("Alfa-Romeo", "Giulietta", "", "", "", "", "");
//        scrapperOlx.searchOlx(olxHelperClass.getMarca(), olxHelperClass.getModel(), olxHelperClass.getPretDeLa(), olxHelperClass.getPretPanaLa()
//                , olxHelperClass.getAnFabrDeLa(), olxHelperClass.getAnFabrPanaLa(), olxHelperClass.getOras());
        scrapperPubli24.searchPubli24("dacia","logan","","2009","","","",1);
    }
}


