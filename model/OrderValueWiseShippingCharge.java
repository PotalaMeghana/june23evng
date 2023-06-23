package eStoreProduct.model;

public class OrderValueWiseShippingCharge {
    private int ordvlId;
    private double ordvlFrom;
    private double ordvlTo;
    private double ordvlShippingAmount;

    // Constructors
    public OrderValueWiseShippingCharge() {
    }

    public OrderValueWiseShippingCharge(int ordvlId,double ordvlFrom, double ordvlTo, double ordvlShippingAmount) {
	this.ordvlId = ordvlId;
	this.ordvlFrom = ordvlFrom;
        this.ordvlTo = ordvlTo;
        this.ordvlShippingAmount = ordvlShippingAmount;
    }

    // Getters and Setters
    public int getOrdvlId() {
        return ordvlId;
    }

    public void setOrdvlId(int ordvlId) {
        this.ordvlId = ordvlId;
    }

    public double getOrdvlFrom() {
        return ordvlFrom;
    }

    public void setOrdvlFrom(double ordvlFrom) {
        this.ordvlFrom = ordvlFrom;
    }

    public double getOrdvlTo() {
        return ordvlTo;
    }

    public void setOrdvlTo(double ordvlTo) {
        this.ordvlTo = ordvlTo;
    }

    public double getOrdvlShippingAmount() {
        return ordvlShippingAmount;
    }

    public void setOrdvlShippingAmount(double ordvlShippingAmount) {
        this.ordvlShippingAmount = ordvlShippingAmount;
    }
}
