/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kodlama.io.Devs.webApi.controllers;


import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author x555u
 */
@RestController
@RequestMapping ("/api/languages")
public class LanguagesController {
    LanguageService languageService;
    
    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    
    @GetMapping ("/getById")
    public Language getLangById(int id) throws Exception{
        return languageService.getLangById(id);
    }

   @GetMapping ("/add")
    public void add(Language language) throws Exception{
       languageService.add(language);
    }

    @GetMapping ("/delete")
    public void delete(int id) throws Exception{
        languageService.delete(id);
    }

    @GetMapping ("/update")
    public void update(int predecessorId, Language succesor) throws Exception{
       languageService.update(predecessorId, succesor);
    }

    @GetMapping ("/getAll")
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }
}
