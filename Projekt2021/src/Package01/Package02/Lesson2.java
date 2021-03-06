package Package01.Package02;


import java.util.Arrays;
public class Lesson2 {

    public static void main (String[] args) {

        int[] myArr1 = {1,1,0,1,0,0,1,1,0,1,0,1};
        arr1(myArr1);
        System.out.println("Задание 1: " + Arrays.toString(myArr1));

        int[] myArr2 = new int[8];
        ex2(myArr2);
        System.out.println("Задание 2: " + Arrays.toString(myArr2));

        int[] myArr3 = {1,5,3,2,11,4,5,2,4,8,9,1} ;
        ex3(myArr3);
        System.out.println("Задание 3: " + Arrays.toString(myArr3));

        int[] myArr4 = {2,3,45,67,3,1,12,23,22,86,4};
        System.out.println("Задание 4 min: " + ex4min(myArr4));
        System.out.println("Задание 4 max: " + ex4max(myArr4));
    }
    public static void arr1 (int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == 0){
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            } else {
                System.out.print("Error") ;
            }
        }

    }

    public static void ex2 (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i*3 + 1;
        }
    }

    public static void ex3 (int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i]*2;
            } else if (array[i] >= 6) continue;
        }
    }

    public static int ex4min (int[] array) {
        int b = array[0];
        for (int i = 1; i < array.length; i++) {
            if (b > array[i]) {
                b = array[i];
            }
        }
        return b;
    }

    public static int ex4max (int[] array) {
        int b = array[0];
        for (int i = 1; i < array.length; i++) {
            if (b < array[i]) {
                b = array[i];
            }
        }
        return b;
    }
}
