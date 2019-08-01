package com.tsv.diz.util;

public class AutovitHelperClass {
	
	private String marca;
	private String model;
	private String pretDeLa;
	private String pretPanaLa;
	private String anFabrDeLa;
	private String anFabrPanaLa;
	private String oras;
	
	public AutovitHelperClass(String marca, String model, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa, String oras) {
		this.marca = marca;
		this.model = model;
		this.pretDeLa = pretDeLa;
		this.pretPanaLa = pretPanaLa;
		this.anFabrDeLa = anFabrDeLa;
		this.anFabrPanaLa = anFabrPanaLa;
		this.oras = oras;
	}
	
	
	public AutovitHelperClass() {
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPretDeLa() {
		return pretDeLa;
	}
	public void setPretDeLa(String pretDeLa) {
		this.pretDeLa = pretDeLa;
	}
	public String getPretPanaLa() {
		return pretPanaLa;
	}
	public void setPretPanaLa(String pretPanaLa) {
		this.pretPanaLa = pretPanaLa;
	}
	public String getAnFabrDeLa() {
		return anFabrDeLa;
	}
	public void setAnFabrDeLa(String anFabrDeLa) {
		this.anFabrDeLa = anFabrDeLa;
	}
	public String getAnFabrPanaLa() {
		return anFabrPanaLa;
	}
	public void setAnFabrPanaLa(String anFabrPanaLa) {
		this.anFabrPanaLa = anFabrPanaLa;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	
	

}
