package com.example.headset0.service.chart;

import java.util.List;

// Java 에서 org.json 라이브러리를 이용하여 JSON 데이터를 다룰 수 있음
// 이 라이브러리에서 제공하는 JSONObject, JSONArray 클래스 => JSON 문자열을 파일로 저장할 수 있음.
// JSONObject 객체 생성
// HashMap으로 JSONObject생성
// JSON 문자열로 JSONObject 객체 생성
// JSONArray 객체 생성
// List 로 JSONArray 객체 생성
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.headset0.model.product.ProductDAO;
import com.example.headset0.model.product.ProductDTO;
import com.example.headset0.security.model.MemberDAO;
import com.example.headset0.security.model.MemberDTO;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {

	@Autowired
	ProductDAO productDao;
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public JSONObject getChartData_1() {
	    List<ProductDTO> items = productDao.best_list();
		JSONObject data = new JSONObject();  
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray(); 
		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "갯수");
		col2.put("type", "number");
		title.add(col1); 
		title.add(col2);
		data.put("cols", title); 
		JSONArray body = new JSONArray();
		for (ProductDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getP_name());	
			JSONObject count = new JSONObject();
			count.put("v", dto.getP_count());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		return data;

	}
		
	

	@Override
	public JSONObject getChartData_2() {
		
	    List<ProductDTO> items = productDao.product_m_gender_chart();
		JSONObject data = new JSONObject();   
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();   
		col1.put("label", "성별");
		col1.put("type", "string");
		col2.put("label", "숫자");
		col2.put("type", "number");
		title.add(col1); 
		title.add(col2);
		data.put("cols", title); 
		JSONArray body = new JSONArray();
		for (ProductDTO dto : items) {
			JSONObject p_name = new JSONObject();
			p_name.put("v", dto.getP_name());
			JSONObject count = new JSONObject();
			count.put("v", dto.getP_count());
			JSONArray row = new JSONArray();
			row.add(p_name);
			row.add(count);
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		return data;

	}
	
	@Override
	public JSONObject getChartData_3() {
		
	    List<ProductDTO> items = productDao.product_f_gender_chart();
		JSONObject data = new JSONObject();   
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();   
		col1.put("label", "성별");
		col1.put("type", "string");
		col2.put("label", "숫자");
		col2.put("type", "number");
		title.add(col1); 
		title.add(col2);
		data.put("cols", title); 
		JSONArray body = new JSONArray();
		for (ProductDTO dto : items) {
			JSONObject p_name = new JSONObject();
			p_name.put("v", dto.getP_name());
			
			JSONObject count = new JSONObject();
			count.put("v", dto.getP_count());
			
			JSONArray row = new JSONArray();
			row.add(p_name);
			row.add(count);
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		return data;

	}
	
	
	  @Override 
	  public JSONObject getChartData_4() {
	  List<ProductDTO> items = productDao.member_chart();
	  JSONObject data = new JSONObject(); 
	  JSONObject col1 = new JSONObject();
	  JSONObject col2 = new JSONObject(); 
	  JSONArray title = new JSONArray();
	 
	  col1.put("label", "성별"); 
	  col1.put("type", "string");
	  col2.put("label", "숫자"); 
	  col2.put("type", "number"); 
	  title.add(col1); 
	  title.add(col2); 
	  data.put("cols", title); 
	  JSONArray body = new JSONArray(); 
	  for (ProductDTO dto : items) {
	  JSONObject gender = new JSONObject(); 
	  gender.put("v", dto.getM_gender()); 
	  JSONObject count = new JSONObject();
	  count.put("v", dto.getM_count()); 
	  JSONArray row = new JSONArray(); 
	  row.add(gender); 
	  row.add(count); 
	  JSONObject cell = new JSONObject(); 
	  cell.put("c", row); 
	  body.add(cell); 
	  }
	  data.put("rows", body); 
	  return data;
	  
	  }
	 

		
	}

