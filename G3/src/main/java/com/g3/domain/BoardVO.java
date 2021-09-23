package com.g3.domain;



public class BoardVO {
	
	private int bo_num;
	private String u_id;
	private String bo_category;
	private String bo_subject;
	private String bo_content;
	private int bo_readcount;
	private int bo_re_ref;
	private int bo_re_seq;
	private String bo_updatedate;
	private int bo_p_num;
	private String bo_p_image;
	private int bo_p_rating;
	private String bo_p_thumbImg;
	public int getBo_num() {
		return bo_num;
	}
	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getBo_category() {
		return bo_category;
	}
	public void setBo_category(String bo_category) {
		this.bo_category = bo_category;
	}
	public String getBo_subject() {
		return bo_subject;
	}
	public void setBo_subject(String bo_subject) {
		this.bo_subject = bo_subject;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}
	public int getBo_readcount() {
		return bo_readcount;
	}
	public void setBo_readcount(int bo_readcount) {
		this.bo_readcount = bo_readcount;
	}
	public int getBo_re_ref() {
		return bo_re_ref;
	}
	public void setBo_re_ref(int bo_re_ref) {
		this.bo_re_ref = bo_re_ref;
	}
	public int getBo_re_lev() {
		return bo_re_lev;
	}
	public void setBo_re_lev(int bo_re_lev) {
		this.bo_re_lev = bo_re_lev;
	}
	public int getBo_re_seq() {
		return bo_re_seq;
	}
	public void setBo_re_seq(int bo_re_seq) {
		this.bo_re_seq = bo_re_seq;
	}
	public String getBo_updatedate() {
		return bo_updatedate;
	}
	public void setBo_updatedate(String bo_updatedate) {
		this.bo_updatedate = bo_updatedate;
	}
	public int getBo_p_num() {
		return bo_p_num;
	}
	public void setBo_p_num(int bo_p_num) {
		this.bo_p_num = bo_p_num;
	}
	public String getBo_p_image() {
		return bo_p_image;
	}
	public void setBo_p_image(String bo_p_image) {
		this.bo_p_image = bo_p_image;
	}
	public int getBo_p_rating() {
		return bo_p_rating;
	}
	public void setBo_p_rating(int bo_p_rating) {
		this.bo_p_rating = bo_p_rating;
	}
	public String getBo_p_thumbImg() {
		return bo_p_thumbImg;
	}
	public void setBo_p_thumbImg(String bo_p_thumbImg) {
		this.bo_p_thumbImg = bo_p_thumbImg;
	}
	@Override
	public String toString() {
		return "BoardVO [bo_num=" + bo_num + ", u_id=" + u_id + ", bo_category=" + bo_category + ", bo_subject="
				+ bo_subject + ", bo_content=" + bo_content + ", bo_readcount=" + bo_readcount + ", bo_re_ref="
				+ bo_re_ref + ", bo_re_lev=" + bo_re_lev + ", bo_re_seq=" + bo_re_seq + ", bo_updatedate="
				+ bo_updatedate + ", bo_p_num=" + bo_p_num + ", bo_p_image=" + bo_p_image + ", bo_p_rating="
				+ bo_p_rating + ", bo_p_thumbImg=" + bo_p_thumbImg + "]";
	}

	
	
	
	
	
}
