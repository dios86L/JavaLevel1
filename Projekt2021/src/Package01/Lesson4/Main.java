package Package01.Lesson4;

public class Main {

    public static void main(String[] args) {

        Worker worker1 = new Worker("Jim", "tester", "89214375548", "1000", "32");
        Worker worker2 = new Worker("Piter", "looser", "89113334848", "50", "18");
        Worker worker3 = new Worker("Den", "lower", "89634575588", "2000", "48");
        Worker worker4 = new Worker("Olga", "tester", "89114338888", "1000", "42");
        Worker worker5 = new Worker("mrBig", "boss", "89112233444", "5000", "50");


        System.out.println("---задание 4-----");

        System.out.println(worker1.getName());
        System.out.println(worker1.getProf());

        System.out.println("---задание 5-----");

        String [][] workerList = {{"Jim", "tester", "89214375548", "1000", "32"},
                {"Piter", "looser", "89113334848", "50", "18"},
                {"Den", "lower", "89634575588", "2000", "48"},
                {"Olga", "tester", "89114338888", "1000", "42"},
                {"mrBig", "boss", "89112233444", "5000", "50"}
        };

        for(int y = 0; y < 5; ++y) {
            for(int x = 0; x < 5; ++x){
                int old = Integer.parseInt(workerList[y][4]);
                if (old >= 40) {
                    System.out.print(workerList[y][x] + "|");
                }
             }
            System.out.println();
        }

 //       for(int y = 0; y < 5; ++y) {
  //          for(int x = 0; x < 5; ++x) {
 //               System.out.print(workerList[y][x] + "|");
 //           }
 //           System.out.println();
 //       }






        // public static void workerList () {


      //   }


    }
}
