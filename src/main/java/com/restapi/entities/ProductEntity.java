package com.restapi.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends PanacheEntity {

    /*
    @Id
    @GeneratedValue
    private Long id;
    */

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate updateDate;

}
