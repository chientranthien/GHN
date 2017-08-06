package com.dalafarm.vendor;

import com.example.ghn.model.Order;
import com.example.ghn.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testfindOne() {
        Order order = orderRepository.findOne(1L);
        System.out.println(order);
    }

}
