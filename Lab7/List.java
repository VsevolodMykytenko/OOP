package Lab7;

import Lab6.Ammunition;

public class List {
    private Nodes head;
    private Nodes tail;

    public Nodes getHead() {
        return head;
    }

    void addFront(Ammunition data) {
        Nodes a = new Nodes();
        a.data = data;
        if (head == null) {
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    void addBack(Ammunition data) {
        Nodes a = new Nodes();
        a.data = (Ammunition) data;
        if (tail == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    void delEl(Ammunition data) {
        if (head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Nodes t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                if (tail == t.next) {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }

}
