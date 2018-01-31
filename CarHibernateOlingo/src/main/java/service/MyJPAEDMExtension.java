package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmExtension;
import org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmSchemaView;

public class MyJPAEDMExtension implements JPAEdmExtension{

	@Override
	public void extendWithOperation(JPAEdmSchemaView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView view) {
		Schema sch = view.getEdmSchema();
		
		  sch.getComplexTypes().add(getComplexType());
    }

    private ComplexType getComplexType() {
      ComplexType complexType = new ComplexType();

      List<Property> properties = new ArrayList<Property>( );
      SimpleProperty property = new SimpleProperty();

      property.setName("Amount");
      property.setType(EdmSimpleTypeKind.Double);
      properties.add(property);

      property = new SimpleProperty();
      property.setName("Currency");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);

      complexType.setName("OrderValue");
      complexType.setProperties(properties);

      return complexType;

    }

}
