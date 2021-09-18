package com.g3.domain;

//  주문검색을 표현하는 객체
public class OrderSearchVO {
	// 모두 문자열로 넘어오기 때문에 String
	private String inquiryPeriod; // 조회기간
	private String beginningDate; // 시작날
	private String endDate; // 끝날
	private String advancedSearch; // 상세조건
	private String userQuery; // 사용자 질의
	
	
	
	public String getInquiryPeriod() {
		return inquiryPeriod;
	}
	public void setInquiryPeriod(String inquiryPeriod) {
		this.inquiryPeriod = inquiryPeriod;
	}
	public String getBeginningDate() {
		return beginningDate;
	}
	public void setBeginningDate(String beginningDate) {
		this.beginningDate = beginningDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAdvancedSearch() {
		return advancedSearch;
	}
	public void setAdvancedSearch(String advancedSearch) {
		this.advancedSearch = advancedSearch;
	}
	public String getUserQuery() {
		return userQuery;
	}
	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}
	
	
	
	@Override
	public String toString() {
		return "SearchOrderVO [inquiryPeriod=" + inquiryPeriod + ", beginningDate=" + beginningDate + ", endDate="
				+ endDate + ", advancedSearch=" + advancedSearch + ", userQuery=" + userQuery + "]";
	}
}
