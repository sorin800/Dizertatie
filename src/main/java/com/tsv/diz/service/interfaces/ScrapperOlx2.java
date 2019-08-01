package com.tsv.diz.service.interfaces;

import java.util.List;


public interface ScrapperOlx2 {
	public List searchOlx(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam, int count);
}
