public class App {
    public static void main(String[] args) throws Exception {

        GasStation station = new GasStation();
        
        for(int i = 0; i < 5; i++){
            Car_threads car = new Car_threads(i, station);
            new Thread(car).start();
            
        }
    }
}
