package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LL_HDR database table.
 * 
 */
@Entity
@Table(name="LL_HDR")
@NamedQuery(name="LlHdr2.findAll", query="SELECT 1 FROM LlHdr2 l")
public class LlHdr2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", unique=true, nullable=false, length=1)
	private String id;

	@Column(name="AUTHOR")
	private String author;

	@Column(name="COMPONENT")
	private String component;

	@Column(name="CREATION_DATE")
	private String creationDate;

	@Column(name="DIVISION")
	private String division;

	@Column(name="[FUNCTION]")
	private String function;

	@Column(name="NAME")
	private String name;

	@Column(name="PART_NAME")
	private String partName;

	@Column(name="PART_NO")
	private String partNo;

	@Column(name="PHASE")
	private String phase;

	@Column(name="PLANT")
	private String plant;

	@Column(name="PROD_LINE")
	private String prodLine;

	@Column(name="PRODUCT")
	private String product;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="PROJECT_NO")
	private String projectNo;

	public LlHdr2() {
		int ii = 10;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartNo() {
		return this.partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPlant() {
		return this.plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getProdLine() {
		return this.prodLine;
	}

	public void setProdLine(String prodLine) {
		this.prodLine = prodLine;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

}