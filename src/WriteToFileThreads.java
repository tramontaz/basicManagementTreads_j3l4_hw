import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileThreads {
    private final Object monitor = new Object();
    private volatile int queueTag = 1;
    File file = null;
    private final String string = "I will not xerox my butt \n";
    private FileWriter fileWriter;

    public WriteToFileThreads(File file) throws IOException {
        this.file = file;
    }

    public void printOne() {
        synchronized (monitor) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueTag != 1) {
                        monitor.wait();
                    }
                    fileWriter.write(string);
                    fileWriter.flush();
                    queueTag = 2;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException t) {
                t.printStackTrace();
            }
        }
    }

    public void printTwo() {
        synchronized (monitor) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueTag != 2) {
                        monitor.wait();
                    }
                    fileWriter.write(string);
                    fileWriter.flush();
                    queueTag = 3;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException t) {
                t.printStackTrace();
            }
        }
    }

    public void printThree() {
        synchronized (monitor) {
            try {
                fileWriter = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    while (queueTag != 3) {
                        monitor.wait();
                    }
                    fileWriter.write(string);
                    fileWriter.flush();
                    queueTag = 1;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException t) {
                t.printStackTrace();
            }
        }
    }
}
