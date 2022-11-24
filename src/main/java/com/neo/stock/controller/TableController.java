package com.neo.stock.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neo.stock.service.TableService;
import com.neo.stock.vo.StockVo;

@Controller
public class TableController {
	@Autowired TableService service;
	
	@RequestMapping("/tableList")
	public ModelAndView tableList(ModelAndView mv, StockVo vo) {
		List<StockVo> tacp_list = service.tacp_Select();
		List<StockVo> list=service.list_Select();
		
		 Set<String> userIdSet = new HashSet<String>();
	      for(StockVo dto : list) {
	         userIdSet.add(dto.getUserId());
	      }
	      
	      Iterator<String> userId = userIdSet.iterator();
	      List<String> userIdList = new ArrayList<String>();
	      while(userId.hasNext()) {
	         userIdList.add(userId.next());
	      }
	      Collections.sort(userIdList);

		
	    mv.addObject("id_list",userIdList);
		mv.addObject("list",list);
		mv.addObject("tacp_list", tacp_list);
		mv.setViewName("/table");
		return mv;
	}
}
