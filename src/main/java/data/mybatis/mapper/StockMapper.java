package data.mybatis.mapper;

import java.util.List;

import com.neo.stock.vo.ChartVo;
import com.neo.stock.vo.StockVo;

public interface StockMapper {
	public List<StockVo> tacp_Select();
	public List<StockVo> list_Select();
	public List<StockVo> chart_Select();
	public List<ChartVo> chartJson();
}
