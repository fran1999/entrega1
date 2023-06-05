/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ensolvers.exercise.repository;

import org.springframework.stereotype.Repository;
import com.ensolvers.exercise.model.Note;

/**
 *
 * @author franco
 */
@Repository
public interface NoteRepository extends BaseRepository<Note, Long>{
    
}
