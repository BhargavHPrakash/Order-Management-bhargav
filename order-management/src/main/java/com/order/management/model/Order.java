package com.order.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GenericGenerator(name = "order_id_generated", strategy = "increment")
    @GeneratedValue(generator = "order_id_generated")
	@Column(name = "id")
    private int id;
	@Column(name = "org_id", columnDefinition = "INTEGER", nullable = false)
	private int orgId;
	@Column(name = "customer_id", columnDefinition = "INTEGER", nullable = false)
	private int customerId;
	@Column(name = "item_id", columnDefinition = "INTEGER", nullable = false)
	private int itemId;
	@Column(name = "quantity", columnDefinition = "INTEGER", nullable = false)
	private int quantity;
	@Column(name = "price", columnDefinition = "REAL", nullable = false)
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
