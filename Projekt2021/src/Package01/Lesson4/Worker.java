package Package01.Lesson4;

public class Worker {

    String Name;
    String Prof;
    String Phone;
    String  Money;
    String  Old;

    public Worker (String newName, String newProf, String newPhone, String  newMoney, String  newOld) {
           Name = newName;
           Prof = newProf;
           Phone = newPhone;
           Money = newMoney;
           Old = newOld;

    }

    public String getName() {
        return Name;
    }

    public String getProf() {
        return Prof;
    }

    public String getPhone() {
        return Phone;
    }

    public String getMoney() {
        return Money;
    }

    public String  getOld() {
        return Old;
    }
}
