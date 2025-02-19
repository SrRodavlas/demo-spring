package com.inditex.demo;

import com.inditex.demo.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DemoController demoController;

	@Test
	void contextLoads() {
		assertThat(demoController).isNotNull();
	}

}
