package com.inditex.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void firstTest() throws Exception {
        String expectedResponse = """
                {
                    "productId": 35455,
                    "brandId": 1,
                    "priceList": 1,
                    "dateApplication": "2020-06-14 10:00:00",
                    "finalPrice": "35,50"
                }
                """;

        mvc.perform(get("/demo/check-price")
                        .param("dateApplication", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    void secondTest() throws Exception {
        String expectedResponse = """
                {
                    "productId": 35455,
                    "brandId": 1,
                    "priceList": 2,
                    "dateApplication": "2020-06-14 16:00:00",
                    "finalPrice": "25,45"
                }
                """;

        mvc.perform(get("/demo/check-price")
                        .param("dateApplication", "2020-06-14 16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    void thirdTest() throws Exception {
        String expectedResponse = """
                {
                    "productId": 35455,
                    "brandId": 1,
                    "priceList": 1,
                    "dateApplication": "2020-06-14 21:00:00",
                    "finalPrice": "35,50"
                }
                """;

        mvc.perform(get("/demo/check-price")
                        .param("dateApplication", "2020-06-14 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    void fourthTest() throws Exception {
        String expectedResponse = """
                {
                    "productId": 35455,
                    "brandId": 1,
                    "priceList": 3,
                    "dateApplication": "2020-06-15 10:00:00",
                    "finalPrice": "30,50"
                }
                """;

        mvc.perform(get("/demo/check-price")
                        .param("dateApplication", "2020-06-15 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    void fifthTest() throws Exception {
        String expectedResponse = """
                {
                    "productId": 35455,
                    "brandId": 1,
                    "priceList": 4,
                    "dateApplication": "2020-06-16 21:00:00",
                    "finalPrice": "38,95"
                }
                """;

        mvc.perform(get("/demo/check-price")
                        .param("dateApplication", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }
}
