package org.example;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session=null;
        Transaction transaction=null;

        /*Transient state*/
        Customer customer= new Customer();

        customer.setName("Vinod");

        /*Get new Session*/
        session= FactoryConfiguration.getInstance().getSessionFactory();
        transaction=session.beginTransaction();

        /*Persistence State*/
        //session.save(customer); //save wenuwata persist
        session.persist(customer);


        transaction.commit();

        /*Detached State*/
        session.close();// session ekak close karata passe e session eken tawat wadak ganna ba

        //Without use object --> eligible to GC
        /*Edit Object*/
        customer.setName("Vinod Fernando");

        /*Get new Session*/
        session=FactoryConfiguration.getInstance().getSessionFactory();

        /*Persistence state*/
        //Reaching to Persistence state
        /*session.update();*/ //update wenuwata merge
        session.merge(customer);

        //session.delete(customer); metanin passe delete wenuwata remove tama use karanne
        session.remove(customer);

        /*session eka remove karama GC ta eligible wenawa*/

        ////////////////meeka run karata wadak na just for get a idea about Hibernate Life Cycle///////////////////////////////
    }
}