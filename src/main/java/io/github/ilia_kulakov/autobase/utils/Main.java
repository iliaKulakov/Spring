package io.github.ilia_kulakov.autobase.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        CarModel carModel = new CarModel( "model_name");
        carModel.setName("rio");
        session.save(carModel);
        tx.commit();

        String queryString = "FROM CarModel cm WHERE cm.name =\'rio\'";
        Query query = session.createQuery(queryString);
        carModel = (CarModel) query.getSingleResult();

        System.out.println("ID: "+carModel.getModelID()+"\n"+"Model: "+carModel.getName()+"\n");

        Transaction txM = session.beginTransaction();

        Manufacture manufacture = new Manufacture(Arrays.asList(carModel), "RioYo");
        session.save(manufacture);
        txM.commit();


        tx = session.beginTransaction();
        carModel.setManufacture(manufacture);
        tx.commit();

        session.close();

    }
}
