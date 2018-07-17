package com.tcg.manage.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PropertiesService  {
	@Value("${REPOSITORY_PATH}")
	public String REPOSITORY_PATH;
	
	@Value("${IMAGE_BASE_URL}")
	public String IMAGE_BASE_URL;
	
	/*//保存到redis中的key
	@Value("${TT_MANAGE_ITEMCAT}")
	public String TT_MANAGE_ITEMCAT;
	
	//保存到redis的存活时间
	@Value("${TT_ITEMCAT_LIVETIME}")
	public Integer TT_ITEMCAT_LIVETIME;*/
	
	public static final ObjectMapper mapper = new ObjectMapper();
}
