package com.hello.enum_eg;

public class TestEnum {
	
	 public static void main(String[] args) {
	        System.out.println(Operation.DELETE);     //DELETE
	        System.out.println(Operation.valueOf("DELETE"));  //DELETE
	        System.out.println(Operation.valueOf("DELETE")==Operation.DELETE);  //true
	        System.out.println("DELETE".equals(Operation.DELETE.toString()));   //true
	 
	        switch (Operation.DELETE) {
	        case INSERT: /**TODO*/break;
	        case DELETE: /**TODO*/System.out.println("DELETE...");break;  //DELETE...
	        case UPDATE:/**TODO*/break;            
	        case QUERY:  /**TODO*/break;        
	        default:
	            break;
	        }
	    }
	
	
}
