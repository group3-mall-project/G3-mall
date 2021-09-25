package com.g3.web;

import com.g3.service.NaverAPI20;
import com.g3.service.NaverLogin;
import com.g3.service.UserService;
import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginBO implements NaverLogin{

	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private DefaultApi20 api20Instance;
	
	public NaverLoginBO(String service, String clientId, String clientSecret, String redirectUri) {
		this.service = service;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUri = redirectUri;
		if("naver".equalsIgnoreCase(service)) {
			this.api20Instance = NaverAPI20.instance();
		}
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	
	public DefaultApi20 getApi20Instance() {
		return api20Instance;
	}

	public void setApi20Instance(DefaultApi20 api20Instance) {
		this.api20Instance = api20Instance;
	}

	@Override
	public String toString() {
		return "NaverLoginBO [service=" + service + ", clientId=" + clientId + ", clientSecret=" + clientSecret
				+ ", redirectUri=" + redirectUri + ", api20Instance=" + api20Instance + "]";
	}

	
	
	
	
	
}
