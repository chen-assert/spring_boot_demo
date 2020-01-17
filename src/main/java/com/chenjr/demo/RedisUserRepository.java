package com.chenjr.demo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RedisUserRepository {

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisUserRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Student student) {
        hashOperations.put("student", student.getId(), student);
    }

    public List findAll() {
        return hashOperations.values("student");
    }

    public void update(Student student) {
        save(student);
    }

    public Student findById(String id) {
        return (Student) hashOperations.get("student", id);
    }

    public void delete(String id) {
        hashOperations.delete("student", id);
    }

    public Map<String, List<Student>> multiGetUsers(List<String> userIds) {
        Map<String, List<Student>> userMap = new HashMap<>();
        List<Object> users = hashOperations.multiGet("student", userIds);
        for (int i = 0; i < userIds.size(); i++) {
            userMap.put(userIds.get(i), (List<Student>) users.get(i));
        }
        return userMap;
    }
}