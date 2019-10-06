package com.HoweWork2.Hillel;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Map<String,Integer>> orders = new TreeMap<>(new Comparator<String>(){
        public int compare(String o1, String o2){
            return o1.compareTo(o2);
        }
    });
    public static void main(String[] args) {
        while (true) {
            System.out.println("Ввидите заказ по форме: Имя, товар, количество");
            String check = sc.next();
            if (check.equals("stop")) {
                break;
            }else {
                String name = check;
                String product = sc.next();
                int quantity = sc.nextInt();
                addOrder(name, product, quantity);
            }
        }
        print();
    }
    private static void addOrder(String name, String product, int quantity){
        Map<String, Integer> listOfProduct = new TreeMap<>(new Comparator<String>(){
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });;
        if (orders.containsKey(name)){
            listOfProduct = orders.get(name);
            if (listOfProduct.containsKey(product)){
                listOfProduct.put(product, listOfProduct.get(product)+quantity);
            } else {
                listOfProduct.put(product, quantity);
            }
        }else listOfProduct.put(product, quantity);
        orders.put(name, listOfProduct);
    }
    private static void print (){
        for (Map.Entry<String, Map<String, Integer>> entry: orders.entrySet()){
            Map<String, Integer> listOfProduct;
            listOfProduct = entry.getValue();
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> list: listOfProduct.entrySet()){
                System.out.println(list.getKey() + " " + list.getValue());
            }
        }
    }
}
