package com.example.OnlineStore;

import com.example.OnlineStore.entity.Company;
import com.example.OnlineStore.entity.Goods;
import com.example.OnlineStore.entity.Order;
import com.example.OnlineStore.entity.User;
import com.example.OnlineStore.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        List<Goods> goods = List.of(new Goods("мяч"), new Goods("чашка"));
        User user = new User("Ivan", "Ivanov", "ivan@gmail.com", "1234567890", "New York");
        Company company = new Company("DPD");
        Order order = new Order(user, goods, company);
        orderRepository.save(order);
    }

    @AfterEach
    void removeData() {
        for (int i = 0; i < orderRepository.findAll().size(); i++) {
            orderRepository.removeById(i);
        }
    }

    @Test
    public void testSaveOrder() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/order"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Assertions.assertEquals(2, orderRepository.findAll().size());
    }

    @Test
    public void testDeleteOrder() throws Exception {
        this.mockMvc.perform(delete("/order/0"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Assertions.assertEquals(0, orderRepository.findAll().size());
    }

    @Test
    public void testPrintUserPage() throws Exception {
        this.mockMvc.perform(get("/order/0/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    public void testPrintCompanyPage() throws Exception {
        this.mockMvc.perform(get("/order/0/company"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    public void testPrintCheckOrderPage() throws Exception {
        this.mockMvc.perform(get("/order/0/check"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    public void testSetGoods() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/0/goods")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{\"name\":\"Мясо\"}]"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Мясо"));
    }

    @Test
    public void testSetUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/0/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"name\":\"Kirill\"," +
                                " \"surname\":\"Soshnikov\"," +
                                " \"email\":\"service@gmail.com\"," +
                                " \"phone\":\"1234567890\"," +
                                "\"address\":\"Ryazan\"" +
                                "}"
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Kirill"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Soshnikov"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("service@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("1234567890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Ryazan"));
    }

    @Test
    public void testSetCompany() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/0/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pochta\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Pochta"));
    }
}

