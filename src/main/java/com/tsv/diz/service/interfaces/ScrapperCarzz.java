package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperCarzz {

    public List searchCarzz(String marca, String model, String oras, String anFabrDeLa,
                            String anFabrPanaLa, String pretDeLa, String pretPanaLa);

    public List numarAnunturiScarzz(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
                                    String anFabrPanaLa, String orasParam);

}
