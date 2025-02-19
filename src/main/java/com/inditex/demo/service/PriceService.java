package com.inditex.demo.service;

import com.inditex.demo.mapper.PriceMapper;
import com.inditex.demo.model.dto.PriceDTO;
import com.inditex.demo.model.entity.Price;
import com.inditex.demo.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * Servicio para la gestion de consultas de los precios
 */
@Slf4j
@Service
public class PriceService {

    // Repositorio de la tabla precios
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Realiza una consulta a base de datos y obtiene un precio aplicado para un producto
     * @param dateApplication Fecha aplicada del producto
     * @param productId Identificador del producto
     * @param brandId Identificador de la cadena
     * @return El precio final consultado
     */
    public PriceDTO getPrice(LocalDateTime dateApplication,
                             Long productId,
                             Long brandId) {
        log.info("Start method PriceService.getPrice");

        // Consulta a base de datos por los precios disponibles por la fecha aplicada
        List<Price> pricesFounded = priceRepository.findPriceByBrandAndDateApplication(brandId, productId, dateApplication);
        log.debug("Prices founded: {}", pricesFounded);

        // Obtenemos el precio con mayor prioridad o una respuesta 204 en el caso de no tener ningun registro
        Price finalPrice = pricesFounded.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,
                        "No se ha encontrado el precio del producto " + productId));
        log.debug("Final price: {}", finalPrice);

        log.info("End method PriceService.getPrice");
        return PriceMapper.INSTANCE.toPriceDTO(finalPrice, dateApplication);
    }
}
