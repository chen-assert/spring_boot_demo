package com.chenjr.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Hello World";
    }

    public static List<String> myList;

    @Override
    public void run(String... arg0) throws Exception {
        //myList = new LinkedList<String>();
        myList = Arrays.asList("a", "b", "c");
        System.out.println("Hello world from Command Line Runner");
    }
}
