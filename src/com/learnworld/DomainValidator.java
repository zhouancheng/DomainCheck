package com.learnworld;

public class DomainValidator {

	public static boolean isAvailableDomainForResponse(String responseXml){
		if(responseXml == null || responseXml.isEmpty()){
			return false;
		}
		System.out.println(responseXml);
		if(responseXml.contains("<original>210")){
			return true;
		} else if(responseXml.contains("<original>211") 
		          || responseXml.contains("<original>212")
		          || responseXml.contains("<original>214")){
			return false;
		} else {
		    System.out.println("api callback error!");
		    try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		    
		    return false;
		}
	}
	
}
