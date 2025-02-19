package com.inditex.demo.mapper;

import com.inditex.demo.model.dto.PriceDTO;
import com.inditex.demo.model.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    /**
     * Mapea la entidad precio por el cuerpo de salida
     * @param price Entidad de precio
     * @param dateApplication // Fecha de aplicacion del precio
     * @return PriceDTO
     * @See PriceDTO
     */
    @Mapping(target = "productId", source = "price.productId")
    @Mapping(target = "brandId", source = "price.brandId")
    @Mapping(target = "priceList", source = "price.priceList")
    @Mapping(target = "finalPrice", source = "price.finalPrice", numberFormat = "0.00")
    @Mapping(target = "dateApplication", source = "dateApplication")
    PriceDTO toPriceDTO(Price price, LocalDateTime dateApplication);
}
