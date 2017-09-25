/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.controller;


import static com.telefonica.oss.pocpz.controller.IngredienteController.log;
import com.telefonica.oss.pocpz.exception.IngredientesException;
import com.telefonica.oss.pocpz.model.entity.Pizza;
import com.telefonica.oss.pocpz.model.enumeration.Categoria;
import com.telefonica.oss.pocpz.model.enumeration.Tamanho;
import com.telefonica.oss.pocpz.model.repository.PizzaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author G0006185
 */
@Controller
@RequestMapping(value="/pizzas")
public class pzcontroller {
    @Autowired private PizzaRepository pizzaRepository;
    
   /* @ResponseBody
    @RequestMapping()
    public String Hi() {
        
        return "Hi ;)";
    }
    @RequestMapping(value="/ola/{name}")
    @ResponseBody
    public String Hi(@PathVariable String name){

        return "Hi again "+name;
    }
    @RequestMapping(value="/howmany")
    @ResponseBody
    public String howMany(){
   
        return "Total: "+pizzaRepository.count();
    }*/
    //==============================
    @RequestMapping(method = RequestMethod.GET)
    public String getPizza(Model model){
        model.addAttribute("pizza",pizzaRepository.findAll());
        model.addAttribute("tamanhos",Tamanho.values());
        return "pizza/list";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String savePizza(@Valid @ModelAttribute Pizza pizza,BindingResult bindingResult ,Model model){

         if(bindingResult.hasErrors()){
            FieldError error = bindingResult.getFieldErrors().get(0);
            log.info("Erro ao salvar: " + error.getField()+" "+error.getDefaultMessage());
            throw new IngredientesException();
        }else{
           pizzaRepository.save(pizza);
           
        }
        model.addAttribute("pizza",pizzaRepository.findAll());
        model.addAttribute("tamanhos", Tamanho.values());
        return "pizza/tabela-pizzas";
    }
 
}
