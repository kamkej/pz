/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.controller;

import com.telefonica.oss.pocpz.exception.IngredientesException;
import com.telefonica.oss.pocpz.model.entity.Ingrediente;
import com.telefonica.oss.pocpz.model.enumeration.Categoria;
import com.telefonica.oss.pocpz.model.repository.IngredientesRepository;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author G0006185
 */
@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {
    static final Logger log = LogManager.getLogger();
    @Autowired private IngredientesRepository ingredientesRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listIngredientes(Model model){
        Iterable<Ingrediente> ingredientes = ingredientesRepository.findAll();
        
        model.addAttribute("title","Lista de ingredientes");
        model.addAttribute("lista",ingredientes);
        model.addAttribute("categorias", Categoria.values());
        return "ingredientes/list";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String saveIngredientes(@Valid @ModelAttribute Ingrediente ingrediente, 
            BindingResult bindingResult, 
            RedirectAttributes redirectAttributes,
            Model model){

        if(bindingResult.hasErrors()){
            FieldError error = bindingResult.getFieldErrors().get(0);
            log.info("Erro ao salvar: " + error.getField()+" "+error.getDefaultMessage());
            throw new IngredientesException();
        }else{
            ingredientesRepository.save(ingrediente); 
           
        }
        model.addAttribute("lista",ingredientesRepository.findAll());
        model.addAttribute("categorias", Categoria.values());
        return "/ingredientes/tabela-ingredientes";
    }
}
