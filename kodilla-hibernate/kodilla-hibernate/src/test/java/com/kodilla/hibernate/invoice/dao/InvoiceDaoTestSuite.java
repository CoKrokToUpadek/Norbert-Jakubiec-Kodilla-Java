package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;

  @Test
  void  testInvoiceDaoSave(){
      //given
      Invoice invoice=new Invoice("666");
      Product ham=new Product("ham");
      Product cheese=new Product("cheese");
      productDao.save(cheese);
      productDao.save(ham);
      Item hamItem=new Item(new BigDecimal(200),20,new BigDecimal(300));
      hamItem.setProduct(ham);

      Item cheeseItem=new Item(new BigDecimal(200),20,new BigDecimal(400));
      cheeseItem.setProduct(cheese);

      invoice.getItems().add(hamItem);
      invoice.getItems().add(cheeseItem);
      hamItem.setInvoice(invoice);
      cheeseItem.setInvoice(invoice);
      //when
      invoiceDao.save(invoice);
      int id=invoice.getId();


      //then
      assertNotEquals(0, id);

      //CleanUp
      //taskListDao.deleteById(id);

  }
}
