package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){

        //given
        Library library = new Library("my library 1");
        for (int i=0;i<10;i++){
            library.getBooks().add(new Book("book"+i,"author"+i, LocalDate.of(1920+i,10,10)));
        }

        //making a shallow copy of object library
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("my library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("my library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //when
        assert shallowClonedLibrary != null;
        shallowClonedLibrary.getBooks().remove(new Book("book"+1,"author"+1, LocalDate.of(1920+1,10,10)));

        assert deepClonedLibrary != null;
        deepClonedLibrary.getBooks().remove(new Book("book"+2,"author"+2, LocalDate.of(1920+2,10,10)));
        deepClonedLibrary.getBooks().remove(new Book("book"+3,"author"+3, LocalDate.of(1920+3,10,10)));

        //then
        //removing element from shallow copy, also removed it from original
        Assertions.assertEquals(9,shallowClonedLibrary.getBooks().size());
        Assertions.assertEquals(9,library.getBooks().size());

        //removing elements from deep copy should not remove them from original
        //(note that one element from original was removed while removing it from shallow copy)
        Assertions.assertEquals(8,deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(9,library.getBooks().size());

        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
    }
}
