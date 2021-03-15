package Package01.Package04;

import java.sql.SQLOutput;

public class Bird extends Animal{

    public Bird(String name, int swim, float jump, int run) {
      super(name, swim, jump, run);
    }

    @Override
    void getSwim() {
        System.out.println("Bird плавать не умеет!");
    }

    @Override
    void getJump() {
        if (jump > 0 && jump <= 0.2) {
            System.out.println("Bird jump " + jump);
        } else {
            System.out.println("Bird не может так далеко прыгать!");
        }
    }

    @Override
    void getRun() {
        if (run > 0 && run <= 5) {
            System.out.println("Bird run " + run);
        } else {
            System.out.println("Bird не может так далеко бегать!");
        }
    }
}


