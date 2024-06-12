package com.example.formbuilder.controller;

import com.example.formbuilder.dto.FormDTO;
import com.example.formbuilder.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping
    public ResponseEntity<FormDTO> createForm(@RequestBody FormDTO formDTO) {
        FormDTO createdForm = formService.createForm(formDTO);
        return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormDTO>> getForms() {
        List<FormDTO> forms = formService.getForms();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }
}
