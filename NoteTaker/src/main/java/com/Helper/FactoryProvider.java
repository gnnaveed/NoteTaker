package com.Helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                // Load configuration from hibernate.cfg.xml
                factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    // Optional: method to close factory
    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}

