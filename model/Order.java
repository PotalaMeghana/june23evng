package eStoreProduct.model;

import java.sql.Timestamp;

public class Order {
	private int orderId;
	private int customerId;
	private String billNumber;
	private Timestamp orderDate;
	private double total;
	private double gst;
	private String paymentReference;
	private String paymentMode;
	private String paymentStatus;
	private String shippingAddress;
	private Timestamp shipmentDate;
	private int processedBy;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Timestamp getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Timestamp shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public int getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(int processedBy) {
		this.processedBy = processedBy;
	}
}
