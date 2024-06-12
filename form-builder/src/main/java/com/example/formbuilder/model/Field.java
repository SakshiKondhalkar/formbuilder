package com.example.formbuilder.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    private String label;
    private boolean isRequired;
    private String type;
    private Integer maxLength;
    private Integer minLength;
    private String allowedPattern;
    private Double maxValue;
    private Double minValue;
    private Boolean isInteger;
    private Integer maxDecimalPlaces;
}
