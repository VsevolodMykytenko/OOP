package Lab7;

import Lab6.Ammunition;

public class Nodes {
    public Ammunition data;
    public Nodes next;

    public Nodes getNext() {
        return next;
    }

    public void setNext(Nodes next) {
        this.next = next;
    }

    public Ammunition getData() {
        return data;
    }

    public void setData(Ammunition data) {
        this.data = data;
    }
}
