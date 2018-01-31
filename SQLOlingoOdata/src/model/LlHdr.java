package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LL_HDR database table.
 * 
 */
@Entity
@Table(name="LL_HDR")
@NamedQuery(name="LlHdr.findAll", query="SELECT l FROM LlHdr l")
public class LlHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Object author;
	private Object component;
	private Object creationDate;
	private Object division;
	private Object function;
	private Object name;
	private Object partName;
	private Object partNo;
	private Object phase;
	private Object plant;
	private Object prodLine;
	private Object product;
	private Object projectName;
	private Object projectNo;

	public LlHdr() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false, length=1)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="AUTHOR", nullable=false)
	public Object getAuthor() {
		return this.author;
	}

	public void setAuthor(Object author) {
		this.author = author;
	}


	@Column(name="COMPONENT", nullable=false)
	public Object getComponent() {
		return this.component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}


	@Column(name="CREATION_DATE", nullable=false)
	public Object getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Object creationDate) {
		this.creationDate = creationDate;
	}


	@Column(name="DIVISION", nullable=false)
	public Object getDivision() {
		return this.division;
	}

	public void setDivision(Object division) {
		this.division = division;
	}


	@Column(name="[FUNCTION]", nullable=false)
	public Object getFunction() {
		return this.function;
	}

	public void setFunction(Object function) {
		this.function = function;
	}


	@Column(name="NAME", nullable=false)
	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}


	@Column(name="PART_NAME", nullable=false)
	public Object getPartName() {
		return this.partName;
	}

	public void setPartName(Object partName) {
		this.partName = partName;
	}


	@Column(name="PART_NO", nullable=false)
	public Object getPartNo() {
		return this.partNo;
	}

	public void setPartNo(Object partNo) {
		this.partNo = partNo;
	}


	@Column(name="PHASE", nullable=false)
	public Object getPhase() {
		return this.phase;
	}

	public void setPhase(Object phase) {
		this.phase = phase;
	}


	@Column(name="PLANT", nullable=false)
	public Object getPlant() {
		return this.plant;
	}

	public void setPlant(Object plant) {
		this.plant = plant;
	}


	@Column(name="PROD_LINE", nullable=false)
	public Object getProdLine() {
		return this.prodLine;
	}

	public void setProdLine(Object prodLine) {
		this.prodLine = prodLine;
	}


	@Column(name="PRODUCT", nullable=false)
	public Object getProduct() {
		return this.product;
	}

	public void setProduct(Object product) {
		this.product = product;
	}


	@Column(name="PROJECT_NAME", nullable=false)
	public Object getProjectName() {
		return this.projectName;
	}

	public void setProjectName(Object projectName) {
		this.projectName = projectName;
	}


	@Column(name="PROJECT_NO", nullable=false)
	public Object getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(Object projectNo) {
		this.projectNo = projectNo;
	}

}