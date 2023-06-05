/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ensolvers.exercise.service;

/**
 *
 * @author franco
 */
import com.ensolvers.exercise.model.Base;
import com.ensolvers.exercise.repository.BaseRepository;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID>{
    
    @Autowired
    protected BaseRepository<E, ID> baseRepository;
    
    @Override
    public List<E> findAll() throws Exception {
     try {
          List<E> entities = baseRepository.findAll();
          return entities;
     }catch (Exception e){
          throw new Exception(e.getMessage());
     }       
    }

    @Override
    public E findById(ID id) throws Exception {
     try {
         Optional<E> entityOptional = baseRepository.findById(id);
         return entityOptional.get();
         
     }catch (Exception e){
         throw new Exception(e.getMessage());
     }  
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
      try{
        
        entity = baseRepository.save(entity);
      return entity;
      }catch (Exception e){
           throw new Exception(e.getMessage());
      }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
       try {
          Optional <E> entityOptional = baseRepository.findById(id);
          E account = entityOptional.get();
          
          account = baseRepository.save(entity);
          return account;
     }catch (Exception e){
          throw new Exception(e.getMessage());
     }  
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
       try {
         if(baseRepository.existsById(id)){
             baseRepository.deleteById(id);
             return true;
         }else {
             throw new Exception();
         }
           
     }catch (Exception e){
         throw new Exception(e.getMessage());
     }  
    }
}
