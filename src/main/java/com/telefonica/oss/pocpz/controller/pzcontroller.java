/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.controller;


import static com.telefonica.oss.pocpz.controller.IngredienteController.log;
import com.telefonica.oss.pocpz.exception.IngredientesException;
import com.telefonica.oss.pocpz.model.entity.Ingrediente;
import com.telefonica.oss.pocpz.model.entity.Pizza;
import com.telefonica.oss.pocpz.model.enumeration.Tamanho;
import com.telefonica.oss.pocpz.model.repository.IngredientesRepository;
import com.telefonica.oss.pocpz.model.repository.PizzaRepository;
import com.telefonica.oss.pocpz.propertyeditor.IngredientesPropertyEditor;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author G0006185
 */
@Controller
@RequestMapping(value="/pizzas")
public class pzcontroller {
     @Autowired private IngredientesPropertyEditor ingredientesPropertyEditor;
    
    @Autowired private PizzaRepository pizzaRepository;
    @Autowired private IngredientesRepository ingredientesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getPizza(Model model){
        model.addAttribute("pizza",pizzaRepository.findAll());
        model.addAttribute("tamanhos",Tamanho.values());
        model.addAttribute("ingredientes",ingredientesRepository.findAll());
        return "pizza/list";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String savePizza(
            Model model,
            @Valid @ModelAttribute Pizza pizza,
            BindingResult bindingResult){

         if(bindingResult.hasErrors()){
            
            FieldError error = bindingResult.getFieldErrors().get(0);
            log.info("Erro ao salvar esse: " + error.getField()+" "+error.getDefaultMessage());
            throw new IngredientesException();
        }else{
           pizzaRepository.save(pizza);          
        }
        model.addAttribute("pizza",pizzaRepository.findAll());
        model.addAttribute("tamanhos", Tamanho.values());
        return "pizza/tabela-pizzas";
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{pizzaId}")
    public ResponseEntity<String> delPizza(@PathVariable Long pizzaId){
        try{
            pizzaRepository.delete(pizzaId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{pizzaId}")
    public ResponseEntity<Pizza> getPizza(@PathVariable Long pizzaId){
        Pizza pizza = pizzaRepository.findOne(pizzaId);
        return new ResponseEntity<>(pizza,HttpStatus.OK);
    }
    
    @InitBinder
    public void initBainder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Ingrediente.class, ingredientesPropertyEditor);
    }
 
}
