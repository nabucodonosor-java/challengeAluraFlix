package com.alura.flix.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.alura.flix.entities.User;
import com.alura.flix.repositories.UserRepository;

public class JwtTokenEnchancer implements TokenEnhancer {
	
	@Autowired
	private UserRepository repository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = repository.findByEmail(authentication.getName());
		Map<String, Object> map = new HashMap<>();
		map.put("username", user.getName());
		map.put("userId", user.getId());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}

}
