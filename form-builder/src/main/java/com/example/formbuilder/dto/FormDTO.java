package com.example.formbuilder.dto;

import lombok.Data;
import java.util.List;

@Data
public class FormDTO {
    private Long id;
    private String title;
    private List<FieldDTO> fields;
}
