package com.manga.application.mangarocks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class MangaRocksApplication {

	public static void main(String[] args) {
		log.info("Starting the MangaRocks Server....");
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SpringApplication.run(MangaRocksApplication.class, args);
		log.info("MangaRocks Server is up!! with timezone {}", TimeZone.getDefault());
	}

}
