package hello;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class HelloWorld {

    public void runHibernate() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        // get Statistics
        Statistics statistics = sessionFactory.getStatistics();
        statistics.setStatisticsEnabled(true);
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");
        Transaction tx = session.beginTransaction();
        Message message = new Message("Hello World");
        session.save(message);
        session.get(Message.class, message.getId());
        session.clear();
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");
        session.get(Message.class, message.getId());
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");
        session.get(Message.class, message.getId());
        tx.commit();
        session.close();
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");
        //2nd session
        Session secsession = sessionFactory.openSession();
        Transaction sectx = secsession.beginTransaction();
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");
        secsession.get(Message.class, message.getId());
        System.out.println("*****************");
        statistics.logSummary();
        System.out.println("*****************");

        sectx.commit();
        secsession.close();

        sessionFactory.close();

    }

}