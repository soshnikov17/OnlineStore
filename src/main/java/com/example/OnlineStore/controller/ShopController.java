package com.example.OnlineStore.controller;

import com.example.OnlineStore.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ShopController {
    private final GoodsService goodsService;

    @GetMapping("/shop")
    public String getGoodsPage(Model model) {
        return goodsService.getGoodsPage(model);
    }
}
