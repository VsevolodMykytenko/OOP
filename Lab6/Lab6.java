package Lab6;

import java.util.Arrays;

//9119 % 13 = 6 => Визначити ієрархію амуніції лицаря. Екіпірувати лицаря. Порахувати вартість амуніції. Провести сортування
//амуніції за вагою. Знайти елементи амуніції, що відповідає заданому діапазону цін.

public class Lab6 {
    public static void main(String[] args) {
        KnightEquipment equip = new KnightEquipment();
        equip.addAmmu(new Shield("Металевий щит", 2, 80));
        equip.addAmmu(new Helmet("Повний металевий шолом с забралом", 3, 150));
        equip.addAmmu(new Armor("Повні металеві обладунки з кольчугою", 35, 3500));
        Ammunition [] costRange =equip.range(equip.equip);
        System.out.println("Амуніція яку можно купити на бюджет:");
        if (costRange==null){
            System.out.println("Лицарь з таким специфічним бюджетом і щита не купить, і на обладунки тільки подивиться" +
                    "!");
        }
        else{
            for(int i = 0; i < costRange.length; i++){
                System.out.println(costRange[i].name);
            }
        }
        System.out.print("\nВага повного спорядження: ");
        System.out.println(equip.countTotalWeight(equip.equip));
        System.out.println("\nСпорядження сортоване за вагою:");
        Arrays.sort(equip.equip, new sortByWeight());
        for(int i = 0; i < equip.equip.length; i++){
            System.out.println(equip.equip[i].name);
        }
    }
}
