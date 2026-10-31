package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ComparatorEg {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("oppo", 12));
        list.add(new Product("vivo", 22));
        list.add(new Product("redmi", 10));
        list.add(new Product("samsung", 130));
        list.add(new Product("nokia", 5));

        Collections.sort(list, (s1, s2) -> Double.compare(s1.price, s2.price));

        System.out.println(list);
    }
}
