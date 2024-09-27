 package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		 AbstractApplicationContext con =new ClassPathXmlApplicationContext("com/springcore/lifecycle/configg.xml");
		 
		 Samosa s1 = (Samosa) con.getBean("s1");
		 
		 System.out.println(s1);
		 
		 con.registerShutdownHook();
		 
		 System.out.println("--------------------");
		 
		  Pepsi p1 = (Pepsi) con.getBean("p1");
		  
		  System.out.println(p1);
		  
		  
		  
		 Example e1 = (Example) con.getBean("e1");
		 
		 System.out.println(e1);
		 
	}
}
