package com.example.OnlineStore.repository;

import com.example.OnlineStore.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CompanyRepository {
    private final List<Company> company = new LinkedList<>() {{
        this.add(new Company("DPD"));
        this.add(new Company("Pochta"));
        this.add(new Company("SDEK"));
        this.add(new Company("Horizont"));
        this.add(new Company("FedEx"));
    }};

    public List<Company> findAll() {
        return company;
    }

    public Company findById(int id) {
        return company.get(id);
    }

    public Company save(Company entity) {
        company.add(entity);
        return entity;
    }

    public Company remove(Company entity) {
        company.remove(entity);
        return entity;
    }

    public Company removeById(int id) {
        Company entity = company.get(id);
        company.remove(id);
        return entity;
    }

}
