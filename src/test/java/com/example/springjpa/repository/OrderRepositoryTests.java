package com.example.springjpa.repository;

import com.example.springjpa.data.entity.OrderEntity;
import com.example.springjpa.data.repository.OrderRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderRepositoryTests {

    @Autowired
    OrderRepository repository;

    @BeforeAll
    public void init() throws Exception {
        repository.save(new OrderEntity(1, new Date(), 1));
    }

    @Test
    public void myTest() throws Exception {
        List<OrderEntity> result = repository.findAll();

        assertEquals(1, result.size());

    }
}
