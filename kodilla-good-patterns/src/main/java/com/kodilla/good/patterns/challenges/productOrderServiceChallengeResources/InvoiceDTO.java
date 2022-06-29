package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

public class InvoiceDTO {
    private final String invoice;
    private final double sum;

    public InvoiceDTO(String invoice, double sum) {
        this.invoice = invoice;
        this.sum = sum;
    }

    public String getInvoice() {
        return invoice;
    }

    public double getSum() {
        return sum;
    }
}
