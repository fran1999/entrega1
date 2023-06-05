/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ensolvers.exercise.controller;

/**
 *
 * @author franco
 */
import com.ensolvers.exercise.model.Note;
import com.ensolvers.exercise.service.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/notes")
public class NoteController extends BaseControllerImpl <Note, NoteServiceImpl >{
    @Autowired
    private NoteServiceImpl NoteService;
    
}
