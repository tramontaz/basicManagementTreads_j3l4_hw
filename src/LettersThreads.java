public class LettersThreads {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'C';

    public void printLetter(){
        synchronized (monitor){
            try {
                for (int i = 0; i < 7; i++) {
                    switch (currentLetter){
                        case 'A' :
                            currentLetter = 'B';
                            System.out.print(currentLetter);
                            monitor.notifyAll();
                            break;
                        case 'B' :
                            currentLetter = 'C';
                            System.out.print(currentLetter);
                            monitor.notifyAll();
                            break;
                        case 'C' :
                            System.out.print(" ");
                            currentLetter = 'A';
                            System.out.print(currentLetter);
                            monitor.notify();
                            break;
                    }
                    monitor.wait();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
