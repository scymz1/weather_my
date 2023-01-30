package com.example.search.service;

import com.example.search.pojo.entity.Employee;
import com.example.search.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SearchServiceImpl implements SearchService{
    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> getDetails() {
        //TODO
        //Student student = restTemplate.getForObject("http://university/student?id=4", Student.class);
        //System.out.println(student.toString());

        ExecutorService pool = Executors.newCachedThreadPool();
        List<CompletableFuture<Object>> list = new ArrayList<>();

        CompletableFuture<Object> cf1 = CompletableFuture.supplyAsync(() -> {
            Object student = restTemplate.getForObject("http://university/student?id=4", Student.class);
            return student;
        });
        CompletableFuture<Object> cf2 = CompletableFuture.supplyAsync(() -> {
            Object employee = restTemplate.getForObject("http://employee/employees/2", Employee.class);
            return employee;
        });

        //Employee employee = (Employee) cf2.join();
//        System.out.println(employee);
        list.add(cf1);
        list.add(cf2);
        CompletableFuture<String> res = CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).thenApply(Void ->
                list.stream().map(cf -> cf.join()).map(object -> object.toString()).reduce("", (v1, v2) -> v1 + v2));

        return new ResponseEntity<>(res.join(), HttpStatus.OK);
    }
}
