package com.my.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.spring.DTO.StockChartDTO;
import com.my.spring.DTO.StockDTO;
import com.my.spring.DTO.StockItemDTO;
@Repository
public interface StockDAO {

	List<StockDTO> listAccount(StockDTO stock);

	List<StockItemDTO> totalAccount(StockDTO stock);

	List<StockChartDTO> chartJson();

	
}
