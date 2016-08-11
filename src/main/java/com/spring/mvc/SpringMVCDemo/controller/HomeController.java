package com.spring.mvc.SpringMVCDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring.mvc.SpringMVCDemo.Response;
import com.spring.mvc.VO.Creater;
import com.spring.mvc.VO.SubscriptionOrder;

@Controller
public class HomeController {

	
	private static int count=0;

	private static final Map<String, Map<String, Object>> totalAccount=new HashMap<String, Map<String,Object>>();
	
	private static final Map<Integer, Creater> mapOfAccountIdentifier =new HashMap<Integer, Creater>();
	
	@RequestMapping(value = "create/notification", method = RequestMethod.GET)
	@ResponseBody
	public Response createNotifications(@RequestParam String eventUrl) {
		System.out.println(eventUrl+".json");
		Response response=new Response();
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate);
		Map<String, Object> map=(Map) restTemplate.getForObject(eventUrl+".json", Object.class);
		SubscriptionOrder order=new SubscriptionOrder();
		String status=map.get("type").toString();
		
		order.setType(status);
		Map<String, Object>createrMap=(Map<String, Object>) map.get("creator");
		String uuid=createrMap.get("uuid").toString();
		totalAccount.put(uuid, map);
		
		if(!totalAccount.containsKey(uuid)){
			totalAccount.put(uuid, map);
			response.setSuccess("true");
			response.setAccountIdentifier("" + count++);
		}else{
			response.setSuccess("false");
			response.setErrorCode("USER_ALREADY_EXISTS");
			response.setMessage("Optional message about the user already existing on ISV");
		}
		return response;
	}

	@RequestMapping(value = "change/notification", method = RequestMethod.GET)
	@ResponseBody
	public SubscriptionOrder changeNotification(@RequestParam String eventUrl) {
		System.out.println(eventUrl+".json");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate);
		Map<String, Object> map=(Map) restTemplate.getForObject(eventUrl+".json", Object.class);
		SubscriptionOrder order=new SubscriptionOrder();
		order.setType(map.get("type").toString());
		System.out.println(map.get("type").toString());
		
		
	
		return order;

	}

	@RequestMapping(value = "cancel/notification", method = RequestMethod.GET)
	@ResponseBody
	public Response cancelNotification(@RequestParam String eventUrl) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate);
		Map<String, Object> map=(Map) restTemplate.getForObject(eventUrl+".json", Object.class);
		String status=map.get("type").toString();
		if(status.equalsIgnoreCase("SUBSCRIPTION_CANCEL")){
		}
		Response response=new Response();
		return response;
	}

	@RequestMapping(value = "subscription/status", method = RequestMethod.GET)
	@ResponseBody
	public String fetchStatus(@RequestParam String eventUrl) {
		return "Status :";
	}

}
