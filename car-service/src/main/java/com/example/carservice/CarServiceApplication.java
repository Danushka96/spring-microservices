package com.example.carservice;

import com.example.carservice.documents.Car;
import com.example.carservice.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository carRepository){
        Car ID = new Car(UUID.randomUUID(), "ID.", LocalDate.of(2019, Month.DECEMBER, 1));
        Car ID_CROZZ = new Car(UUID.randomUUID(), "ID. CROZZ", LocalDate.of(2021, Month.MAY, 1));
        Car ID_VIZZION = new Car(UUID.randomUUID(), "ID. VIZZION", LocalDate.of(2021, Month.DECEMBER, 1));
        Car ID_BUZZ = new Car(UUID.randomUUID(), "ID. BUZZ", LocalDate.of(2021, Month.DECEMBER, 1));
        Set<Car> vwConcepts = new HashSet<>();
        vwConcepts.add(ID);
        vwConcepts.add(ID_BUZZ);
        vwConcepts.add(ID_CROZZ);
        vwConcepts.add(ID_VIZZION);

        return args -> {
            carRepository.deleteAll()
                    .thenMany(
                            Flux.just(vwConcepts).flatMap(carRepository::saveAll)
                    )
                    .thenMany(carRepository.findAll())
                    .subscribe(car -> System.out.println("saving "+car.toString()));
        };
    }
}
