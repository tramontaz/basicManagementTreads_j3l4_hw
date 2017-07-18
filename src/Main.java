import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        taskOne();
//        taskTwo();
    }

    private static void taskTwo() {
        File fileForTaskTwo = new File("fileForTaskTwo.txt");
        try {
            WriteToFileThreads wtft = new WriteToFileThreads(fileForTaskTwo);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    wtft.printOne();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    wtft.printTwo();
                }
            });
            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    wtft.printThree();
                }
            });
                t1.start();
                t2.start();
                t3.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void taskOne() {
        LettersThreads lt = new LettersThreads();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lt.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }


}
