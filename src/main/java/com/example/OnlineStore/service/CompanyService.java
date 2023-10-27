package com.example.OnlineStore.service;

import com.example.OnlineStore.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public String getCompanyPage(Model model) {
        model.addAttribute("company0", companyRepository.findById(0).getName());
        model.addAttribute("company1", companyRepository.findById(1).getName());
        model.addAttribute("company2", companyRepository.findById(2).getName());
        model.addAttribute("company3", companyRepository.findById(3).getName());
        model.addAttribute("company4", companyRepository.findById(4).getName());
        return "company";
    }
}
