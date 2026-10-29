package encapsulation;

public class Encapsulation {
    private int secret;
    private String card;

    Encapsulation() {
        this.secret = 123;
        this.card = "Master";
    }

    public String getName(int pin) {
        if (pin == this.secret) {
            return card.toString();
        }
        return "Invalid Pin";
    }

    public void setName(String s) {
        this.card = s;
    }

    public static void main(String[] args) {
        Encapsulation e = new Encapsulation();
        System.out.println(e.getName(123));
        e.setName("Visa");
        System.out.println(e.getName(123));

    }

}
