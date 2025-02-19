package com.inditex.demo.controller;

import com.inditex.demo.model.dto.PriceDTO;
import com.inditex.demo.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    private final PriceService priceService;

    DemoController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Realiza una consulta a base de datos y obtiene un precio aplicado para un producto
     * @param dateApplication Fecha aplicada del producto
     * @param productId Identificador del producto
     * @param brandId Identificador de la cadena
     * @return El precio final consultado
     */
    @GetMapping(value = "/check-price")
    public PriceDTO checkPrice(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateApplication,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        return priceService.getPrice(dateApplication, productId, brandId);
    }
}
