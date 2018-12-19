package com.company.workflowservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customer")
public class Customer {
	@Id
	private String id;
	
	private String name;
	
	private Double income;
	private Double debts;
	private Double patrimony;
	private String url;
	private String responseBody;
	
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getDebts() {
		return debts;
	}
	public void setDebts(Double debts) {
		this.debts = debts;
	}
	public Double getPatrimony() {
		return patrimony;
	}
	public void setPatrimony(Double patrimony) {
		this.patrimony = patrimony;
	}
	
}
