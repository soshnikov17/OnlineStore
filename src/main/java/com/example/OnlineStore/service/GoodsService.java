package com.example.OnlineStore.service;

import com.example.OnlineStore.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public String getGoodsPage(Model model) {
        model.addAttribute("goods0", goodsRepository.findById(0).getName());
        model.addAttribute("goods1", goodsRepository.findById(1).getName());
        model.addAttribute("goods2", goodsRepository.findById(2).getName());
        model.addAttribute("goods3", goodsRepository.findById(3).getName());
        model.addAttribute("goods4", goodsRepository.findById(4).getName());
        model.addAttribute("goods5", goodsRepository.findById(5).getName());
        model.addAttribute("goods6", goodsRepository.findById(6).getName());
        model.addAttribute("goods7", goodsRepository.findById(7).getName());
        model.addAttribute("goods8", goodsRepository.findById(8).getName());
        model.addAttribute("goods9", goodsRepository.findById(9).getName());
        return "shop";
    }
}
