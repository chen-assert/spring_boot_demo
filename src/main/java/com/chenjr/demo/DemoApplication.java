package com.chenjr.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public static Resource[] img_resources;

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Hello world from Command Line Runner");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        img_resources = resolver.getResources("classpath*:static/img/*.png");
        //System.out.println(resources[0].getFilename());
    }
}
