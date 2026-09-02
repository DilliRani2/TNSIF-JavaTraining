package shoppingmall.model;

import java.time.LocalDateTime;

public class OrderDetails {
    private long id;
    private LocalDateTime dateOfPurchase;
    private float total;
    private Customer customer;
    private String paymentMode;
    private Shop shop;

    public OrderDetails() {
    }

    public OrderDetails(long id, LocalDateTime dateOfPurchase, float total, Customer customer, String paymentMode, Shop shop) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.total = total;
        this.customer = customer;
        this.paymentMode = paymentMode;
        this.shop = shop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
