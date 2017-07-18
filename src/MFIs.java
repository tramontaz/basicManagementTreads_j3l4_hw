public class MFIs {
    private final Object monitor = new Object();
    private final String print = "I'm printing...";
    private final String scan = "I'm scanning...";
    private volatile boolean iAmPrintingNow = false;
    private volatile boolean iAmScanningNow = false;
    private int printIncrement = 0;
    private int scanIncrement = 0;


    public void printSomething(boolean isPrint) {
        if (iAmPrintingNow) {
            System.out.println("I'm busy right now");
            return;
        }
        synchronized (monitor) {
            while (isPrint)
                try {
                    iAmPrintingNow = true;
                    while (iAmPrintingNow) {
                        System.out.println(print + ++printIncrement + "\n");
                        Thread.sleep(500);
                        if (Thread.interrupted()) {
                            iAmPrintingNow = false;
                            monitor.wait();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public void scanSomething(boolean isScan) {
        if (iAmScanningNow) {
            System.out.println("I'm busy right now");
            return;
        }
        while (isScan)
            try {
                iAmScanningNow = true;
                while (iAmScanningNow) {
                    System.out.println(scan + ++scanIncrement + "\n");
                    Thread.sleep(500);
                    if (Thread.interrupted()) {
                        iAmScanningNow = false;
                        monitor.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
