package classandobj;

import java.util.Scanner;

class Cricket {
    private String name;
    private int score;

    // Parametrized Constructor
    Cricket(String name, int score) {
        this.name = name;
        this.score = score;
    }

    void getScore() {
        System.out.println(name + " scored " + score);
    }

    void setScore(int s) {
        score += s;
    }

}

public class Class {
    public static void main(String[] args) {
        Cricket c = new Cricket("Virat", 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter current score: ");
        c.setScore(sc.nextInt());
        c.getScore();
        sc.close();

    }

}
