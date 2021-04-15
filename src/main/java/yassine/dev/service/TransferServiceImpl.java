package yassine.dev.service;

import org.springframework.stereotype.Service;

import yassine.dev.aspect.Log;

@Service
public class TransferServiceImpl implements TransferService{

	public void transfert(String accountA, String accountB, Long amount) {
		System.out.println(amount + " Amount has been transfered from " + accountA + " to " + accountB);		
	}

	public Double checkBalance(String account) {
		System.out.println("Checking balance of account " + account);
		return Double.valueOf(10000);
	}
	@Log // Custom annotation
	public Long withdrawal(String account, Long amount) {
		System.out.println(amount + " Amount has been withdrawal from " + account);
		return amount;
	}

	public void deposite(String account, Long amount) throws Exception {
		System.out.println(amount + " Amount has been deposite to " + account);
		throw new Exception();
		
	}

}
