package com.rest.controllerHelper;

import java.util.HashMap;
import java.util.Map;

import com.rest.model.CustomerVO;

public class SessionManagement {
	
	static Map<String, CustomerVO> sessionMap=new HashMap<String, CustomerVO>();

	
	


	public static Map<String, CustomerVO> getSessionMap() {
		return sessionMap;
	}





	public static void setSessionMap(Map<String, CustomerVO> sessionMap) {
		SessionManagement.sessionMap = sessionMap;
	}





	public void putToSessionMap(String coockieId,CustomerVO custVO) {
		/*if(null==getSessionMap()) {
			setSessionMap(new HashMap<String, CustomerVO>());
		}*/
		if(getSessionMap()!=null) {
			getSessionMap().put(coockieId,custVO);
		}
	}
	
	

}
