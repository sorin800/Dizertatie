package com.tsv.diz.service.interfaces;

import java.util.List;

public interface ScrapperBestAuto {
	public List searchBestAuto(String marca, String model, String oras, String anFabrDeLa, String anFabrPanaLa,
			String pretDeLa, String pretPanaLa);

	public List numarAnuturiBestAuto(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String orasParam);
}
