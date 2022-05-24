package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {


    String absolute="kodilla-exception/src/main/resources/names.txt";
    public void readFile(){


        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        //Path path = Paths.get(absolute);
        //Paths.get(file.getPath()
        try (Stream<String> fileLines = Files.lines(Paths.get(absolute))){
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku"+e);
        }finally {
            System.out.println("tak było nie zmyślam");
        }

        System.out.println(file.getPath());
    }

}
