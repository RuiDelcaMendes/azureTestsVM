package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext;
import org.apache.olingo.odata2.processor.api.jpa.ODataJPAServiceFactory;
import org.apache.olingo.odata2.processor.api.jpa.exception.ODataJPARuntimeException;

public class CarListServiceFactory extends ODataJPAServiceFactory {

	private static final String PERSISTENCE_UNIT_NAME = "Car2";

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {

		ODataJPAContext oDatJPAContext = this.getODataJPAContext();
		

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

			oDatJPAContext.setEntityManagerFactory(emf);

			oDatJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

			return oDatJPAContext;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		}

	}

}
