package com.tsv.diz.model.Crawlers;

public class SearchResultPubli24 {

	private String title;
	private String price;
	private String img;
	private String url;
	private String city;

	public SearchResultPubli24(String title) {
		this.title = title;
	}
	
	public SearchResultPubli24(String title, String price, String img, String url, String city) {
		this.title = title;
		this.price = price;
		this.img = img;
		this.url = url;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "SearchResultPubli24 [title=" + title + ", price=" + price + ", img=" + img + ", url=" + url + ", city="
				+ city + "]";
	}

}
