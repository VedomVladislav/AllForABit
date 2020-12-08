package concurrency.bankTransaction;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;
//    private Lock bankLock;
//    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
//        bankLock = new ReentrantLock();
//        sufficientFunds = bankLock.newCondition();

    }

    public synchronized void transfer(int from, int to, double amount) {
//        bankLock.lock();
        try {
//            while (accounts[from] < amount) sufficientFunds.await();
            while (accounts[from] < amount) wait();
            System.out.print(Thread.currentThread());
            accounts[from] -= from;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += to;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
//            sufficientFunds.signalAll();
            notifyAll();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
//        finally {
//            bankLock.unlock();
//        }
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
