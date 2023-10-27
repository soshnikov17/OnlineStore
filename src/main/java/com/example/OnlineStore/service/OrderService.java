package com.example.OnlineStore.service;

import com.example.OnlineStore.dto.CompanyDto;
import com.example.OnlineStore.dto.GoodsDto;
import com.example.OnlineStore.dto.OrderDto;
import com.example.OnlineStore.dto.UserDto;
import com.example.OnlineStore.entity.Company;
import com.example.OnlineStore.entity.Goods;
import com.example.OnlineStore.entity.Order;
import com.example.OnlineStore.entity.User;
import com.example.OnlineStore.exception.DataValidationException;
import com.example.OnlineStore.mapper.CompanyMapper;
import com.example.OnlineStore.mapper.GoodsMapper;
import com.example.OnlineStore.mapper.OrderMapper;
import com.example.OnlineStore.mapper.UserMapper;
import com.example.OnlineStore.repository.OrderRepository;
import com.example.OnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final GoodsMapper goodsMapper;
    private final CompanyMapper companyMapper;

    public OrderDto save(OrderDto order) {
        Order entity = orderMapper.toEntity(order);
        return orderMapper.toDto(orderRepository.save(entity));
    }

    public OrderDto remove(int id) {
        return orderMapper.toDto(orderRepository.removeById(id));
    }

    public List<GoodsDto> setGoods(int id, List<GoodsDto> goods) {
        validateGoods(goods);
        List<Goods> entities = goodsMapper.toEntities(goods);
        return goodsMapper.toDtos(orderRepository.setGoods(id, entities));
    }

    public UserDto setUser(int id, UserDto user) {
        validateUser(user);
        User entity = userMapper.toEntity(user);
        userRepository.save(entity);
        return userMapper.toDto(orderRepository.setUser(id, entity));
    }

    public CompanyDto setCompany(int id, CompanyDto company) {
        validateCompany(company);
        Company entity = companyMapper.toEntity(company);
        return companyMapper.toDto(orderRepository.setCompany(id, entity));
    }

    public String getCheckOrderPage(int id, Model model) {
        Order order = orderRepository.findById(id);
        model.addAttribute("name", order.getUser().getName());
        model.addAttribute("surname", order.getUser().getSurname());
        model.addAttribute("phone", order.getUser().getPhone());
        model.addAttribute("email", order.getUser().getEmail());
        model.addAttribute("address", order.getUser().getAddress());
        model.addAttribute("company", order.getCompany().getName());
        model.addAttribute("goods", order.getGoods());
        return "order";
    }


    private void validateGoods(List<GoodsDto> goods) {
        if (goods == null) {
            throw new DataValidationException("Goods is null!");
        }
        if (goods.isEmpty()) {
            throw new DataValidationException("Goods is empty!");
        }
    }

    private void validateUser(UserDto user) {
        if (user == null) {
            throw new DataValidationException("User is null!");
        }
        if (user.getName() == null) {
            throw new DataValidationException("Name is null!");
        }
        if (user.getSurname() == null) {
            throw new DataValidationException("Surname is null!");
        }
        if (user.getEmail() == null) {
            throw new DataValidationException("Email is null!");
        }
        if (user.getPhone() == null) {
            throw new DataValidationException("Phone is null!");
        }
        if (user.getAddress() == null) {
            throw new DataValidationException("Address is null!");
        }
    }

    private void validateCompany(CompanyDto company) {
        if (company == null) {
            throw new DataValidationException("Company is null!");
        }
        if (company.getName() == null) {
            throw new DataValidationException("Company name is null!");
        }
    }
}
