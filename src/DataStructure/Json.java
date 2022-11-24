package DataStructure;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Json {
	
	
	public static void main(String[] args){
	ArrayList<HashMap> list = new ArrayList<>();
	
	for(int i=0; i<5; i++) {
		HashMap map = new HashMap();
		map.put("title","1번째 제목입니다!");
		map.put("Content","1234567890_testtest String 문자열 테스트 컨텐츠");
		map.put("Writer","홍길동");
		list.add(map);
	}
	
	JSONObject jo = new JSONObject();
	jo.put("snippets", list);
	String jsonStr = new Gson().toJson(jo);
	//VO 메시지 발송
	System.out.println(new Gson().toJson(jo));
}
}