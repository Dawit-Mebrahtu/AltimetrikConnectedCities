package com.altimetrik.connectedcities.connectedcities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ConnectedcitiesApplication {

    public static List<List<String>> connectedCities = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
        SpringApplication.run(ConnectedcitiesApplication.class, args);
    }


    public static void parseData(Stream<String> list) {

        connectedCities = list.map(line -> {

            List<String> pairs = new ArrayList<>();
            String[] values = line.split(",");
            return Arrays.asList(values);
        }).collect(Collectors.toList());

        System.out.println(connectedCities);
    }


    private static void loadData() {
        try{
            Path path = Paths.get("upload/cities.txt");
            Stream<String> data = Files.lines(path);
            parseData(data);

        } catch (IOException e) {
            e.printStackTrace();
     }
    }

}
