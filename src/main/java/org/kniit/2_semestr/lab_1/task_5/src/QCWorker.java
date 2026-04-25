import java.util.concurrent.BlockingQueue;
class QCWorker implements Runnable {
    private final BlockingQueue<Part> fromAssembler;

    public QCWorker(BlockingQueue<Part> fromAssembler) {
        this.fromAssembler = fromAssembler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = fromAssembler.take();
                if (part.isSentinel()) break;
                
                System.out.println("Оператор контроля: Деталь " + part.getId() + " проверена и отправлена на склад");
                Thread.sleep(300); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
