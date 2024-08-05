package com.test.testApi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.testApi.data.repository.MyRepository;

@SpringBootTest
class TestApiApplicationTests {

	@Autowired
	MyRepository myRepository;
	@Test
	void contextLoads() {
		Assertions.assertThat(myRepository).isNotNull();
	}

}
