package com.project.mystock.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.project.mystock.dao.MsDAO;
import com.project.mystock.vo.MsTableVO;

@Service
public class MsService {

	@Autowired
	private MsDAO msDAO;
	
	
	public List<String> getUserIdList() {
		List<String> userIdList = msDAO.selectUserIdList();
		return userIdList;
	}
	
	public List<String> getAccNumList() {
		List<String> accNumList = msDAO.selectAccNumList();
		
		return accNumList;
	}
	
	public List<HashMap<String, String>> getItemList() {
		List<HashMap<String, String>> itemList = msDAO.selectItemList();
		return itemList;
	}
	
	public List<String> getAccountList() {
		return msDAO.selectAccountList();
	}
	
	


	public JSONArray getPriceList() {
		List<HashMap<String, String>> priceList = msDAO.selectPriceList();
//		System.out.println("service: " + priceList.toString());
		JSONArray priceJA = new JSONArray();
		for(HashMap<String, String> priceInfo : priceList) {
			JSONArray infoJA = new JSONArray();
			infoJA.put(Long.parseLong(priceInfo.get("date")));
			infoJA.put(priceInfo.get("open"));
			infoJA.put(priceInfo.get("high"));
			infoJA.put(priceInfo.get("low"));
			infoJA.put(priceInfo.get("close"));
			priceJA.put(infoJA);
		}
		return priceJA;
	}

	
	public String getCurrPrice() {
		Document doc = null;
		Elements priceEl = null;
		String currPrice = null;
		try {
			doc = Jsoup.connect("https://www.investing.com/crypto/bitcoin").get();
			priceEl = doc.select(".pid-1057391-last");
//			System.out.println("priceEl: " + priceEl);
			currPrice = priceEl.text().replace(",", "");
//			System.out.println("price: " + price);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return currPrice;
	}
	



}
