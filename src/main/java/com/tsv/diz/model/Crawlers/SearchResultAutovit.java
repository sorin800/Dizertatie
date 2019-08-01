package com.tsv.diz.model.Crawlers;

public class SearchResultAutovit {
	
	private String img;
	private String title;
	private String url;
	private String pret;
	private String oras;
	
	// == constructors ==
	public SearchResultAutovit(String title, String url, String pret) {
		this.title = title;
		this.url = url;
		this.pret = pret;
	}

	public SearchResultAutovit(String title, String url) {;
		this.title = title;
		this.url = url;
	}
	
	public SearchResultAutovit(String img, String title, String url, String pret, String oras) {
		this.img = img;
		this.title = title;
		this.url = url;
		this.pret = pret;
		this.oras = oras;
	}

	public SearchResultAutovit() {

	}
	
	public SearchResultAutovit(String pret) {
		this.pret = pret;
	}

	//== setters and getters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPret() {
		return pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}
	
	

	@Override
	public String toString() {
		return "SearchResultAutovit [img=" + img + ", title=" + title + ", url=" + url + ", pret=" + pret + ", oras="
				+ oras + "]";
	}
	
}
