public class GasStation implements Runnable{

    private int count = 2;

    public void getCount(){
        System.out.println("Свободных колонок: " + count);
    }
    
    @Override
    public void run(){
        System.out.println("Свободных колонок: " + count);
    }

    public void checkStations(int number)
    {
        System.out.println("Машина № " + number + " приехала на заправку");          
        while (count < 1)
        {
            System.out.println("Машина № " + number + " ждет очередь");
            waiting(number);
        }
        grabStation(number);
    }

    public synchronized void waiting(int number)
    {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }   
    }

    public void grabStation(int number){        
        
        System.out.println("Машина № " + number + " начала заправляться");
        try {
            count--;
            Thread.sleep(3000);
            freeStation(number);
        } catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }  
            
    }

    
    public synchronized  void freeStation(int number)
    {
        System.out.println("Машина № "  + number + " заправилась");
        count++;
        notify();
    }
}

