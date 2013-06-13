package hello;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HelloWorld {

    public void runHibernate() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Message message = new Message("Hello World");
        session.save(message);
        session.get(Message.class, message.getId());
        session.clear();
        System.out.println("*****************");
        session.get(Message.class, message.getId());
        System.out.println("*****************");
        session.get(Message.class, message.getId());
        tx.commit();
        session.close();
        //2nd session
        Session secsession = sessionFactory.openSession();
        Transaction sectx = secsession.beginTransaction();
        System.out.println("*****************");
        secsession.get(Message.class, message.getId());
        sectx.commit();
        secsession.close();

        sessionFactory.close();

    }

}