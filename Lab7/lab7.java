package Lab7;

import java.util.Iterator;
import Lab6.Ammunition;
import Lab6.Shield;
import Lab6.Helmet;
import Lab6.Armor;
//9119%2 = 1 => Set
//9119%3 = 2 => Двозв'язний список


public class lab7 {
    public static void main(String[] args) {
        Shield shield = new Shield("Металевий щит", 2, 80);
        Shield another_shield = new Shield("Дерев'яний щит", 1, 30);
        TheSet ts = new TheSet();
        ts.add(shield);
        ts.add(another_shield);
        ts.remove(another_shield);
        TheSet ts2 = new TheSet(ts);
        ts2.add(shield);
        ts2.add(new Helmet( "Повний металевий шолом с забралом", 3, 150));
        ts2.add(shield);
        ts2.add(new Armor("Повні металеві обладунки з кольчугою", 35, 3500));
        System.out.println("Вся амуніція:");
        Iterator iterator = ts2.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        TheSet costRan = ts2.range();
        System.out.println("Амуніція яку можно купити на бюджет:");
        if (costRan==null){
            System.out.println("Лицарь з таким специфічним бюджетом і щита не купить, і на обладунки тільки подивиться" +
                    "!");
        }
        else{
            Iterator iter = costRan.iterator();
            while(iter.hasNext()){
                Ammunition pl = (Ammunition) iter.next();
                System.out.println(pl+ " (ціна: " + pl.cost+")");
            }}
        System.out.print("\nВага повного спорядження: ");
        System.out.println(ts2.countTotalWeight());
        System.out.println("\nСпорядження сортоване за вагою:");
        Ammunition [] sorted_by_rf = ts2.sortW();
        for(Ammunition obj : sorted_by_rf){
            System.out.println(obj + " (вага: " + obj.weight+")");
        }
    }
}
