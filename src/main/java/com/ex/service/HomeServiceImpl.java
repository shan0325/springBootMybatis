package com.ex.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.dao.HomeDAO;
import com.ex.dao.HomeMapper;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Resource(name="homeDAO")
	private HomeDAO homeDAO;
	
	@Autowired
	private HomeMapper homeMapper;

	@Override
	public Map<String, String> selectUserInfo(String userId) {
		
		return homeMapper.selectUserInfo(userId);
	}
	
	
}
