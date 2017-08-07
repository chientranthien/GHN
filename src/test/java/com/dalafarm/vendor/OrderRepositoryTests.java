package com.dalafarm.vendor;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testfindOne() {
        Order order = orderRepository.findOne(1L);
        System.out.println(order);
    }

}
