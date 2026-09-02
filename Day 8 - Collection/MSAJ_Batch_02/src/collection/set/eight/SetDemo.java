package collection.set.eight;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);

        System.out.println(set);

        System.out.println(set.contains(20));

        set.remove(10);

        System.out.println(set.size());

        set.clear();

        System.out.println(set.isEmpty());
    }
}