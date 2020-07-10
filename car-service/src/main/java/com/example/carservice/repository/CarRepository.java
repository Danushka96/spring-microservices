package com.example.carservice.repository;

import com.example.carservice.documents.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

/**
 * @author danushka
 * 7/10/2020
 */
public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {
}
