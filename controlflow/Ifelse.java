package controlflow;

public class Ifelse {
    public static void main(String args[]) {
        int time = 13;

        if (time >= 0 && time < 6)
            System.out.println("Its Midnight");
        else if (time >= 6 && time < 12)
            System.out.println("Good Morning");
        else if (time >= 12 && time < 16)
            System.out.println("Good Afternoon");
        else if (time >= 16 && time < 18)
            System.out.println("Good Evening");
        else if (time >= 18 && time <= 24)
            System.out.println("Good night");
        else
            System.out.println("Invalid time");
    }

}
