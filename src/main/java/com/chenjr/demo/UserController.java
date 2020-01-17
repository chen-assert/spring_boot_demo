package com.chenjr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RedisUserRepository userRepository;

    @PostMapping
    public Student save(@RequestBody Student student){
        userRepository.save(student);
        return student;
    }

    @GetMapping
    public List list(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        userRepository.update(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.delete(id);
        return id;
    }
}