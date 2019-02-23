package by.htp.zanko.queue;

import java.util.Queue;

public class BuyerThread extends Thread {

    private Queue<Object> cashDesk;

    private String name;

    private int colProduct;

    public BuyerThread(Queue<Object> cashDesk, String name, int colProduct) {
        this.cashDesk = cashDesk;
        this.name = name;
        this.colProduct = colProduct;
    }

    @Override
    public void run() {
        Object currentCashDesk = null;
        while (true) {
            synchronized (cashDesk) {
                if (cashDesk.size() > 0) {
                    System.out.println(name + " подошел к кассе...");
                    currentCashDesk = cashDesk.poll();
                    break;
                }
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " обслуживается в кассе...");
        try {
            Thread.sleep(colProduct * 1000);
            System.out.println(name + " обслуживался в кассе..." + colProduct + " секунд");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (cashDesk) {
            cashDesk.add(currentCashDesk);
            System.out.println(name + " покидает магазин");
        }
    }
}
