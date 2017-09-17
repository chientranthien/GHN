package com.dalafarm.vendor.controller.frontend;

import com.dalafarm.vendor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by LeeU on 9/3/2017.
 */
@Controller
public class FrontendController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String home1() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/orders")
    public String admin(Model model) {
        model.addAttribute("orders", orderService.getAllOrdersForFrontend());
        SimpleDateFormat displayDateFormatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm zzz" );
        displayDateFormatter.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        model.addAttribute( "displayDateFormatter", displayDateFormatter );
        return "orders";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }
}
