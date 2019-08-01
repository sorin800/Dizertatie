package com.tsv.diz.util;

public class CarzzUtil {

    public static CarzzHelperClass carzzHelper(String marca, String model, String pretDeLa, String pretPanaLa,
                                                     String anFabrDeLa, String anFabrPanaLa, String oras) {


        CarzzHelperClass carzzHelperClass = new CarzzHelperClass();

        String marcaNew = marca.toLowerCase();
        String modelNew = model.toLowerCase();
        String orasNew = oras.toLowerCase();
        String oras2 = "";

        if(modelNew.contains(" ")){
            modelNew = modelNew.replace(" ", "-");
        }

        switch(orasNew)
        {
            case "bucuresti" :
                orasNew = orasNew.concat("-ilfov");
                break;
        }

        if(!oras.isEmpty()){
             oras2 = "in-" + orasNew + "_";
        }



        carzzHelperClass.setMarca(marcaNew);
        carzzHelperClass.setModel(modelNew);
        carzzHelperClass.setAnFabrDeLa(anFabrDeLa);
        carzzHelperClass.setAnFabrPanaLa(anFabrPanaLa);
        carzzHelperClass.setPretDeLa(pretDeLa);
        carzzHelperClass.setPretPanaLa(pretPanaLa);
        carzzHelperClass.setOras(oras2);
        return carzzHelperClass;
    }

}
