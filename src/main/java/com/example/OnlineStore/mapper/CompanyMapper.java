package com.example.OnlineStore.mapper;

import com.example.OnlineStore.dto.CompanyDto;
import com.example.OnlineStore.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    Company toEntity(CompanyDto companyDto);
}
