package org.market.services.admin;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:META-INF/spring/*.xml" });
		System.out.print(App.class.getName());
		System.out.println(" start...");
		context.start();
		System.out.println("start success");
		System.out.println("=============");
		System.in.read();
		context.close();
	}
}
