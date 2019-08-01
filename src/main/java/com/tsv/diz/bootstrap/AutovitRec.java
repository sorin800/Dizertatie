/*
package com.tsv.diz.bootstrap;

import com.tsv.diz.model.Crawlers.SearchResultCommon;
import com.tsv.diz.service.ScrapperAutovitRecImpl;
import com.tsv.diz.service.ScrapperOlxRecImpl;
import com.tsv.diz.service.interfaces.ScrapperAutoRec;
import com.tsv.diz.service.interfaces.ScrapperBestAutoRec;
import com.tsv.diz.service.interfaces.ScrapperPubli24Rec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutovitRec implements CommandLineRunner {
    @Autowired
    private ScrapperAutovitRecImpl scrapperAutovitRec;

    @Autowired
    private ScrapperOlxRecImpl scrapperOlxRec;

    @Autowired
    private ScrapperPubli24Rec scrapperPubli24Rec;

    @Autowired
    private ScrapperBestAutoRec scrapperBestAutoRec;

    @Autowired
    private ScrapperAutoRec scrapperAutoRec;

    @Override
    public void run(String... args) throws Exception {
        List<SearchResultCommon> lista1 = scrapperAutovitRec.searchAutovitRec("dacia", "logan", "", ""
                , "", "", "");
        List<SearchResultCommon> lista2 = scrapperOlxRec.searchOlxRec("dacia", "logan", "", "", "", "", "");
        List<SearchResultCommon> lista3 = scrapperPubli24Rec.searchPubli24Rec("dacia","logan","","","","","");
        List<SearchResultCommon> lista4 = scrapperBestAutoRec.searchBestAutoRec("dacia","logan","","","","","");
        List<SearchResultCommon> lista5 = scrapperAutoRec.searchAutoRec("dacia","logan","","","","","");

    }
}
*/
