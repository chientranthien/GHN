package com.dalafarm.vendor;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderFeeResponse;
import com.dalafarm.vendor.model.OrderSummary;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chien on 8/13/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinLogisticTests {
    @Autowired
    @Qualifier("tinLogistic")
    LogisticService logisticService;

    @Test
    public void testGroupHCM1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "760", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 20000);
    }

    @Test
    public void testGroupHCM2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "760", 3000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 20000);
    }

    @Test
    public void testGroupA1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "706", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 30000);
    }

    @Test
    public void testGroupA2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "706", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 40000);
    }

    @Test
    public void testGroupA3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "706", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 50000);
    }

    @Test
    public void testGroupA4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "706", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 65000);
    }

    @Test
    public void testGroupA5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "706", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 75000);
    }

    @Test
    public void testGroupA6() {

        //TODO test  overweight  case for group A
    }

    @Test
    public void testGroupB1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "611", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 35000);
    }

    @Test
    public void testGroupB2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "611", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 45000);
    }

    @Test
    public void testGroupB3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "611", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 55000);
    }

    @Test
    public void testGroupB4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "611", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 70000);
    }

    @Test
    public void testGroupB5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "611", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 80000);
    }

    @Test
    public void testGroupB6() {
    //TODO test  overweight case for group B
    }





    @Test
    public void testGroupC1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "800", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 35000);
    }

    @Test
    public void testGroupC2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "800", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 45000);
    }

    @Test
    public void testGroupC3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "800", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 55000);
    }

    @Test
    public void testGroupC4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "800", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 70000);
    }

    @Test
    public void testGroupC5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "800", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 80000);
    }

    @Test
    public void testGroupC6() {
        //TODO test  overweight case for group C
    }



    @Test
    public void testGroupD1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "006", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 35000);
    }

    @Test
    public void testGroupD2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "006", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 45000);
    }

    @Test
    public void testGroupD3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "006", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 60000);
    }

    @Test
    public void testGroupD4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "006", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 75000);
    }

    @Test
    public void testGroupD5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "006", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 85000);
    }

    @Test
    public void testGroupD6() {
        //TODO test  overweight case for group D
    }


    @Test
    public void testGroupE1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "384", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 35000);
    }

    @Test
    public void testGroupE2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "384", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 45000);
    }

    @Test
    public void testGroupE3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "384", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 60000);
    }

    @Test
    public void testGroupE4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "384", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 75000);
    }

    @Test
    public void testGroupE5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "384", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 85000);
    }

    @Test
    public void testGroupE6() {
        //TODO test  overweight case for group E
    }


    @Test
    public void testGroupOthers1() {

        OrderSummary orderSummary = new OrderSummary("dummy", "031", 300);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 40000);
    }

    @Test
    public void testGroupOthers2() {

        OrderSummary orderSummary = new OrderSummary("dummy", "031", 500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 50000);
    }

    @Test
    public void testGroupOthers3() {

        OrderSummary orderSummary = new OrderSummary("dummy", "031", 1000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 65000);
    }

    @Test
    public void testGroupOthers4() {

        OrderSummary orderSummary = new OrderSummary("dummy", "031", 1500);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 80000);
    }

    @Test
    public void testGroupOthers5() {

        OrderSummary orderSummary = new OrderSummary("dummy", "031", 2000);
        OrderFeeResponse orderFeeResponse = logisticService.calculateServiceFee(orderSummary);

        Assert.assertEquals(orderFeeResponse.getTotalFee(), 85000);
    }

    @Test
    public void testGroupOthers6() {
        //TODO test  overweight case for group D
    }
}
