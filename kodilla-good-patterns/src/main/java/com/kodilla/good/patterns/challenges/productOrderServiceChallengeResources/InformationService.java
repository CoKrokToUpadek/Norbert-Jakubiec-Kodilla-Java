package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

import java.io.File;

public class InformationService {

    public void informAndSendInvoiceToBuyer(User user,InvoiceDTO invoice){
        System.out.println("-------------------------------");
        System.out.println("sending information to buyer");
        System.out.println("data of:"+user.getUserName()+"/"+user.getUserAddress());
        System.out.println(invoice.getInvoice());
        System.out.println("process completed");
        System.out.println("-------------------------------");
    }

    public void informAndSendInvoiceToSeller(Auction auction, InvoiceDTO invoice){
        System.out.println("-------------------------------");
        System.out.println("sending information to seller");
        System.out.println("data of:"+auction.getOwner());
        System.out.println(invoice.getInvoice());
        System.out.println("process completed");
        System.out.println("-------------------------------");
    }
}
