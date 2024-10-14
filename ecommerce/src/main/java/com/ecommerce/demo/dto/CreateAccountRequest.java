package com.ecommerce.demo.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {
    private Long customerId;
    private BigDecimal initialCredit;

    public CreateAccountRequest(Long customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }
    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

}
