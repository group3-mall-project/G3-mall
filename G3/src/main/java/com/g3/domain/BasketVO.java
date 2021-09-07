package com.g3.domain;

import java.sql.Date;

public class BasketVO {

	private int b_num; // 장바구니 번호
	private String u_id; // 회원아이디
	private int b_p_num; // 상품번호
	private int b_p_amount; // 상품수량
	private String b_p_option; // 상품옵션
	private String b_p_price; // 상품가격
	private Date b_date; // 장반구니담은날짜

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getB_p_num() {
		return b_p_num;
	}

	public void setB_p_num(int b_p_num) {
		this.b_p_num = b_p_num;
	}

	public int getB_p_amount() {
		return b_p_amount;
	}

	public void setB_p_amount(int b_p_amount) {
		this.b_p_amount = b_p_amount;
	}

	public String getB_p_option() {
		return b_p_option;
	}

	public void setB_p_option(String b_p_option) {
		this.b_p_option = b_p_option;
	}

	public String getB_p_price() {
		return b_p_price;
	}

	public void setB_p_price(String b_p_price) {
		this.b_p_price = b_p_price;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	@Override
	public String toString() {
		return "BasketVO [b_num=" + b_num + ", u_id=" + u_id + ", b_p_num=" + b_p_num + ", b_p_amount=" + b_p_amount
				+ ", b_p_option=" + b_p_option + ", b_p_price=" + b_p_price + ", b_date=" + b_date + "]";
	}

}
