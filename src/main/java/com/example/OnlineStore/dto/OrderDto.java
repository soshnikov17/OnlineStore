package com.example.OnlineStore.dto;

import com.example.OnlineStore.entity.Company;
import com.example.OnlineStore.entity.Goods;
import com.example.OnlineStore.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private User user;
    private List<Goods> goods;
    private Company company;
}
