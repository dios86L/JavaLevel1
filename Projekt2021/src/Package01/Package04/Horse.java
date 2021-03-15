package Package01.Package04;

public class Horse extends Animal{
    public Horse(String name, int swim, float jump, int run) {
        super(name, swim, jump, run);
    }

    @Override
    void getSwim() {
        if (swim > 0 && swim <= 100) {
            System.out.println("Horse swim " + swim);
        } else {
            System.out.println("Horse не может так далеко плавать!");
        }
    }

    @Override
    void getJump() {
        if (jump > 0 && jump <= 3) {
            System.out.println("Horse jump " + jump);
        } else {
            System.out.println("Horse не может так далеко прыгать!");
        }
    }

    @Override
    void getRun() {
        if (run > 0 && run <= 1500) {
            System.out.println("Horse run " + run);
        } else {
            System.out.println("Horse не может так далеко бегать!");
        }
    }
}
