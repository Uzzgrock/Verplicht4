package Oppgave3;

public class UnsynchBankTest {

	private static final int Accounts = 10;
	private static final int Balance = 10000;

	public static void main(String[] args) {

		Bank b = new Bank(Accounts, Balance);

		for (int i = 0; i < Accounts; i++) {
			TransferThread t = new TransferThread(b, i, Balance);
			t.setPriority(Thread.NORM_PRIORITY + i % 2);
			t.start();
		}

	}

}