package com.tsv.diz.util;

public class BestAutoUtil {
	
	public static BestAutoHelperClass bestAutoHelper(String marca, String model, String pretDeLa, String pretPanaLa,
			String anFabrDeLa, String anFabrPanaLa, String oras) {
		
		BestAutoHelperClass bestAutoHelperClass = new BestAutoHelperClass();
		
		String marcaNew = marca.toLowerCase();
		String modelNew = model.toLowerCase();
		String orasNew = oras.toLowerCase();

		if (modelNew.contains(" ")) {
			modelNew = modelNew.replace(" ", "%20");
		}

		if (marcaNew.contains(" ")) {
			marcaNew = marcaNew.replace(" ", "%20");
		}


		bestAutoHelperClass.setMarca(marcaNew);
		bestAutoHelperClass.setModel(modelNew);
		bestAutoHelperClass.setPretDeLa(pretDeLa);
		bestAutoHelperClass.setPretPanaLa(pretPanaLa);
		bestAutoHelperClass.setAnFabrDeLa(anFabrDeLa);
		bestAutoHelperClass.setAnFabrPanaLa(anFabrPanaLa);
		bestAutoHelperClass.setOras(orasNew);
		
		return bestAutoHelperClass;
	}

}
