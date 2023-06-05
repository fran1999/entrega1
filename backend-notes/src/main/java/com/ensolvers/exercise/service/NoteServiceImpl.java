/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ensolvers.exercise.service;

import com.ensolvers.exercise.model.Note;
import com.ensolvers.exercise.repository.NoteRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author franco
 */
@Service
public class NoteServiceImpl extends BaseServiceImpl<Note, Long> implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    
}
