package com.inditex.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Cuerpo de salida que contiene el precio final consultado para aplicar del producto
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    // Identificador del producto
    @JsonProperty
    private Long productId;

    // Identificador de la cadena
    @JsonProperty
    private Long brandId;

    // Identificador de la tarifa de precios aplicable
    @JsonProperty
    private Long priceList;

    // Fecha de aplicacion del precio
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateApplication;

    // Precio final aplicado
    @JsonProperty
    private String finalPrice;
}
