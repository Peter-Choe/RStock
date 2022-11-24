package com.my.spring.stockService;

import java.util.List;

import com.my.spring.DTO.StockChartDTO;
import com.my.spring.DTO.StockDTO;
import com.my.spring.DTO.StockItemDTO;

public interface StockService {

	List<StockDTO> listAccount(StockDTO stock);

	List<StockItemDTO> totalAccount(StockDTO stock);
	List<StockChartDTO> stockChartData();


}
