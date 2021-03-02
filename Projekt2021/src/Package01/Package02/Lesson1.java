package Package01.Package02;

public class Lesson1 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        float c = 4f;
        int d = 8;
        float result;
        result = myEx (a, b, c, d);
        System.out.println("результат 1 " + result);
        System.out.println("результат 2 " + seCond(5,6));
        System.out.println("результат 3 " + third(5));
        System.out.println("Привет, " + fourth("Паша") + "!");
    }
    public static float myEx (int a, int b, float c, int d) {
        return (a * (b + (c/d)));
    }

    public static boolean seCond (int a, int b) {
        int c = a + b;
        return (c >= 10) && (c <= 20);

    }
    public static String third (int a) {
        if (a>=0) {
            return (a + " positive");
        }
        else {
            return (a + " negative");
        }
    }
    public static String fourth (String a) {
        return (a);
    }
}
