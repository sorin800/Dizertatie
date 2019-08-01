package com.tsv.diz.model.Crawlers;

public class SearchResultAutoUncle {

	private String title;
	private String price;
	private String url;
	private String img;
	private String city;

	public SearchResultAutoUncle(String title) {
		this.title = title;
	}

	public SearchResultAutoUncle(String title, String price, String url, String img, String city) {
		this.title = title;
		this.price = price;
		this.url = url;
		this.img = img;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "SearchResultAutoUncle [title=" + title + ", price=" + price + ", url=" + url + ", img=" + img
				+ ", city=" + city + "]";
	}

}
