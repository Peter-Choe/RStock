package com.neo.stock.controller;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neo.stock.service.HighChartService;
import com.neo.stock.vo.ChartVo;
import com.neo.stock.vo.RealTimeItem;


@RestController
@RequestMapping("/hchart/*")
public class HighChartController {
	
	@Autowired HighChartService service;
	
	@RequestMapping("/rtchart")
    public ModelAndView chart2(ModelAndView mv) {
		mv.setViewName("/rtchart");
        return mv;
    }
	
	@RequestMapping("/live_resource")
    public RealTimeItem hchart_JsonData() {
		int rand = (int) (Math.random()*15) + 1;		
		return new RealTimeItem(Instant.now().toEpochMilli(), rand);
	}
	
	@RequestMapping("/aachart")
    public ModelAndView pp_chart(ModelAndView mv) {
		mv.setViewName("/highChart");
        return mv;
    }
	
	@RequestMapping("/dbChartJSON")
	public List<ChartVo> get_Json(){
		List<ChartVo> list=service.chartJson();
		
		System.out.println("DB에서 호출");
		return list;
	}
}
