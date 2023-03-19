package why.thehell;

public class Main {
    public static void main(String[] args) {
        SharedSequence sharedSequence = new SharedSequence();
        SequenceThread t1 = new SequenceThread(sharedSequence, 101, 103, 1);
        SequenceThread t2 = new SequenceThread(sharedSequence, 201, 203, 2);
        SequenceThread t3 = new SequenceThread(sharedSequence, 301, 303, 3);

        t1.start();
        t2.start();
        t3.start();
    }
}

 class SharedSequence {
    private int threadNumber = 1;

    public synchronized int getThreadNumber() {
        return threadNumber;
    }

    public synchronized void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }
}

 class SequenceThread extends Thread {
    private final SharedSequence sharedSequence;
    private final int start;
    private final int end;
    private final int threadNumber;

    public SequenceThread(SharedSequence sharedSequence, int start, int end, int threadNumber) {
        this.sharedSequence = sharedSequence;
        this.start = start;
        this.end = end;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            synchronized (sharedSequence) {
               while (sharedSequence.getThreadNumber() != threadNumber) {
                    try {
                        sharedSequence.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i + " from Thread " + threadNumber);
                if (threadNumber == 3) {
                    sharedSequence.setThreadNumber(1);
                } else {
                    sharedSequence.setThreadNumber(threadNumber + 1);
                }
                sharedSequence.notifyAll();
            }
        }
    }
}

