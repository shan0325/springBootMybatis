package com.ex.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.dao.HomeDAO;
import com.ex.dao.HomeMapper;

@Service("homeService")
@Transactional
public class HomeServiceImpl implements HomeService {

	@Resource(name="homeDAO")
	private HomeDAO homeDAO;
	
	@Autowired
	private HomeMapper homeMapper;

	@Override
	public Map<String, String> selectUserInfo(String userId) {
	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("emplyr_id", userId);
		paramMap.put("user_nm", userId);
		paramMap.put("password", "1234");
		paramMap.put("password_hint", "1");
		paramMap.put("password_cnsr", "1");
		paramMap.put("emplyr_sttus_code", "P");
		paramMap.put("esntl_id", "USRCNFRM_00000000000");
		
		homeMapper.insertUserInfo(paramMap);
		
		Map<String, String> userInfo = homeMapper.selectUserInfo("admin");
		
		throw new RuntimeException();
		
		//return userInfo;
	}
	
	
}
