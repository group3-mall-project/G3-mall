package com.g3.domain;

import java.util.Date;

public class UserVO {
	
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_email;
	private String u_phone;
	private String u_address;
	private String u_gender;
	private String u_birth;
	private String u_like;
	private Date joindate;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_birth() {
		return u_birth;
	}
	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}
	public String getU_like() {
		return u_like;
	}
	public void setU_like(String u_like) {
		this.u_like = u_like;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "UserVO [u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_email=" + u_email + ", u_phone="
				+ u_phone + ", u_address=" + u_address + ", u_gender=" + u_gender + ", u_birth=" + u_birth + ", u_like="
				+ u_like + ", joindate=" + joindate + "]";
	}
	
	
}
