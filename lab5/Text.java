package lab5;

public class Text {
    public Sentenses [] sentenses;

    public Text(String txt){
        String [] quantity = txt.split("(?<=[?!.])");
        sentenses = new Sentenses [quantity.length];
        for (int i = 0; i < quantity.length; i++) {
            if(!quantity[i].equals("")){
                sentenses[i] = new Sentenses(quantity[i]);
            }
        }
    }
}
