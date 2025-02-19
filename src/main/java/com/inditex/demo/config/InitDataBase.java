package com.inditex.demo.config;

import com.inditex.demo.model.entity.Price;
import com.inditex.demo.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Configuration
public class InitDataBase {

    @Bean
    CommandLineRunner loadInitialData(PriceRepository priceRepository) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return args -> {
            priceRepository.save(new Price(null, 1L, LocalDateTime.parse("2020-06-14 00:00:00", formatter),
                    LocalDateTime.parse("2020-12-31 23:59:59", formatter), 1L, 35455L, 0,
                    35.5, "EUR"));
            priceRepository.save(new Price(null, 1L, LocalDateTime.parse("2020-06-14 15:00:00", formatter),
                    LocalDateTime.parse("2020-06-14 18:30:00", formatter), 2L, 35455L, 1,
                    25.45, "EUR"));
            priceRepository.save(new Price(null, 1L, LocalDateTime.parse("2020-06-15 00:00:00", formatter),
                    LocalDateTime.parse("2020-06-15 11:00:00", formatter), 3L, 35455L, 1,
                    30.5, "EUR"));
            priceRepository.save(new Price(null, 1L, LocalDateTime.parse("2020-06-15 16:00:00", formatter),
                    LocalDateTime.parse("2020-12-31 23:59:59", formatter), 4L, 35455L, 1,
                    38.95, "EUR"));
            log.info("La base de datos ha sido inicializada");
        };
    }
}
