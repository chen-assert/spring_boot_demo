package com.chenjr.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Resource[] png = resolver.getResources("classpath*:static/img/*.png");
        Resource[] jpg = resolver.getResources("classpath*:static/img/*.jpg");
        img_resources = new Resource[png.length + jpg.length];
        System.arraycopy(png, 0, img_resources, 0, png.length);
        System.arraycopy(jpg, 0, img_resources, png.length, jpg.length);
        //System.out.println(resources[0].getFilename());
    }
}
