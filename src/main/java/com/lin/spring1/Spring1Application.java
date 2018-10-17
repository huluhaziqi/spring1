package com.lin.spring1;

import com.lin.spring1.service.EmployeeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.lin.spring1")
//@EnableAspectJAutoProxy
@SpringBootApplication
public class Spring1Application {
	public static void main(String[] args) {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//		Hello obj = (Hello) context.getBean("helloWorld");
//		obj.getMessage();
//		context.registerShutdownHook();
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//
//		ctx.getBean("awareTest", AwareTest.class);
//
//		ctx.close();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeService  employeeService = (EmployeeService)ctx.getBean("employeeService");
		System.out.println(employeeService.getEmployee().getName());
		ctx.close();
	}
}
