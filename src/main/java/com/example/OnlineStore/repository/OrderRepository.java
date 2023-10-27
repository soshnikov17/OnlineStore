package com.example.OnlineStore.repository;

import com.example.OnlineStore.entity.Company;
import com.example.OnlineStore.entity.Goods;
import com.example.OnlineStore.entity.Order;
import com.example.OnlineStore.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final List<Order> orders = new LinkedList<>();

    public List<Order> findAll() {
        return orders;
    }

    public Order findById(int id) {
        return orders.get(id);
    }

    public Order save(Order entity) {
        orders.add(entity);
        return entity;
    }

    public Order remove(Order entity) {
        orders.add(entity);
        return entity;
    }

    public Order removeById(int id) {
        Order entity = orders.get(id);
        orders.remove(id);
        return entity;
    }

    public List<Goods> setGoods(int id, List<Goods> goods) {
        orders.get(id).setGoods(goods);
        return orders.get(id).getGoods();
    }

    public User setUser(int id, User user) {
        orders.get(id).setUser(user);
        return orders.get(id).getUser();
    }

    public Company setCompany(int id, Company company) {
        orders.get(id).setCompany(company);
        return orders.get(id).getCompany();
    }
}
