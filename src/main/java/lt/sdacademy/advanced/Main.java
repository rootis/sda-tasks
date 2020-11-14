package lt.sdacademy.advanced;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Map<String, Object> map = new HashMap<>();
        // "Rutenis" -> "Lecturer"
        map.put("Rutenis", "Lecturer");
        map.put("Tomas", "Student");

        for (String s : map.keySet()) {
            System.out.println("Key: " + s + " value: " + map.get(s));
        }

        map.remove("Rutenis");

        for (String s : map.keySet()) {
            System.out.println("Key: " + s + " value: " + map.get(s));
        }

        System.out.println("------");

        List<String> list = Arrays.asList("First", "Second", "Third");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        // ["First", "Second", "Third"] -> [5, 6, 5]
        list.stream().map(String::length).forEach(System.out::println);
    }
}
