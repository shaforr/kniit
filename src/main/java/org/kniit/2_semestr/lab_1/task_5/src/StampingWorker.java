import java.util.concurrent.BlockingQueue;
class StampingWorker implements Runnable {
    private final BlockingQueue<Part> toAssembler;
    private final int totalParts;

    public StampingWorker(BlockingQueue<Part> toAssembler, int totalParts) {
        this.toAssembler = toAssembler;
        this.totalParts = totalParts;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalParts; i++) {
            try {
                Part part = new Part(i);
                toAssembler.put(part); 
                System.out.println("Штамповщик: Заготовка " + i + " создана");
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        try { toAssembler.put(new Part(-1)); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
