package com.example.OnlineStore.repository;

import com.example.OnlineStore.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class GoodsRepository {
    private final List<Goods> goods = new LinkedList<>() {{
       this.add(new Goods("Колбаса"));
       this.add(new Goods("Хлеб"));
       this.add(new Goods("Сало"));
       this.add(new Goods("Чай"));
       this.add(new Goods("Телевизор"));
       this.add(new Goods("Ноутбук"));
       this.add(new Goods("Утюг"));
       this.add(new Goods("Чайник"));
       this.add(new Goods("Диван"));
       this.add(new Goods("Стол"));
    }};

    public List<Goods> findAll() {
        return goods;
    }

    public Goods findById(int id) {
        return goods.get(id);
    }

    public Goods save(Goods entity) {
        goods.add(entity);
        return entity;
    }

    public Goods remove(Goods entity) {
        goods.add(entity);
        return entity;
    }

    public Goods removeById(int id) {
        Goods entity = goods.get(id);
        goods.remove(entity);
        return entity;
    }
}
