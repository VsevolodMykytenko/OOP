package lab5;

public class Sentenses {
    public Punctuations [] punctuation;
    public Words[] words;
    public  String senten;
    public  int qunt;
    public Sentenses (String sent){
        senten = sent;
        String punSymbols = ".!,-?";
        sent = sent.replaceAll("[\\s]{2,}", " ");
        String [] splSent = sent.split("(?=,|\\.|\\,|\\S+\\-+\\s|!|\\?)|\\s");
        int counter_Punctuations = 0;
        int counter_words = 0;
        for (int i = 0; i < splSent.length; i++) {
            if(punSymbols.contains(splSent[i])){
                if(!splSent[i].equals("")){
                    punctuation = addPunctuations(counter_Punctuations, punctuation, splSent[i]);
                    counter_Punctuations+=1;
                }
            }
            else{
                words = addWord(counter_words, words, splSent[i]);
                counter_words+=1;
            }
        }
        qunt=counter_words;
    }
    public static Punctuations[] addPunctuations(int n, Punctuations[] arr, String x)
    {
        int i;
        Punctuations[] newarr = new Punctuations[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = new Punctuations(x);
        return newarr;
    }
    public static Words[] addWord(int n, Words[] arr, String x)
    {
        int i;
        Words[] newarr = new Words[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = new Words(x);
        return newarr;
    }
}
