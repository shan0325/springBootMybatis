package com.ex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("homeDAO")
public class HomeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public Map<String, String> selectUserInfo(String userId) {
		return sqlSession.selectOne("com.ex.dao.HomeMapper.selectUserInfo", userId);
	}
}
