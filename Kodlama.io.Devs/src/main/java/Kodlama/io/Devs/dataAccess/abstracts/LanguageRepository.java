/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;

/**
 *
 * @author x555u
 */
public interface LanguageRepository {

    void add(Language language);

    void delete(int id);

    void update(Language predecessor, Language succesor);

    List<Language> getAllLanguages();
    
    Language getLangById(int id);
}
