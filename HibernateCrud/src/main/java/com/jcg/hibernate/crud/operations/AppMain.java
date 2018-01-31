package com.jcg.hibernate.crud.operations;

import java.util.Iterator;

import org.apache.log4j.Logger;

public class AppMain {
	public final static Logger logger = Logger.getLogger(AppMain.class);

	public static void main(String args[]) {

		logger.info(".......Hibernate Crud Operations Example.......\n");
		logger.info("\n=======Display RECORDS=======\n");
		DboOperations.createRecord("VW", "SHARAN");

		Iterator<Car> iter = DboOperations.displayRecords().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());

		}
		logger.info("\n=======CREATE RECORDS=======\n");

		//DboOperations.deleteAll();

		System.exit(0);

	}

}
