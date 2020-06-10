package Lab7;

import Lab6.Ammunition;

import java.util.*;

public class TheSet implements Set<Ammunition> {

    private List s = new List();
    private int size = 0;

    public TheSet() {
    }

    public TheSet(Ammunition stn) {
        add(stn);
    }

    public TheSet(Collection<? extends Ammunition> stn) {
        addAll(stn);
    }

    @Override
    public boolean add(Ammunition stn) {
        boolean flag = true;
        Nodes t = s.getHead();
        while (t != null) {
            if (t.data == stn) {
                flag = false;
                break;
            }
            t = t.next;
        }
        if (flag) {
            s.addBack(stn);
            size++;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends Ammunition> c) {
        Iterator<? extends Ammunition> iterator = c.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            flag = add((Ammunition) iterator.next());
        }
        return flag;
    }

    @Override
    public void clear() {
        s = null;
        s = new List();
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = add((Ammunition) o);
        if (flag) {
            s.delEl((Ammunition) o);
        }
        return flag == false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Ammunition> iterator = (Iterator<Ammunition>) c.iterator();
        while (iterator.hasNext()) {
            flag = contains((Ammunition) iterator.next());
            if (flag == false) {
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean isEmpty() {
        return s.getHead() == null;
    }

    @Override
    public Iterator<Ammunition> iterator() {
        return new AmmunitionIterator();
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            s.delEl((Ammunition) o);
            size--;
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean flag = false;
        for (Object object : c) {
            flag = remove(object);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Ammunition> iterator = iterator();
        while (iterator.hasNext()) {
            Ammunition Ammunition = (Ammunition) iterator.next();
            flag = c.contains(Ammunition);
            if (flag == false)
                remove(Ammunition);
        }
        return flag == false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        Ammunition[] mas = new Ammunition[size];
        Iterator<Ammunition> iterator = iterator();
        while (iterator.hasNext()) {
            mas[i] = iterator.next();
            i++;

        }
        return mas;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return null;
    }

    class AmmunitionIterator implements Iterator {
        private Nodes thisElement = s.getHead();

        @Override
        public boolean hasNext() {
            return thisElement != null;
        }

        @Override
        public Ammunition next() {
            Ammunition s = thisElement.data;
            thisElement = thisElement.next;
            return s;
        }

        @Override
        public void remove() {
            s.delEl(thisElement.data);
        }
    }

    public  TheSet range() {
        boolean flag = true;
        int a = 0;
        int b = 0;
        System.out.println("\nЗнайдемо елемент амуніції, що відповідає по ціні нашим можливим витратам.");
        while (flag) {
            try {
                System.out.println("Введіть мінімум який можна віддати на один предмет амуніції лицаря(Введіть побільше! Ми ж не хочемо, щоб від йшов до бою з поганим захистом.):");
                Scanner scan = new Scanner(System.in);
                String scan_a = scan.nextLine();
                a = Integer.parseInt(scan_a);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число! За букви вам ніхто нічого не продасть.");
                flag = true;
            }
        }
        flag = true;
        while (flag) {
            try {
                System.out.println("Введіть максимум який можна віддати на амуніцію лицарю (Не треба менше мінімума!):");
                Scanner scan = new Scanner(System.in);
                String scan_b = scan.nextLine();
                b = Integer.parseInt(scan_b);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число! За букви вам ніхто нічого не продасть.");
                flag = true;
            }finally {
                if (!flag) {
                    if (a>=b) {
                        System.out.println("Ех... Все ж таки ввів. Ну, тепер нашому лицарю плясати голяка.");
                        flag = true;
                    }
                }
            }
        }
        return costRange(a, b);
    }
    public TheSet costRange(int a, int b) {
        Ammunition[] x = (Ammunition[]) toArray();
        int length = 0;
        TheSet costRange1 = new TheSet();
        for (int i = 0; i < x.length; i++) {
            if (x[i].cost >= a && x[i].cost <= b) {
                costRange1.add(x[i]);
                length++;
            }
        }
        if (length == 0) {
            return null;
        } else {
            return costRange1;
        }
    }

    public  int countTotalWeight() {
        int WeiCounter = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            Ammunition nxt = (Ammunition) iterator.next();
            WeiCounter += nxt.weight;
        }
        return WeiCounter;
    }
    public Ammunition [] sortW (){
        Ammunition[] x = (Ammunition[]) toArray();
        Arrays.sort(x, new sortByWeight());
        return x;
    }
}
class sortByWeight implements Comparator<Ammunition>{
    @Override
    public int compare( Ammunition o1, Ammunition o2){return (o2.weight - o1.weight);}
}