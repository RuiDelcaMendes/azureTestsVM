package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmExtension;
import org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmSchemaView;;

/**
 * The persistent class for the CAR database table.
 * 
 */
@Entity
@Table(name = "CAR")
@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
public class Car

		implements Serializable, JPAEdmExtension {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "MAKE")
	private String make;

	@Column(name = "MODEL")
	private String model;

	public Car() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView view) {
		Schema edmSchema = view.getEdmSchema();
		edmSchema.getComplexTypes().add(getComplexType());
	}

	private ComplexType getComplexType() {
	      ComplexType complexType = new ComplexType();
	      
	      
	      List<Property> properties = new ArrayList<Property>();
	      SimpleProperty property = new SimpleProperty();

	      property.setName("Make");
	      property.setType(EdmSimpleTypeKind.String);
	      properties.add(property);

	      property = new SimpleProperty();
	      property.setName("Model");
	      property.setType(EdmSimpleTypeKind.String);
	      properties.add(property);

	      complexType.setName("OrderValue");
	      complexType.setProperties(properties);

	      return complexType;
	}

}