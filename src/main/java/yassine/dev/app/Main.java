package yassine.dev.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import yassine.dev.config.AppConfig;
import yassine.dev.service.TransferService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TransferService service = ctx.getBean(TransferService.class);
		
		service.transfert("AccountOne", "AccountTwo", 25000L);
		
		System.out.println("Availalbe balance: " + service.checkBalance("AccountA"));
		
		System.out.println("Withdrawal amount: " + service.withdrawal("AccountB", 3750L));
		
		try {
			service.deposite("AccountC", 1875L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
	}
}
