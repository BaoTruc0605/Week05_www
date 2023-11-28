package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.converter;

import jakarta.persistence.AttributeConverter;



public class SkillLevelConverter implements AttributeConverter{
    @Override
    public Object convertToDatabaseColumn(Object attribute) {
        return null;
    }

    @Override
    public Object convertToEntityAttribute(Object dbData) {
        return null;
    }
}
