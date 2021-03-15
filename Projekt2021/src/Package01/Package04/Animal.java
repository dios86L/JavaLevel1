package Package01.Package04;

public class Animal {
        protected String name;
        protected int swim;
        protected int run;
        protected float jump;

        public Animal(String name, int swim, float jump, int run) {
            this.name = name;
            this.swim = swim;
            this.run = run;
            this.jump = jump;
        }

        void getJump() {
            System.out.println(name + " jump on " + jump);
        }

        void getSwim() {
            System.out.println(name + " swim " + swim);
        }

        void getRun() {
            System.out.println(name + " run " + run);
        }


    }

