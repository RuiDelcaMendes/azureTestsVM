package model;

import java.util.Iterator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {
	
	private static final String PERSISTENCE_UNIT_NAME = "CarHibernateOlingo";

	public static void main(String[] args) {
		/*
		dao.DboOperations.createRecord("VW", "SHARAN");

		Iterator<Car> iter = dao.DboOperations.displayRecords().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());

		}
		*/
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		System.out.println("ok");
		
		System.exit(0);
		
	}

}
