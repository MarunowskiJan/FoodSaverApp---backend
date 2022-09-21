package com.example;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class FoodSaverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodSaverApplication.class, args);
		
//		ArrayList<Ingredient> ingredients = new ArrayList<>();
//		
//		
//		ingredients.add(new Ingredient("egg", "https://fitking.pl/fitking/wp-content/uploads/2018/10/AR-180529664.jpg"));
//		ingredients.add(new Ingredient("water", "https://www.vichy.pl/site/pages/showImageResized.aspx?EncMediaId=Uit4VzMxV2FsT1Y2TU4wbzVFUnlYUT09&ImageFormatAppCode=IMAGEFORMAT_ORIGINAL&v=220229124798"));
//		ingredients.add(new Ingredient("salt", "https://kuchnialidla.pl/img/PL/1250x700/be84b8350ce5-1929b7d50f50-LIDL_co_zlego_robi_sol.jpg"));
		
		
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);

	}

}
