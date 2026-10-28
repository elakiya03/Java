package controlflow;

public class Switch {

    private enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    static void switchUsingInt(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Hi");
                break;
            case 2:
                System.out.println("Hello");
                break;
            default:
                System.out.println("Bye");
                break;
        }
    }

    private static void switchUsingCharacter(char c) {
        switch (c) {
            case 'a':
                System.out.println("Anglerfish");
                break;
            case 'b':
                System.out.println("Beaver");
                break;
            default:
                System.out.println("Cricket");
                break;
        }
    }

    private static void switchUsingString(String Day) {
        switch (Day) {
            case "MON":
                System.out.println("Monday");
                break;
            case "TUE":
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Sunday");
                break;
        }
    }

    private static void switchUsingEnum(Day day) {
        switch (day) {
            case MON:
                System.out.println("Monday");
                break;
            case TUE:
                System.out.println("Tuesday");
                break;
            case WED:
                System.out.println("Wednesday");
                break;
            case THU:
                System.out.println("Thursday");
                break;
            case FRI:
                System.out.println("Friday");
                break;
            case SAT:
                System.out.println("Saturday");
                break;
            case SUN:
                System.out.println("Sunday");
                break;
        }
    }

    public static void main(String[] args) {
        int choice = 1;
        char c = 'a';
        String dayCode = "TUE";
        Day enumDay = Day.TUE;

        switchUsingInt(choice);
        switchUsingCharacter(c);
        switchUsingString(dayCode);
        switchUsingEnum(enumDay);
    }

}
