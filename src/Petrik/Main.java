package Petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void main(String[] args) {
        bejegyzesek.add(new Bejegyzes("asd","asd"));
        bejegyzesek.add(new Bejegyzes("asdasd","asdasdasd"));
        bejegyzesek.add(new Bejegyzes("asdasdasd","asdasdasdasd"));

        System.out.println(bejegyzesek.toString());
    }
}