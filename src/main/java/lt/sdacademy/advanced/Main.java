package lt.sdacademy.advanced;

import lt.sdacademy.advanced.models.Beeing;
import lt.sdacademy.advanced.models.Human;
import lt.sdacademy.advanced.models.Worker;

public class Main {

    public static void m2(Worker worker) {
        System.out.println("Worker: " + worker);
    }

    public static void m2(Human human) {
        System.out.println("Human: " + human);
    }

    public static void m3(Beeing beeing) {
        System.out.println(beeing);
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        m2(worker);
        m3(worker);
        Human human = new Worker();

        m2(human);

        Beeing beeing = new Beeing();

        human = worker;
        beeing = human;

        Human human1 = new Worker();
        System.out.println(human1.getName());
    }
}
