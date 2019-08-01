package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperOlxRec {

    public List searchOlxRec(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                 String anFabrPanaLa, String orasParam);
}
