package inheritance;

class Universe {
    void display() {
        System.out.println("I am Universe");
    }
}

class Galaxy extends Universe {
    void display() {
        System.out.println("Hi, I am a Galaxy");
    }
}

public class MultilevelInheritance extends Galaxy {

    void display() {
        System.out.println("I am in Solar System");
    }

    public static void main(String[] args) {
        MultilevelInheritance m = new MultilevelInheritance();
        m.display();
    }

}
