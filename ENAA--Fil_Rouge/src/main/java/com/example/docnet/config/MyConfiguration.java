//
//package com.example.ENAA__Fil_Rouge.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//public class MyConfiguration implements WebMvcConfigurer {
//
//    @Configuration
//    public static class WebConfig implements WebMvcConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/")
//                    .allowedOrigins("")
//                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                    .allowedHeaders("");
//        }
//
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/images/")
//                    .addResourceLocations("classpath:/img/");
//        }
//
//
//
//        @Bean
//        public CorsConfigurationSource corsConfigurationSource() {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(List.of("http://localhost:4200"));
//            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//            configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//            configuration.setExposedHeaders(List.of("Authorization"));
//            configuration.setAllowCredentials(true);
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//        }
//
//
//    }
//}
