import java.util.concurrent.BlockingQueue;
class AssemblerWorker implements Runnable {
    private final BlockingQueue<Part> fromStamper;
    private final BlockingQueue<Part> toQC;

    public AssemblerWorker(BlockingQueue<Part> fromStamper, BlockingQueue<Part> toQC) {
        this.fromStamper = fromStamper;
        this.toQC = toQC;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = fromStamper.take(); 
                if (part.isSentinel()) break;   
                
                System.out.println("Сборщик: Заготовка " + part.getId() + " обработана");
                Thread.sleep(300); 
                toQC.put(part);    
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try { toQC.put(new Part(-1)); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}