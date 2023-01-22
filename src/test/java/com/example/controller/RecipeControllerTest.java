package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
 class RecipeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateRecipe() throws Exception {

        
    }

}
