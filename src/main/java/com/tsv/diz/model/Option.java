package com.tsv.diz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="marca")
	private String marca;
	
	@Column(name="model")
	private String model;
	
	@Column(name="an_fabr_de_la")
	private String anFabrDeLa;
	@Column(name="an_fabr_pana_la")
	private String anFabrPanaLa;
	@Column(name="pret_de_la")
	private String pretDeLa;
	@Column(name="pret_pana_la")
	private String pretPanaLa;
	@Column(name="oras")
	private String oras;
	@Column(name="scor")
	private double score;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Option() {

	}

	public Option(String marca, String model, String anFabrDeLa, String anFabrPanaLa, String pretDeLa,
			String pretPanaLa, String oras, double score, User user) {
		this.marca = marca;
		this.model = model;
		this.anFabrDeLa = anFabrDeLa;
		this.anFabrPanaLa = anFabrPanaLa;
		this.pretDeLa = pretDeLa;
		this.pretPanaLa = pretPanaLa;
		this.oras = oras;
		this.score = score;
		this.user = user;
	}

	public Option(int id, String marca, String model, String anFabrDeLa, String anFabrPanaLa, String pretDeLa,
			String pretPanaLa, String oras, double score, User user) {
		this.id = id;
		this.marca = marca;
		this.model = model;
		this.anFabrDeLa = anFabrDeLa;
		this.anFabrPanaLa = anFabrPanaLa;
		this.pretDeLa = pretDeLa;
		this.pretPanaLa = pretPanaLa;
		this.oras = oras;
		this.score = score;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", marca=" + marca + ", model=" + model + ", anFabrDeLa=" + anFabrDeLa
				+ ", anFabrPanaLa=" + anFabrPanaLa + ", pretDeLa=" + pretDeLa + ", pretPanaLa=" + pretPanaLa + ", oras="
				+ oras + ", score=" + score + "]";
	}

}
