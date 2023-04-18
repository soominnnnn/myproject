package com.example.headset0.controller.chart;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset0.service.chart.GoogleChartService;

@RestController
@RequestMapping("/chart/*")
public class GoogleChartController {

	
	@Autowired 
	GoogleChartService googleChartService;
	

	@RequestMapping("product_chart.do")
	public JSONObject product_chart() {
		return googleChartService.getChartData_1();
	} 
	
	
	@RequestMapping("product_m_gender_chart.do")
	public JSONObject member_m_gender_chart() { 
		return googleChartService.getChartData_2();
	} 
	
	@RequestMapping("product_f_gender_chart.do")
	public JSONObject member_f_gender_chart() { 
		return googleChartService.getChartData_3();
	} 
	
	
	@RequestMapping("member_chart.do") 
	public JSONObject member_chart() { 
	   return googleChartService.getChartData_4(); 
	  }
	 
	}

