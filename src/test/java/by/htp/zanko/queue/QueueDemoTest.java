package by.htp.zanko.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemoTest {

    @Test
    public void getQueueDemo() {

        Queue<Object> cashDesks = new LinkedList<>();
        cashDesks.add(new Object());
        cashDesks.add(new Object());

        List<BuyerThread> buyerThreads = Arrays.asList(
                new BuyerThread(cashDesks, "Ivan", 3),
                new BuyerThread(cashDesks, "Max", 10),
                new BuyerThread(cashDesks, "Petr", 4),
                new BuyerThread(cashDesks, "Frenk", 2),
                new BuyerThread(cashDesks, "Deniel", 6),
                new BuyerThread(cashDesks, "Amigo", 2),
                new BuyerThread(cashDesks, "Rorshah", 4),
                new BuyerThread(cashDesks, "Manchetten", 3),
                new BuyerThread(cashDesks, "Komediant", 2),
                new BuyerThread(cashDesks, "Ozymandias", 5)
        );

        buyerThreads.forEach(Thread::start);

        for (BuyerThread buyerThread : buyerThreads) {
            try {
                buyerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}