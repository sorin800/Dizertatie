package com.tsv.diz.service.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ScrapperAuto {

    public List searchAuto(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                              String anFabrPanaLa, String orasParam);

    public List numarAnuturiAuto(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                    String anFabrPanaLa, String orasParam) throws UnsupportedEncodingException, IOException;
}
