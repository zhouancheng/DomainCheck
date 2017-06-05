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
	       
<<<<<<< HEAD
	       for(char item = 'a'; item <= 'z'; item++){
=======
	       for(char item = 'a'; item <= 'h'; item++){
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
	    	   data.add(item+"");
	    	   }
	       

//	        data.add("a");
//	        data.add("b");
	        //输出A(n,n)的全排列  
<<<<<<< HEAD
	        for(int i = 4; i <= 4; i++) {
	            arrange.arrangeSelect(data,new ArrayList<String>(),i,result);  
	        }
	        return result;
	    }
	
	
	public List<String> lette(){
		  List<String> result = new ArrayList<String>();
		  
		  
		return result;
	}
	
=======
	        for(int i = 1; i <= 3; i++) {
	            arrange.arrangeSelect(data,new ArrayList<String>(),i,result);  
	        }
	        return result;
	    }  
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
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
<<<<<<< HEAD
	                System.out.print(i);  
=======
	             //   System.out.print(i);  
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
	            	bu.append(i);

	            }
	            result.add(bu.toString());
<<<<<<< HEAD
	            System.out.println();  
=======
	          //  System.out.println();  
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
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
