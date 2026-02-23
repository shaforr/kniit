
public enum TrafficLight {
    RED,
    YELLOW,
    GREEN;


    public TrafficLight getNextLight() {
       return this.values()[(this.ordinal() + 1) % 3];
    }
}
