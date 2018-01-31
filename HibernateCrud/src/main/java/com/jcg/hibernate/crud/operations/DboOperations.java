package com.jcg.hibernate.crud.operations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DboOperations {

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public final static Logger logger = Logger.getLogger(DboOperations.class);

	// This Method Is Used To Create The Hibernate's SessionFactory Object
	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		//ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		// Creating Hibernate SessionFactory Instance

		sessionFactoryObj = config.buildSessionFactory();

		return sessionFactoryObj;
	}

	private static void initTransaction() {

		// Getting Session Object From SessionFactory
		sessionObj = buildSessionFactory().openSession();
		// Getting Transaction Object From Session Object
		sessionObj.beginTransaction();
	}

	// Method 1: This Method Used To Create A New Student Record In The Database
	// Table
	public static void createRecord(String make, String model) {

		Car aCar = null;
		try {

			DboOperations.initTransaction();

			// create new instance

			aCar = new Car(make, model);

			// add to session
			sessionObj.save(aCar);

			// Commit transaction
			commitTransaction();
			logger.info("\nSuccessfully Created '" + make + model + "' Record In The Database!\n");
		} catch (Exception exc) {
			rollbackTransaction();
			exc.printStackTrace();

		} finally {
			closeTransaction();
		}

	}

	private static void rollbackTransaction() {
		if (sessionObj != null && sessionObj.getTransaction() != null) {
			logger.info("\n.......Transaction Is Being Rolled Back.......\n");
			sessionObj.getTransaction().rollback();
		}

	}

	private static void commitTransaction() {
		// Commit transaction
		sessionObj.getTransaction().commit();

	}

	private static void closeTransaction() {
		if (sessionObj != null)
			sessionObj.close();

	}

	// Method 2: This Method Is Used To Display The Records From The Database Table
	@SuppressWarnings("unchecked")
	public static List<Car> displayRecords() {
		List<Car> carList = new ArrayList<Car>();

		
		try {
			DboOperations.initTransaction();
			
			Query qry = sessionObj.createQuery(" FROM Car");
			List aList = sessionObj.createQuery(" FROM Car").list();
			carList = (List<Car>)sessionObj.createQuery(" FROM Car").list();
			
			

		} catch (Exception exc) {
			rollbackTransaction();
			exc.printStackTrace();

		} finally {
			closeTransaction();
		}

		return carList;
	}

	public static void updateCar(String id, String make, String model) {

		try {
			DboOperations.initTransaction();

			// Creating Transaction Entity
			Car aCar = (Car) sessionObj.get(Car.class, id);
			aCar.setMake(make);
			aCar.setModel(model);

			commitTransaction();
			logger.info("\nSuccessfully Updated '" + id + "' Record In The Database!\n");

		} catch (Exception exc) {
			rollbackTransaction();
			exc.printStackTrace();

		} finally {
			closeTransaction();
		}

	}

	public static void deleteCar(String id) {

		try {

			DboOperations.initTransaction();

			sessionObj.delete(sessionObj.load(Car.class, id));

			commitTransaction();
			logger.info("\nSuccessfully Deleted '" + id + "' Record In The Database!\n");
		} catch (

		Exception exc) {
			rollbackTransaction();
			exc.printStackTrace();

		} finally {
			closeTransaction();
		}

	}

	public static void deleteAll() {
		try {
			DboOperations.initTransaction();
			int nRecs = sessionObj.createQuery("DELETE FROM Car").executeUpdate();
			
			commitTransaction();
			logger.info("\nSuccessfully Deleted '" + nRecs + "' Record In The Database!\n");
		} catch (

		Exception exc) {
			rollbackTransaction();
			exc.printStackTrace();

		} finally {
			closeTransaction();
		}
	}

}
