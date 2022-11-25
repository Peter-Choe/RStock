package com.project.mystock.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mystock.vo.MsTableVO;

@Repository
public class MsDAO {
	
	@Autowired
	private SqlSession sqlSession;

	
	
	public List<String> selectUserIdList() {
		List<String> userIdList = sqlSession.selectList("mappers.table.selectUserIdList");
		return userIdList;
	}
	
	public List<String> selectAccNumList() {
		List<String> accNumList = sqlSession.selectList("mappers.table.selectAccNumList");
		
		return accNumList;
	}
	
	public List<HashMap<String, String>> selectItemList() {
		List<HashMap<String, String>> itemList = sqlSession.selectList("mappers.table.selectItemList");
		return itemList;
	}
	
	public List<String> selectAccountList() {
		List<String> accountList = sqlSession.selectList("mappers.table.selectAccountList");
		return accountList;
	}


	public List<HashMap<String, String>> selectPriceList() {
		List<HashMap<String, String>> priceList = sqlSession.selectList("mappers.priceChart.selectPriceList");
		
		return priceList;
	}

	
	public void insertCurrPrice(String dt) {
		sqlSession.insert("mappers.currPriceChart.insertCurrPrice", dt);
	}

	

}
