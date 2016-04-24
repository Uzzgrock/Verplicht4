package Oppgave3;

public class TransferThread extends Thread {

	private Bank bank;
	private int fromAccount;
	private int maxAmount;

	public TransferThread(Bank bank, int fromAccount, int maxAmount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}

	public void run() {
		try {
			while (!interrupted()) {
				int toAccount = (int) (Math.random() * bank.size());
				int amount = (int) (Math.random() * maxAmount);
				bank.transfer(fromAccount, toAccount, amount);
				sleep(1);
			}

		} catch (InterruptedException e) {
			e.getMessage();
		}

	}

}