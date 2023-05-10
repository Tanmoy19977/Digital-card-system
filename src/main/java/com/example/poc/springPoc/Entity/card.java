package com.example.poc.springPoc.Entity;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int srlNo;
	private int cardId;
	private int custId;
	private Date entryDate;
	private int noOfDays;
	private String amount;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, cardId, custId, entryDate, noOfDays);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		card other = (card) obj;
		return Objects.equals(amount, other.amount) && cardId == other.cardId && custId == other.custId
				&& Objects.equals(entryDate, other.entryDate) && noOfDays == other.noOfDays;
	}
	public card(int cardId, int custId, Date entryDate, int noOfDays, String amount) {
		super();
		this.cardId = cardId;
		this.custId = custId;
		this.entryDate = entryDate;
		this.noOfDays = noOfDays;
		this.amount = amount;
	}
	public card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	


}
