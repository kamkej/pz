/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.controller;

import com.telefonica.oss.pocpz.model.entity.Ingrediente;
import com.telefonica.oss.pocpz.model.repository.IngredientesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        log.info("HI...");
        Iterable<Ingrediente> ingredientes = ingredientesRepository.findAll();
        
        model.addAttribute("title","Lista de ingredientes");
        model.addAttribute("lista",ingredientes);
        return "ingredientes/list";
    }
}
