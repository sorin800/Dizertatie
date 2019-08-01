package com.tsv.diz.model.Crawlers;

public class SearchResultOlx {

	private String title;
	private String url;
	private String price;
	private String imgLink;
	private String oras;

	// CONSTRUCTORS
	public SearchResultOlx(String title) {
		this.title = title;
	}

	public SearchResultOlx(String title, String url, String price, String imgLink, String oras) {
		this.title = title;
		this.url = url;
		this.price = price;
		this.imgLink = imgLink;
		this.oras = oras;
	}

	// SETTERS AND GETTERS
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	@Override
	public String toString() {
		return "SearchResultOlx [title=" + title + ", url=" + url + ", price=" + price + ", imgLink=" + imgLink
				+ ", oras=" + oras + "]";
	}

}
