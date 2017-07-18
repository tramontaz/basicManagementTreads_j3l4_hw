public class LettersThreads {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A' && currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print('A');
                    currentLetter = 'B';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B' && currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print('B');
                    currentLetter = 'C';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C' && currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print('C');
                    currentLetter = 'A';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
