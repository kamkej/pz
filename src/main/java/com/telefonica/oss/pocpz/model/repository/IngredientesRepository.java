/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.oss.pocpz.model.repository;


import com.telefonica.oss.pocpz.model.entity.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author G0006185
 */
@Repository
public interface IngredientesRepository extends CrudRepository<Ingrediente, Long>{
    
}
