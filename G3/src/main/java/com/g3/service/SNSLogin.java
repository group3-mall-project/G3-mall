package com.g3.service;

import com.g3.controller.NaverLoginBO;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SNSLogin {
	private OAuth20Service oauthService;
	
	public SNSLogin(NaverLoginBO sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId()) 
				.apiSecret(sns.getClientSecret()) 
				.callback(sns.getRedirectUri()) 
				.build(sns.getApi20Instance());
	}
	
	public String getNaverAuthURL() {
		
		return this.oauthService.getAuthorizationUrl();
	}
	
	
}
