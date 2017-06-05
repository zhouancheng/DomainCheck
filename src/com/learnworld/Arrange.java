package com.learnworld;

import java.util.ArrayList;
import java.util.List;

public class Arrange {
	
	public static  List<String>getVlues(){
	      Arrange arrange = new Arrange();  
	        List<String> data = new ArrayList<String>();
	        List<String> result = new ArrayList<String>();
//	       for(int i =1;i<=5;i++){
//	        	data.add(String.valueOf(i));
//	        }
	       
	       for(char item = 'a'; item <= 'z'; item++){
	    	   data.add(item+"");
	    	   }
	       

//	        data.add("a");
//	        data.add("b");
	        //输出A(n,n)的全排列  
	        for(int i = 4; i <= 4; i++) {
	            arrange.arrangeSelect(data,new ArrayList<String>(),i,result);  
	        }
	        return result;
	    }
	
	
	public List<String> lette(){
		  List<String> result = new ArrayList<String>();
		  
		  
		return result;
	}
	
	 public static void main(String[] args) {  
		getVlues().forEach(System.out::println);
	  
	    }  
	      
	    /** 
	     * 计算A(n,k) 
	     *  
	     * @param data 
	     * @param target 
	     * @param k 
	     */  
	    public <E> void arrangeSelect(List<E> data,List<E> target, int k,List<String> result) {  
	        List<E> copyData;  
	        List<E> copyTarget;  
	        if(target.size() == k) {  
	        	StringBuilder bu = new StringBuilder();
	        	bu.append("51");
	            for(E i : target)   {
	                System.out.print(i);  
	            	bu.append(i);

	            }
	            result.add(bu.toString());
	            System.out.println();  
	        }  
	      
	        for(int i=0; i<data.size(); i++) {  
	            copyData = new ArrayList<E>(data);  
	            copyTarget = new ArrayList<E>(target);  
	              
	            copyTarget.add(copyData.get(i));  
	            copyData.remove(i);  
	              
	            arrangeSelect(copyData, copyTarget,k,result);  
	        }  
	    }  
}
