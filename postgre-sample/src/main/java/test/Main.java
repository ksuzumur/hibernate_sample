package test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.sample.vo.Book;

public class Main {

	public static void main(String[] args) {

		// EntitiyManagerFactoryでpersistence.xmlのpersistence-unit要素の設定を読み込み
		EntityManagerFactory entityManagerFactory
				= Persistence.createEntityManagerFactory("jp.sample.jpa");

		// EntitiyManagerFactoryからEntitiyManagerを生成
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Book("Hibernate", new Date()));
		entityManager.persist(new Book("JPA", new Date()));
		entityManager.getTransaction().commit();
		entityManager.close();

		// now lets pull events from the database and list them
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Book> result = entityManager.createQuery("from jp.sample.vo.Book",
				Book.class).getResultList();
		for (Book event : result) {
			System.out.println("Book (" + event.getDate() + ") : "
					+ event.getTitle());
		}
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManagerFactory.close();
	}
}