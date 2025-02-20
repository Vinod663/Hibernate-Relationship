package org.example;

import config.FactoryConfiguration;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.close();
    }
}