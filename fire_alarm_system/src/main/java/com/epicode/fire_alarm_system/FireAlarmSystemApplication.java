package com.epicode.fire_alarm_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.fire_alarm_system.models.Feeler;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class FireAlarmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireAlarmSystemApplication.class, args);
		Feeler f1 = new Feeler(1, 0, 41.8915, 12.4912);
		Feeler f2 = new Feeler(1, 3,45.4645, 9.1916 );
	    for (int i = 0; i < 3; i++) {
       	try {
			f1.setSmokeLevel(f1.getSmokeLevel()+1);
			f2.setSmokeLevel(f2.getSmokeLevel()+1);
       	    Thread.sleep(1000);
       	} catch (InterruptedException e) {
       	    e.getMessage();
		}
		log.info("f1 smoke level = " + f1.getSmokeLevel()); 
		log.info("f2 smoke level = " + f2.getSmokeLevel());		
		}
	}

}
