package com.dalafarm.vendor.controller.frontend;

import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by LeeU on 9/3/2017.
 */
@Controller
public class FrontendController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("orders", orderService.getAllOrdersForFrontend());
        return "/admin";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
