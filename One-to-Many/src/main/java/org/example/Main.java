package org.example;

import config.FactoryConfiguration;
import entity.Customer;

import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        /*Customer customer=new Customer();
        *//*customer.setId(1);*//*
        customer.setName("Jack");

        List<Order> orders=new ArrayList<>();

        Order order1=new Order();
        *//*order1.setId(1);*//*
        order1.setOrderDate("2025/02/05");
        order1.setCustomer(customer);

        Order order2=new Order();
        *//*order2.setId(2);*//*
        order2.setOrderDate("2025/02/20");
        order2.setCustomer(customer);

        orders.add(order1);
        orders.add(order2);

        customer.setOrders(orders);

        Session session= FactoryConfiguration.getInstance().getSessionFactory();

        Transaction transaction=session.beginTransaction();
        session.save(customer);
        transaction.commit();


        session.close();*/

        ///////////////////////////////////////////////////////////////////////////

        /*Session session= FactoryConfiguration.getInstance().getSessionFactory();
        Customer customer=session.get(Customer.class, 2); //customer ge 1 kiyala id ekak nati nisa 2 use karanne
        System.out.println(customer);
        Order order=session.get(Order.class, 1);
        System.out.println(order);
        session.close();*/

        /*Data ganna krama deka
        method-1*
        to string data ain karala getter setter tiyeddi run karanawa/*/

        /*method-2*
        inverse side eke comment karanna one,*/
         /*"@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL);
         private List<Order> orders;"*/
          /*etakora to string data ain karan natuwa run karannath puluwan*/

        ///////////////////////////////////////////////////////////////////////////////////////////////

        Session session= FactoryConfiguration.getInstance().getSessionFactory();

        Customer customer=session.get(Customer.class, 2);//Eager

        System.out.println(customer.getId());//get using fetched object
        System.out.println(customer.getName());//get using fetched object
        //1 query


        /*Customer customer1 = session.load(Customer.class, 2);//lazy

        System.out.println(customer1.getId());//get using query
        System.out.println(customer1.getName());//get using query
        //2 query*/

        /*Default fetch type------> Lazy*/

        List<Order> orders=customer.getOrders();
        System.out.println(orders);

        //Lazy fetching---> e welawe illana data tika witarai denne(query for each fetching)

        //Eager Fetching--->One query for all parent child data

    }
}