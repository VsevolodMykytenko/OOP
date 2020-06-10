package lab5;

import java.util.Arrays;
import java.util.Comparator;

public class Lab5 {
    public String vowel;
    public int index;

    public Lab5(String new_vowel){
        vowel = new_vowel;
        if (vowel.length()==1){
            index = 1;}
        else{
            index = vowel.codePointAt(1) ;}
    }

    public static Lab5[] addX(int n, Lab5 arr[], String x)
    {
        int i;
        Lab5 newarr[] = new Lab5[n + 1] ;
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = new Lab5(x);
        return newarr;
    }
    public static void main(String[] args) {
        String written = new String("Мисливцевi, що йому вперше в життi доводиться  їхати  чи  йти  полювати" +
                "вовка, раз i назавжди слiд  обов'язково  запам'ятати  стару  нашу  народну" +
                "приповiдку:\n" +
                "   \"Не бiйсь вовка, - сiдай у хатi\".\n" +
                "   Вовк-хижак i хижак лютий, кровожадливий,  -  проте  боятися  його  нема" +
                "чого.\n" +
                "   Кiндрат Калистратович Моргниоко давнiй i досвiдчений  убийвовк,  -  так" +
                "вiн усiм розповiдав i всiх  учив,  що  вовк  -  звiр  надто  полохливий  i" +
                "боязкий.\n" +
                "   - Ось послухайте, -  казав  усiм  Кiндрат  Калистратович.  -  Живу,  як" +
                "знаєте, я на хуторi i якраз на узлiссi. Кошара моя стрiхою  аж  на  лiщину" +
                "нiби налягає. От вовк i  нанюхав  моїх  овечок.  Продер  глупої  ночi  пiд" +
                "стрiхою в кошару дiрку та й уплигнув серед овечки. Ну, в  кошарi,  звiсно," +
                "гвалт, - вiвцi: \"ме-е-е!\" та й у хлiвi, - а хлiв поруч, - корова в рев!  Я" +
                "почув, вискочив з хати та прожогом у кошару. А воно щось  сiре  повз  мене" +
                "пiд стрiху-шелесть! Крiзь дiрку проскочити не встигло, як я його за хвiст," +
                "а воно, видите, вовк. Ну, лякливий  же,  я  вам  скажу,  звiр!  Така  вже," +
                "звинiть, неприятнiсть! Хоч що ви  менi  тут  кажiть,  а  вовк-звiр  крiпко" +
                "полохливий!");
        Text text = new Text(written);
        String [] vowLet = "ауеоиіїяюєАУЕОИІЇЯЮЄ".split("");

        int counter = 0;
        Lab5 [] word_vowel = {};
         for (int k = 0; k <text.sentenses.length; k++) {
             for (int i = 0; i < text.sentenses[k].words.length; i++) {
                 for (int j = 0; j < vowLet.length; j++) {
                     if (text.sentenses[k].words[i].letter[0].letter.equals(vowLet[j])) {
                         word_vowel = addX(counter, word_vowel, text.sentenses[k].words[i].word);
                         counter += 1;
                         break;
                     }
                 }
             }
         }
        Arrays.sort(word_vowel, new sort_vowel());
        for(int i = 0; i < word_vowel.length; i++){
            System.out.format("\n { %-12s}\n ", word_vowel[i].vowel) ;}
    }
}
class sort_vowel implements Comparator<Lab5> {
    @Override
    public int compare(Lab5 o1, Lab5 o2) {
        return o1.index - o2.index;
    }
}

