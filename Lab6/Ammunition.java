package Lab6;

public class Ammunition {
    public String name;
    public int weight;
    public int cost;

    public Ammunition(String nam, int weig, int cos){
        name = nam;
        weight = weig;
        cost = cos;
    }
    @Override
    public String toString() {
        return name;
    }
}
