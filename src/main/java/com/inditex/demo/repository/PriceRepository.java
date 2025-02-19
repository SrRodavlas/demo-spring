package com.inditex.demo.repository;

import com.inditex.demo.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Consulta de precios aplicados dentro de la fecha aplicada si se encuentra dentro del rango de fechas
     * @param brandId Identificador de la cadena
     * @param productId Identificador del producto
     * @param dateApplication Fecha aplicada del producto
     * @return Lista de registros de precios aplicados
     */
    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId AND (p.startDate <= :dateApplication AND p.endDate >= :dateApplication)")
    List<Price> findPriceByBrandAndDateApplication(@Param("brandId") Long brandId,
                                   @Param("productId") Long productId,
                                   @Param("dateApplication") LocalDateTime dateApplication);
}
