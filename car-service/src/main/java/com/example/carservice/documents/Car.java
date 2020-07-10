package com.example.carservice.documents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author danushka
 * 7/10/2020
 */
@Document
@Data
@NoArgsConstructor
public class Car {
    @Id
    private UUID id;
    private String name;
    private LocalDate releaseData;

    public Car(UUID id, String name, LocalDate releaseData) {
        this.id = id;
        this.name = name;
        this.releaseData = releaseData;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(LocalDate releaseData) {
        this.releaseData = releaseData;
    }
}
