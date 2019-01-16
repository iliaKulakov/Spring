package io.github.ilia_kulakov;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.hibernate.cfg.Configuration;


/*
 * This Java source file was generated by the Gradle 'init' task.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("io.github.ilia_kulakov")
public class App {


    public static void main(String[] args) {

       // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

       // Session session = sessionFactory.openSession();
       // Transaction tx = session.beginTransaction();
      //  session.close();

       // SpringApplication.run(App.class, args);

        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        Session session = sessionFactory.openSession();


    }
}


