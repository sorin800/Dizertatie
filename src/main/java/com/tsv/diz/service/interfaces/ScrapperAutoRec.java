package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperAutoRec {

    public List searchAutoRec(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                 String anFabrPanaLa, String orasParam);
}
