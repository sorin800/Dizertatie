package com.tsv.diz.util;

public class OlxUtil {
	
	public static OlxHelperClass olxHelper(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa, String anFabrPanaLa, String oras) {
		
		OlxHelperClass olxHelperClass = new OlxHelperClass();
		
		String marcaNew = marca.toLowerCase();
		String modelNew = model.toLowerCase();
		String orasNew = oras.toLowerCase();
		
		if(modelNew.contains(" ")) {
			modelNew = modelNew.replace(" ", "-");
		}

		if(marcaNew.contains(" ")) {
			marcaNew = marcaNew.replace(" ", "-");
		}

		switch(orasNew)
		{
			case "bistrita-nasaud" :
				orasNew = "bistrita";
				break;
			case "cluj" :
				orasNew = "cluj-napoca";
				break;
			case "dolj" :
				orasNew = "craiova";
				break;
		}

		
		olxHelperClass.setMarca(marcaNew);
		olxHelperClass.setModel(modelNew);
		olxHelperClass.setPretDeLa(pretDeLa);
		olxHelperClass.setPretPanaLa(pretPanaLa);
		olxHelperClass.setAnFabrDeLa(anFabrDeLa);
		olxHelperClass.setAnFabrPanaLa(anFabrPanaLa);
		olxHelperClass.setOras(orasNew);
		
		return olxHelperClass;
		
	}
	
}
