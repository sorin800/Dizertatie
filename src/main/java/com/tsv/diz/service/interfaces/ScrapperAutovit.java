package com.tsv.diz.service.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ScrapperAutovit {

	public List searchAutovit(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam);

	public List numarAnuturiAutovit(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam) throws UnsupportedEncodingException, IOException;
}
