package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperAutovit2 {

	public List searchAutovit(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam, int count);

}
