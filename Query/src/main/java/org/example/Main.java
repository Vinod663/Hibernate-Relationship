package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSessionFactory();
        //Native sql//
        //select * from customer_table
        //work with the table name

        //select * from customer_table where customer_name='bob';
        //work with column names


        //HQL,JPQL//
        //from Customer
        //work with the entity class name

        //from Customer where name='bob'
        //work with properties
        //base on object-oriented


        //select * from customer_table
        //SELECT c from Customer c

        /*Query<Customer> query = session.createQuery("SELECT c from Customer c", Customer.class);
        List<Customer> customers = query.list();*/

        //select * from customer_table where customer_name='bob';
        //SELECT c from Customer c where c.name='bob'
        /*Query<Customer> query = session.createQuery("SELECT c from Customer c where c.name='bob'", Customer.class);
        List<Customer> customers = query.list();*/



        //parameter//
        //SELECT c from Customer c where c.name='bob'
        //setObject(1,'bob')
        /*Query<Customer> query = session.createQuery("SELECT c from Customer c where c.name= :hello", Customer.class);
        query.setParameter("hello", "bob");
        List<Customer> customers = query.list();*/


        //native sql queries(SQL)//
        //createQuery kiyana eken run karanna puluwan hql or jpql
        // Query<Customer> query = session.createQuery("SELECT * from customer_table", Customer.class);------> wrong❌
        //Query<Customer> query = session.createNativeQuery("SELECT * from customer_table", Customer.class);----->correct✅


        /*Query<Customer> query = session.createNativeQuery("SELECT * from customer_table", Customer.class);*/
        /*Query<Customer> query = session.createNativeQuery("SELECT * from customer_table")
                .addEntity(Customer.class);//addEntity(Customer.class); use karalath class eka denna puluwan
        List<Customer> customers = query.list();*/

        Query query = session.createNativeQuery("SELECT * from customer_table");
        List<Object[]> list=query.list();
        //object array list

        for(Object[] objects:list){
            /*System.out.println(Arrays.toString(objects));*/
            for(int i=0;i<objects.length;i++){
                System.out.print("Column:");
                System.out.println(i+"-"+objects[i]);
            }
            Customer customer=new Customer();
            customer.setId((int) objects[0]);
            customer.setName((String) objects[2]);
            customer.setEmail((String) objects[1]);
            System.out.println(customer+"\n");

        }

        /*for (Customer customer : customers) {
            System.out.println(customer);
        }*/

        session.close();
    }
}