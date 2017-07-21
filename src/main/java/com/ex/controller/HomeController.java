package com.ex.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.service.HomeService;

@Controller
public class HomeController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="homeService")
	private HomeService homeService;
	
	@RequestMapping(value="/home/{userId}")
	public ResponseEntity<Map> home(@PathVariable String userId) {
		
		Map<String, String> userInfo = homeService.selectUserInfo(userId);
		
		logger.debug("userInfo : " +userInfo);
		logger.debug("git 수정 테스트111");
		
		return new ResponseEntity<Map>(userInfo, HttpStatus.OK);
	}
	
}
