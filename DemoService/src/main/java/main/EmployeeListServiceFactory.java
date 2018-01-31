package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext;
import org.apache.olingo.odata2.processor.api.jpa.ODataJPAServiceFactory;
import org.apache.olingo.odata2.processor.api.jpa.exception.ODataJPARuntimeException;



public class EmployeeListServiceFactory extends ODataJPAServiceFactory {


	private static final String PERSISTENCE_UNIT_NAME = "DemoService";

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {

		ODataJPAContext oDatJPAContext = this.getODataJPAContext();
		

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

			oDatJPAContext.setEntityManagerFactory(emf);

			oDatJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

			return oDatJPAContext;

		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}
}
