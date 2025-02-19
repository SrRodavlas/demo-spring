package com.inditex.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price {

    // Identificador
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificador de la cadena
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    // Fecha inicio
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    // Fecha fin
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    // Identificador de la tarifa de precios aplicable
    @Column(name = "PRICE_LIST", nullable = false)
    private Long priceList;

    // Identificador del producto
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    // Prioridad
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    // Precio final de venta
    @Column(name = "PRICE", nullable = false)
    private Double finalPrice;

    // Divisa
    @Column(name = "CURR", nullable = false, length = 3)
    private String currency;
}
