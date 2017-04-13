package com.hello.pojo.admin;

public class User extends Admin{
	public User(){
		System.out.println("我是User");
	}
	public User(int age){
		System.out.println("我是age");
	}
	public static void main(String[] args) {
		
		Admin user = new User();
		
		System.out.println(user instanceof Admin);
		System.out.println(user instanceof User);
		
		
		String a = new String("aa");
		String b = new String("aa");
		System.out.println(new String("aa").equals(new String("aa")));

	}
	public void aa(){
		
	}
}
