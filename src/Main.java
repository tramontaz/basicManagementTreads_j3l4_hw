public class Main {

    public static void main(String[] args) {
        LettersThreads lt = new LettersThreads();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1: ");
                lt.printLetter();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2: ");
                lt.printLetter();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3: ");
                lt.printLetter();
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }


}
