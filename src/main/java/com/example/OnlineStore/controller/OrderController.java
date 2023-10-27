package com.example.OnlineStore.controller;

import com.example.OnlineStore.dto.CompanyDto;
import com.example.OnlineStore.dto.GoodsDto;
import com.example.OnlineStore.dto.OrderDto;
import com.example.OnlineStore.dto.UserDto;
import com.example.OnlineStore.service.CompanyService;
import com.example.OnlineStore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CompanyService companyService;

    @PostMapping("/{id}")
    @ResponseBody
    public OrderDto save(@PathVariable String id, @RequestBody(required = false) OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public OrderDto remove(@PathVariable String id) {
        return orderService.remove(Integer.parseInt(id));
    }


    @GetMapping("{id}/user")
    public String getUserPage(@PathVariable String id) {
        return "user";
    }

    @GetMapping("{id}/company")
    public String getCompanyPage(@PathVariable String id, Model model) {
        return companyService.getCompanyPage(model);
    }

    @GetMapping(value = "{id}/check")
    public String getCheckOrderPage(@PathVariable String id, Model model) {
        return orderService.getCheckOrderPage(Integer.parseInt(id), model);
    }

    @PostMapping("/{id}/goods")
    @ResponseBody
    public List<GoodsDto> setGoods(@PathVariable String id, @RequestBody(required = false) List<GoodsDto> goods) {
        return orderService.setGoods(Integer.parseInt(id), goods);
    }

    @PostMapping("/{id}/user")
    @ResponseBody
    public UserDto setUser(@PathVariable String id, @RequestBody(required = false) UserDto user) {
        return orderService.setUser(Integer.parseInt(id), user);
    }

    @PostMapping("{id}/company")
    @ResponseBody
    public CompanyDto setCompany(@PathVariable String id, @RequestBody(required = false) CompanyDto company) {
        return orderService.setCompany(Integer.parseInt(id), company);
    }
}
