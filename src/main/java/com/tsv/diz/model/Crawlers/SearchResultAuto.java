package com.tsv.diz.model.Crawlers;

public class SearchResultAuto {

	private String title;
	private String price;
	private String oras;
	private String url;
	private String img;
	

	public SearchResultAuto(String title, String price, String oras, String url, String img) {
		this.title = title;
		this.price = price;
		this.oras = oras;
		this.url = url;
		this.img = img;
	}

	public SearchResultAuto(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "SearchResultAuto [title=" + title + ", price=" + price + ", oras=" + oras + ", url=" + url + ", img="
				+ img + "]";
	}

}
