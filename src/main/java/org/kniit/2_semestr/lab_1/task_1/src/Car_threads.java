public class Car_threads implements Runnable{
    private final int number;
    private GasStation gas;

    public Car_threads(int number, GasStation gas){
        this.number = number;
        this.gas = gas;
    }

    @Override
    public void run()
    {
        System.out.println("Машина № " + number + " едет на заправку.."); 
        gas.checkStations(number);

    }

}
