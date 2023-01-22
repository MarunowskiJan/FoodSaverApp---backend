package com.example;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FoodsaverApplicationTests {
	
	private ApplicationContext context;

	@Test
	void shouldLoadContext() {
		then(context).isNotNull();
	}
}
