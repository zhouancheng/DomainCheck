package com.learnworld;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * ˳�������㷨
 * @author zb
 *
 */
public class MAn {
	 private int all;  
	    public MAn()  
	    {  
	        this.all=0;  
	    }  
	    public int getAll() {  
	        return all;  
	    }  
	    public void setAll(int all) {  
	        this.all = all;  
	    }  
	    public static void main(String[] args) throws IOException { 
	    	 List<String> data = new ArrayList<String>();
	    	 for(char item = 'a'; item <= 'z'; item++){
		    	   data.add(item+"");
		    	   }
	        String[] n =new String[data.size()];;  
	        data.toArray(n);
	        MAn m=new MAn();  
	        List lst = Arrays.asList(n); 
            BufferedWriter writer = new BufferedWriter(new FileWriter("letter.txt"));
	        m.take("",4,lst,writer);  
	        writer.close();
	        System.out.println(m.getAll());  
	    }  
	  
	    public  void take(String s, int total, List lst,BufferedWriter writer) throws IOException {  
	        for (int i = 0; i < lst.size(); i++) {  
	            //System.out.println("i="+i);  
	            List templst=new LinkedList(lst);  
	            String n =  (String) templst.remove(i);// ȡ����������  
	            String str = s + n;  
	            if (total == 1) {  
	                System.out.println(str);//����� n������ֻȡһ����ֱ�Ӱ�ȡ�����Ľ���������  
	                //total=all;  
	                writer.write(str);
	                writer.newLine();
					writer.flush();	
	                all++;  
	              
	            } else {  
	                int temp=total-1;//��ͬһ����total�������ܼ�,������ԭ�б����Ļ�����  
	                take(str, temp, templst,writer);// �����temp�Լ�templst����ȫ�µı����ͼ���  
	            }  
	        }  
	          
	    }  
}
