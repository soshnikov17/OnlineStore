package com.example.OnlineStore.mapper;

import com.example.OnlineStore.dto.GoodsDto;
import com.example.OnlineStore.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GoodsMapper {

    GoodsDto toDto(Goods goods);

    Goods toEntity(GoodsDto goodsDto);

    List<GoodsDto> toDtos(List<Goods> entities);

    List<Goods> toEntities(List<GoodsDto> dtos);
}
