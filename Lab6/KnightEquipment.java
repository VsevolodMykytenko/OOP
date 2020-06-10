package Lab6;

import java.util.Comparator;
import java.util.Scanner;

public class KnightEquipment {
    public Ammunition [] equip;
    public int counter;

    public static Ammunition [] addAmmunition(Ammunition[] arr, Ammunition x, int n){
        int i;
        Ammunition newarr[] = new Ammunition[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return  newarr;
    }

    public void addAmmu(Ammunition x){
        this.equip = addAmmunition(this.equip, x, counter++);
    }

    public  Ammunition[] range(Ammunition [] x) {
        boolean flag = true;
        int a = 0;
        int b = 0;
        System.out.println("Знайдемо елемент амуніції, що відповідає по ціні нашим можливим витратам.");
        while (flag) {
            try {
                System.out.println("Введіть мінімум який можна віддати на амуніцію лицарю(Введіть побільше! Ми ж не хочемо, щоб від йшов до бою голяка.):");
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
        return costRange(x, a, b);
    }

    public static Ammunition[] costRange(Ammunition[] x, int a, int b) {
        int length = 0;
        Ammunition [] costRange1 = new Ammunition[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i].cost >= a && x[i].cost <= b) {
                costRange1 = KnightEquipment.addAmmunition(costRange1, x[i], length++);
            }
        }
        if (length == 0) {
            return null ;
        } else {
            return costRange1;
        }
    }
    public static int countTotalWeight(Ammunition [] x){
        int WeiCounter = 0;
        for(int i = 0; i < x.length; i++){
            WeiCounter += x[i].weight;
        }
        return WeiCounter;
    }
}
class sortByWeight implements Comparator<Ammunition>{
    @Override
    public int compare( Ammunition o1, Ammunition o2){return (o2.weight - o1.weight);}
}

