package lab5;

public class Words {
    public Letters[] letter;
    public String word;
    public Words(String wor){
       word = wor;
       String [] splwWord = wor.split("");
       letter = new Letters[splwWord.length];
       for(int i =0; i < splwWord.length; i++){
           letter[i] = new Letters(splwWord[i]);
       }

    }
}
