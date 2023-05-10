package com.example.poc.springPoc.Entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class customer {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	

	@Column(name="age")
	private String age;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="address")
	private String address;
	
	@Column(name="category")
	private String category;
	
	@Column(name="surgery")
	private String surgery;
	
	@Column(name="dr_name")
	private String drName;
	
	@Column(name="vistit_type")
	private String vistitType;
	
	@OneToMany(mappedBy = "custId")
	private List<card> cards;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSurgery() {
		return surgery;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getVistitType() {
		return vistitType;
	}

	public void setVistitType(String vistitType) {
		this.vistitType = vistitType;
	}

	public List<card> getCards() {
		return cards;
	}

	public void setCards(List<card> cards) {
		this.cards = cards;
	}

	public customer(int id, String name, String age, String sex, String address, String category, String surgery,
			String drName, String vistitType, List<card> cards) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.category = category;
		this.surgery = surgery;
		this.drName = drName;
		this.vistitType = vistitType;
		this.cards = cards;
	}

	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, cards, category, drName, id, name, sex, surgery, vistitType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		customer other = (customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(age, other.age)
				&& Objects.equals(cards, other.cards) && Objects.equals(category, other.category)
				&& Objects.equals(drName, other.drName) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(sex, other.sex) && Objects.equals(surgery, other.surgery)
				&& Objects.equals(vistitType, other.vistitType);
	}
	
	
	
	
	
	
	
}
