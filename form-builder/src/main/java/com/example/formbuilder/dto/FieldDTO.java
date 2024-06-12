package com.example.formbuilder.dto;

import lombok.Data;

@Data
public class FieldDTO {
    private Long id;
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
