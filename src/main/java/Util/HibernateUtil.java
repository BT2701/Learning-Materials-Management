package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
    	ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();
    	Metadata metadata= new MetadataSources(serviceRegistry).getMetadataBuilder().build();
    	return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
