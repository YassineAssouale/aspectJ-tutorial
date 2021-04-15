package yassine.dev.service;

public interface TransferService {
	
	void transfert(String accountA, String accountB, Long amount);
	
	Double checkBalance(String account);
	
	Long withdrawal(String account, Long amount);// Retrait
	
	void deposite(String account, Long amount) throws Exception;
	
	
	

}
