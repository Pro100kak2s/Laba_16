package com.company;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        MenuItem item1=new Dish(300,"Фарель","вкусная");
        MenuItem item2=new Dish(500,"Фарель","очень вкусная");
        MenuItem item3=new Dish(200,"Фарель","не очень вкусная");
        MenuItem item4=new Dish(200,"Фарель","не очень вкусная");
        MenuItem item5=new Dish(200,"Фарел","не очень вкусная");
        Customer customer1= new Customer("Артём","Киргизов",19,new Address("Люберцы",140014,"Лебедева",4,'к',21));
        Order order1=new InternetOrder();
        Order order2=new InternetOrder();
        Order order3=new InternetOrder();
        order1.setCustomer(customer1);
        order1.add(item1);
        order1.add(item2);
        order2.add(item3);
        order2.add(item4);
        order3.add(item5);
        InternetOrderManager orderManager=new InternetOrderManager();
        orderManager.add(order1);
        orderManager.add(order2);
        orderManager.add(order3);
        System.out.println(orderManager.ordersCostSummary());
        System.out.println(Arrays.toString(orderManager.getOrders()));
    }
}
