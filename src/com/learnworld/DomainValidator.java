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
<<<<<<< HEAD
                Thread.sleep(30000);
=======
                Thread.sleep(60000);
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		    
		    return false;
		}
	}
	
}
