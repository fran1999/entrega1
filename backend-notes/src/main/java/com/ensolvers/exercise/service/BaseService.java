/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ensolvers.exercise.service;

import com.ensolvers.exercise.model.Base;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author franco
 */
public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception;
    public E findById(ID id)throws Exception;
    public E save(E entity)throws Exception;
    public E update(ID id, E entity)throws Exception;
    public boolean delete(ID id)throws Exception;    
}
