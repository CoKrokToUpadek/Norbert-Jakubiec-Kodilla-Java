package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

import java.io.File;

public class FinanceProcessor {

    public boolean processFinance(InvoiceDTO invoice, User user){
        System.out.println("-------------------------------");
        System.out.println("finance  processor");
        System.out.println("data of:"+user.getUserName()+"/"+user.getUserAddress());
        System.out.println("processing:");
        System.out.println(invoice.getInvoice());
        System.out.println("process completed");
        System.out.println("-------------------------------");
        return true;
    }

}
