import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) throws InterruptedException {
        int partsCount = 5; 

        BlockingQueue<Part> stamperToAssembler = new LinkedBlockingQueue<>();
        BlockingQueue<Part> assemblerToQC      = new LinkedBlockingQueue<>();

        Thread stamperThread = new Thread(new StampingWorker(stamperToAssembler, partsCount));
        Thread assemblerThread = new Thread(new AssemblerWorker(stamperToAssembler, assemblerToQC));
        Thread qcThread = new Thread(new QCWorker(assemblerToQC));

        stamperThread.start();
        assemblerThread.start();
        qcThread.start();

        stamperThread.join();
        assemblerThread.join();
        qcThread.join();

        System.out.println("Конвейер завершил работу.");
    }
}
