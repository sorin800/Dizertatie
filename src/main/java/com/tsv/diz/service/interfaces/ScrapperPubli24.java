package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperPubli24 {
	public List searchPubli24(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam);

	public List<Integer> numarAnuturiPubli24(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
													String anFabrPanaLa, String orasParam);
}
