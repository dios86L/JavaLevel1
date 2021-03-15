package Package01.Package04;

public class Lesson5Main {

    public static void main(String[] args) {

        Bird bird = new Bird("Bird", 8, 16, 2);
        Cat cat = new Cat("Cat", 3, 1, 500);
        Dog dog = new Dog("Dog", 100, 0.4f, 50);
        Horse horse = new Horse("Horse", 1000, 2, 100);

     bird.getRun();
     horse.getJump();
     dog.getSwim();


    }
}
