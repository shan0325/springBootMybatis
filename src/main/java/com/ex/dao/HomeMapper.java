package com.ex.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
	
	public Map<String, String> selectUserInfo(String userId);

}
