/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author G0006185
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class IngredientesException extends RuntimeException{
    
}
