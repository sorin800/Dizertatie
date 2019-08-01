package com.tsv.diz.util;

public class AutovitUtil {

	public static AutovitHelperClass autovitHelper(String marca, String model, String pretDeLa, String pretPanaLa,
			String anFabrDeLa, String anFabrPanaLa, String oras) {

		AutovitHelperClass autovitHelperClass = new AutovitHelperClass();

		String marcaNew = marca.toLowerCase();
		String modelNew = model.toLowerCase();
		String orasNew = oras.toLowerCase();

		if (modelNew.contains(" ")) {
			modelNew = modelNew.replace(" ", "-");
		}

		if (marcaNew.contains(" ")) {
			marcaNew = marcaNew.replace(" ", "-");
		}

		switch(orasNew)
		{
			case "dolj":
				orasNew = "craiova";
				break;
			case "bistrita-nasaud" :
				orasNew = "bistrita_51359";
				break;
			case "cluj" :
				orasNew = "cluj-napoca";
				break;
			case "salaj" :
				orasNew = "salajeni";
				break;
		}
		
		autovitHelperClass.setMarca(marcaNew);
		autovitHelperClass.setModel(modelNew);
		autovitHelperClass.setPretDeLa(pretDeLa);
		autovitHelperClass.setPretPanaLa(pretPanaLa);
		autovitHelperClass.setAnFabrDeLa(anFabrDeLa);
		autovitHelperClass.setAnFabrPanaLa(anFabrPanaLa);
		autovitHelperClass.setOras(orasNew);

		return autovitHelperClass;
	}

}
