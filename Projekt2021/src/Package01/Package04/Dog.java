package Package01.Package04;

public class Dog extends Animal{
    public Dog(String name, int swim, float jump, int run) {
        super(name, swim, jump, run);
    }

    @Override
    void getSwim() {
        if (swim > 0 && swim <= 10) {
            System.out.println("Dog swim " + swim);
        } else {
            System.out.println("Dog не может так далеко плавать!");
        }
    }

    @Override
    void getJump() {
        if (jump > 0 && jump <= 0.5) {
            System.out.println("Dog jump " + jump);
        } else {
            System.out.println("Dog не может так далеко прыгать!");
        }
    }

    @Override
    void getRun() {
        if (run > 0 && run <= 500) {
            System.out.println("Dog run " + run);
        } else {
            System.out.println("Dog не может так далеко бегать!");
        }
    }
}
