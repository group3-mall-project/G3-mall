package com.g3.domain;

import java.sql.Timestamp;

public class Ad_ProductVO {

	private int p_num;
	private String p_name;
	private String p_category;
	private String p_option;
	private int p_price;
	private int p_amount;
	private String p_content;
	private String p_image;
	private String p_thumbimg;
	private Timestamp p_date;
	private String best;
	private int ship_date;
	private int p_return_fee;
	
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public String getP_option() {
		return p_option;
	}
	public void setP_option(String p_option) {
		this.p_option = p_option;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_amount() {
		return p_amount;
	}
	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public Timestamp getP_date() {
		return p_date;
	}
	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public int getShip_date() {
		return ship_date;
	}
	public void setShip_date(int ship_date) {
		this.ship_date = ship_date;
	}
	public int getP_return_fee() {
		return p_return_fee;
	}
	public void setP_return_fee(int p_return_fee) {
		this.p_return_fee = p_return_fee;
	}
	public String getP_thumbimg() {
		return p_thumbimg;
	}
	public void setP_thumbimg(String p_thumbimg) {
		this.p_thumbimg = p_thumbimg;
	}
	
	@Override
	public String toString() {
		return "Ad_ProductVO [p_num=" + p_num + ", p_name=" + p_name + ", p_category=" + p_category + ", p_option="
				+ p_option + ", p_price=" + p_price + ", p_amount=" + p_amount + ", p_content=" + p_content
				+ ", p_image=" + p_image + ", p_thumbimg=" + p_thumbimg + ", p_date=" + p_date + ", best=" + best
				+ ", ship_date=" + ship_date + ", p_return_fee=" + p_return_fee + "]";
	}
}
