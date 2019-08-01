package com.tsv.diz.util;

public class AutoUtil {

    public static AutoHelperClass autoHelper(String marca, String model, String pretDeLa, String pretPanaLa,
                                                String anFabrDeLa, String anFabrPanaLa, String oras) {


        AutoHelperClass autoHelperClass = new AutoHelperClass();

        String marcaNew = marca.toLowerCase();
        String modelNew = model.toLowerCase();
        String orasNew = oras.toLowerCase();

        if (modelNew.contains("-") || modelNew.contains(" ")) {
            if(modelNew.contains("-")){
                modelNew = modelNew.replace("-", "_");
            }else{
                modelNew = modelNew.replace(" ", "_");
            }

        }

        if (marcaNew.contains("-")) {
            marcaNew = marcaNew.replace("-", "_");
        }

        if(orasNew.contains("-")){
            orasNew = orasNew.replace("-","_");
        }


        autoHelperClass.setMarca(marcaNew);
        autoHelperClass.setModel(modelNew);
        autoHelperClass.setPretDeLa(pretDeLa);
        autoHelperClass.setPretPanaLa(pretPanaLa);
        autoHelperClass.setAnFabrDeLa(anFabrDeLa);
        autoHelperClass.setAnFabrPanaLa(anFabrPanaLa);
        autoHelperClass.setOras(orasNew);


        return autoHelperClass;

    }

}
