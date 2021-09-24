package com.g3.domain;

import java.sql.Date; // MySQL과 같은 Date 자료형으로 변경

public class OrderVO {
	// 주문테이블
	private int o_num; // 주문 테이블번호
	
	
	
	// 주문정보
	private String o_d_num; // 주문번호
	private int o_p_num; // 주문한 상품번호
	private String o_p_name; // 주문한 상품이름
	private int o_p_amount; // 주문한 상품수량
	private String o_p_option; // 주문한 상품옵션
	private String u_id; // 주문한 아이디
	
	
	
	// 배송정보
	private String o_d_name; // 배송받는 사람이름
	private String o_d_add; // 배송받는 주소
	private String o_d_phone; // 배송받는 전화번호
	private String o_d_msg; // 배송 메세지
	
	
	
	// 결제정보
	private int o_sum_money; // 총 결제금액
	private String o_acc_type; // 결제종류
	private String o_acc_payer; // 결제하는 사람
	private Date o_acc_date; // 결제하는 날짜
	
	
	
	// 운송장정보
	private String o_way_num; // 운송장 번호
	private Date o_date; // 주문날짜
	private int o_status; // 주문상태
	
	
	
	// 정산처리
 	private int o_year; // 결제날짜의 연도
	private int o_month; // 결제날짜의 월
	
	
	
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getO_d_num() {
		return o_d_num;
	}
	public void setO_d_num(String o_d_num) {
		this.o_d_num = o_d_num;
	}
	public int getO_p_num() {
		return o_p_num;
	}
	public void setO_p_num(int o_p_num) {
		this.o_p_num = o_p_num;
	}
	public String getO_p_name() {
		return o_p_name;
	}
	public void setO_p_name(String o_p_name) {
		this.o_p_name = o_p_name;
	}
	public int getO_p_amount() {
		return o_p_amount;
	}
	public void setO_p_amount(int o_p_amount) {
		this.o_p_amount = o_p_amount;
	}
	public String getO_p_option() {
		return o_p_option;
	}
	public void setO_p_option(String o_p_option) {
		this.o_p_option = o_p_option;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getO_d_name() {
		return o_d_name;
	}
	public void setO_d_name(String o_d_name) {
		this.o_d_name = o_d_name;
	}
	public String getO_d_add() {
		return o_d_add;
	}
	public void setO_d_add(String o_d_add) {
		this.o_d_add = o_d_add;
	}
	public String getO_d_phone() {
		return o_d_phone;
	}
	public void setO_d_phone(String o_d_phone) {
		this.o_d_phone = o_d_phone;
	}
	public String getO_d_msg() {
		return o_d_msg;
	}
	public void setO_d_msg(String o_d_msg) {
		this.o_d_msg = o_d_msg;
	}
	public int getO_sum_money() {
		return o_sum_money;
	}
	public void setO_sum_money(int o_sum_money) {
		this.o_sum_money = o_sum_money;
	}
	public String getO_acc_type() {
		return o_acc_type;
	}
	public void setO_acc_type(String o_acc_type) {
		this.o_acc_type = o_acc_type;
	}
	public String getO_acc_payer() {
		return o_acc_payer;
	}
	public void setO_acc_payer(String o_acc_payer) {
		this.o_acc_payer = o_acc_payer;
	}
	public Date getO_acc_date() {
		return o_acc_date;
	}
	public void setO_acc_date(Date o_acc_date) {
		this.o_acc_date = o_acc_date;
	}
	public String getO_way_num() {
		return o_way_num;
	}
	public void setO_way_num(String o_way_num) {
		this.o_way_num = o_way_num;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public int getO_year() {
		return o_year;
	}
	public void setO_year(int o_year) {
		this.o_year = o_year;
	}
	public int getO_month() {
		return o_month;
	}
	public void setO_month(int o_month) {
		this.o_month = o_month;
	}
	
	
	
	@Override
	public String toString() {
		return "OrderVO [o_num=" + o_num + ", o_d_num=" + o_d_num + ", o_p_num=" + o_p_num + ", o_p_name=" + o_p_name
				+ ", o_p_amount=" + o_p_amount + ", o_p_option=" + o_p_option + ", u_id=" + u_id + ", o_d_name="
				+ o_d_name + ", o_d_add=" + o_d_add + ", o_d_phone=" + o_d_phone + ", o_d_msg=" + o_d_msg
				+ ", o_sum_money=" + o_sum_money + ", o_acc_type=" + o_acc_type + ", o_acc_payer=" + o_acc_payer
				+ ", o_acc_date=" + o_acc_date + ", o_way_num=" + o_way_num + ", o_date=" + o_date + ", o_status="
				+ o_status + ", o_year=" + o_year + ", o_month=" + o_month + "]";
	}
}
