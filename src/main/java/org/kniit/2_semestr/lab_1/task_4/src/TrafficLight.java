public class TrafficLight {

    private boolean greenLight = false;

    public TrafficLight(){

    }
    public synchronized void changeLight(){
        greenLight = !greenLight;
        System.out.println("\nСветофор переключился: " + (greenLight ? "ЗЕЛЕНЫЙ" : "КРАСНЫЙ"));
        notifyAll();
    } 
    public synchronized void checkLight(int carId) throws InterruptedException{
        while (!greenLight)
        {
            System.out.println("Машина " + carId + " стоит на красном.");
            wait();
        }   
        System.out.println("Машина " + carId + " проехала");
    }

}
