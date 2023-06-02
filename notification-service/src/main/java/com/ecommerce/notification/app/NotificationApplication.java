package com.ecommerce.notification.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import com.ecommerce.biblioteca.dto.ProductoDto;
import com.ecommerce.notification.app.event.ProductoWithCategoria;

import lombok.extern.slf4j.Slf4j;

@EnableKafka
@SpringBootApplication
@Slf4j
public class NotificationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
	
	
	public void handleNotification(ProductoWithCategoria p) {
		log.info("Notificacion recibida desde Producto  - {} ",p);
	}
}
