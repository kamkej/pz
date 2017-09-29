/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.propertyeditor;

import com.telefonica.oss.pocpz.model.entity.Ingrediente;
import com.telefonica.oss.pocpz.model.repository.IngredientesRepository;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author G0006185
 */
@Component
public class IngredientesPropertyEditor extends PropertyEditorSupport{
    
    @Autowired private IngredientesRepository ingredientesRepository;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
       long idIngrediente = Long.parseLong(text);
        Ingrediente ingrediente = ingredientesRepository.findOne(idIngrediente);
        setValue(ingrediente);
    }

    
}
