package com.oms.model;

public class Items {
public int item_id;
public String item_name;
public String item_description;
public int item_cost;
public int item_quantity;
public String item_status;
public String supplier_id;


public int getItem_quantity() {
	return item_quantity;
}
public void setItem_quantity(int item_quantity) {
	this.item_quantity = item_quantity;
}
public String getItemStatus() {
	return item_status;
}
public void setStatus(String item_status) {
	this.item_status = item_status;
}
public String getSupplier_id() {
	return supplier_id;
}
public void setSupplier_id(String supplier_id) {
	this.supplier_id = supplier_id;
}
public int getItem_id() {
	return item_id;
}
public void setItem_id(int item_id) {
	this.item_id = item_id;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getItem_description() {
	return item_description;
}
public void setItem_description(String item_description) {
	this.item_description = item_description;
}
public int getItem_cost() {
	return item_cost;
}
public void setItem_cost(int item_cost) {
	this.item_cost = item_cost;
}

}
