package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
         //given
        Set<Book> books=new HashSet<>();
        books.add(new Book("testAuthor1","testTitle1",2000,"signature1"));
        books.add(new Book("testAuthor2","testTitle2",2001,"signature2"));
        books.add(new Book("testAuthor3","testTitle3",2002,"signature3"));
        books.add(new Book("testAuthor4","testTitle4",2003,"signature4"));
        books.add(new Book("testAuthor5","testTitle5",2004,"signature5"));
        //when
        MedianAdapter medianAdapter=new MedianAdapter();
        int result=medianAdapter.publicationYearMedian(books);
        //then
        Assertions.assertEquals(2002,result);

    }
}
