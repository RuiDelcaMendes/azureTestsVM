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

	@Id
	@Column(name="ID", unique=true, nullable=false, length=1)
	private String id;

	@Column(name="AUTHOR", nullable=false)
	private Object author;

	@Column(name="COMPONENT", nullable=false)
	private Object component;

	@Column(name="CREATION_DATE", nullable=false)
	private Object creationDate;

	@Column(name="DIVISION", nullable=false)
	private Object division;

	@Column(name="[FUNCTION]", nullable=false)
	private Object function;

	@Column(name="NAME", nullable=false)
	private Object name;

	@Column(name="PART_NAME", nullable=false)
	private Object partName;

	@Column(name="PART_NO", nullable=false)
	private Object partNo;

	@Column(name="PHASE", nullable=false)
	private Object phase;

	@Column(name="PLANT", nullable=false)
	private Object plant;

	@Column(name="PROD_LINE", nullable=false)
	private Object prodLine;

	@Column(name="PRODUCT", nullable=false)
	private Object product;

	@Column(name="PROJECT_NAME", nullable=false)
	private Object projectName;

	@Column(name="PROJECT_NO", nullable=false)
	private Object projectNo;

	public LlHdr() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getAuthor() {
		return this.author;
	}

	public void setAuthor(Object author) {
		this.author = author;
	}

	public Object getComponent() {
		return this.component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}

	public Object getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Object creationDate) {
		this.creationDate = creationDate;
	}

	public Object getDivision() {
		return this.division;
	}

	public void setDivision(Object division) {
		this.division = division;
	}

	public Object getFunction() {
		return this.function;
	}

	public void setFunction(Object function) {
		this.function = function;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getPartName() {
		return this.partName;
	}

	public void setPartName(Object partName) {
		this.partName = partName;
	}

	public Object getPartNo() {
		return this.partNo;
	}

	public void setPartNo(Object partNo) {
		this.partNo = partNo;
	}

	public Object getPhase() {
		return this.phase;
	}

	public void setPhase(Object phase) {
		this.phase = phase;
	}

	public Object getPlant() {
		return this.plant;
	}

	public void setPlant(Object plant) {
		this.plant = plant;
	}

	public Object getProdLine() {
		return this.prodLine;
	}

	public void setProdLine(Object prodLine) {
		this.prodLine = prodLine;
	}

	public Object getProduct() {
		return this.product;
	}

	public void setProduct(Object product) {
		this.product = product;
	}

	public Object getProjectName() {
		return this.projectName;
	}

	public void setProjectName(Object projectName) {
		this.projectName = projectName;
	}

	public Object getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(Object projectNo) {
		this.projectNo = projectNo;
	}

}