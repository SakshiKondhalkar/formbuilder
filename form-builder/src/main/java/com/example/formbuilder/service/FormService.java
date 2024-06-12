package com.example.formbuilder.service;

import com.example.formbuilder.dto.FormDTO;
import com.example.formbuilder.dto.FieldDTO;
import com.example.formbuilder.model.Form;
import com.example.formbuilder.model.Field;
import com.example.formbuilder.repository.FormRepository;
import com.example.formbuilder.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Transactional
    public FormDTO createForm(FormDTO formDTO) {
        Form form = new Form();
        form.setTitle(formDTO.getTitle());
        form = formRepository.save(form);

        List<Field> fields = formDTO.getFields().stream().map(fieldDTO -> {
            Field field = new Field();
            field.setForm(form);
            field.setLabel(fieldDTO.getLabel());
            field.setRequired(fieldDTO.isRequired());
            field.setType(fieldDTO.getType());
            field.setMaxLength(fieldDTO.getMaxLength());
            field.setMinLength(fieldDTO.getMinLength());
            field.setAllowedPattern(fieldDTO.getAllowedPattern());
            field.setMaxValue(fieldDTO.getMaxValue());
            field.setMinValue(fieldDTO.getMinValue());
            field.setIsInteger(fieldDTO.getIsInteger());
            field.setMaxDecimalPlaces(fieldDTO.getMaxDecimalPlaces());
            return field;
        }).collect(Collectors.toList());

        fieldRepository.saveAll(fields);

        formDTO.setId(form.getId());
        return formDTO;
    }

    public List<FormDTO> getForms() {
        return formRepository.findAll().stream().map(form -> {
            FormDTO formDTO = new FormDTO();
            formDTO.setId(form.getId());
            formDTO.setTitle(form.getTitle());
            formDTO.setFields(form.getFields().stream().map(field -> {
                FieldDTO fieldDTO = new FieldDTO();
                fieldDTO.setId(field.getId());
                fieldDTO.setLabel(field.getLabel());
                fieldDTO.setRequired(field.isRequired());
                fieldDTO.setType(field.getType());
                fieldDTO.setMaxLength(field.getMaxLength());
                fieldDTO.setMinLength(field.getMinLength());
                fieldDTO.setAllowedPattern(field.getAllowedPattern());
                fieldDTO.setMaxValue(field.getMaxValue());
                fieldDTO.setMinValue(field.getMinValue());
                fieldDTO.setIsInteger(field.getIsInteger());
                fieldDTO.setMaxDecimalPlaces(field.getMaxDecimalPlaces());
                return fieldDTO;
            }).collect(Collectors.toList()));
            return formDTO;
        }).collect(Collectors.toList());
    }
}
