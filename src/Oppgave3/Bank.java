package Oppgave3;

public class Bank {

	public static final int NTEST = 10000;
	private int[] accounts;
	private int transactions;

	public Bank(int amount, int balance) {
		accounts = new int[amount];

		for (int i = 0; i < amount; i++) {
			accounts[i] = balance;
		}

		transactions = 0;
	}

	public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
		while (accounts[from] < amount) {
			wait();
		}

		accounts[from] -= amount;
		accounts[to] += amount;

		transactions++;

		notifyAll();

		if (transactions % NTEST == 0) {
			System.out.println("Transactions: " + transactions + "\nFrom\t(Account: " + from + ", Saldo: "
					+ accounts[from] + ")" + "\nTo\t(Account: " + to + ", Saldo: " + accounts[to] + ")" + "\nAmount: "
					+ amount + "\n");
			test();
		}
	}

	public synchronized void test() {
		int sum = 0;

		for (int i = 0; i < size(); i++) {
			sum += accounts[i];
		}

		System.out.println("Transactions: " + transactions + " Sum: " + sum + "\n");
	}

	public int size() {
		return accounts.length;
	}

}