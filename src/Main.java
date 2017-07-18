public class Main {

    public static void main(String[] args) {
        LettersThreads lt = new LettersThreads();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("1:");
                lt.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("2:");
                lt.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("3:");
                lt.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }


}
