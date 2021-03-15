package Package01.Package04;

public class Cat extends Animal{
    public Cat(String name, int swim, float jump, int run) {
        super(name, swim, jump, run);
    }

    @Override
    void getSwim() {
            System.out.println("Cat плавать не умеет!");
    }

    @Override
    void getJump() {
        if (jump > 0 && jump <= 2) {
            System.out.println("Cat jump " + jump);
        } else {
            System.out.println("Cat не может так далеко прыгать!");
        }
    }

    @Override
    void getRun() {
        if (run > 0 && run <= 200) {
            System.out.println("Cat run " + run);
        } else {
            System.out.println("Cat не может так далеко бегать!");
        }
    }
}
