package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

import java.io.File;

public class ProductOrderService {


    private final InformationService informationService;
    private final FinanceProcessor financeProcessor;

    public ProductOrderService(InformationService informationService, FinanceProcessor financeProcessor) {

        this.informationService=informationService;
        this.financeProcessor=financeProcessor;
    }

    public void processBasket(User user,Auction auction,Basket basket){
        InvoiceDTO invoice=basket.generateInvoice();
        if (financeProcessor.processFinance(invoice, user)){
            informationService.informAndSendInvoiceToBuyer(user,invoice);
            informationService.informAndSendInvoiceToSeller(auction,invoice);
            basket.clear();
        }else {
            System.out.println("something went wrong");
        }
    }
    public static void main(String[] args) {
        ProductOrderService productOrderService=new ProductOrderService(new InformationService(),new FinanceProcessor());
        User user1=new User();
        Basket basket=new Basket();
        Auction auction=new Auction("mark", new ProductList());
        auction.getProductsOffered().initialiseProductList();
        basket.generateBasket(auction);
        productOrderService.processBasket(user1,auction,basket);



    }
}
