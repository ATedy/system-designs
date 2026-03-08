package com.example.mqdemo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderEvent implements Serializable {

    private String orderId;
    private String customerId;
    private BigDecimal amount;

    public OrderEvent() {}

    public OrderEvent(String orderId, String customerId, BigDecimal amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "OrderEvent{orderId='" + orderId + "', customerId='" + customerId + "', amount=" + amount + "}";
    }
}
