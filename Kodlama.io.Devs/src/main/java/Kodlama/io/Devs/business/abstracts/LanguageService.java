/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;


/**
 *
 * @author x555u
 */

public interface LanguageService {

    void add(Language language) throws Exception;

    void delete(int id) throws Exception;

    void update(int predecessorId, Language succesor) throws Exception;

    List<Language> getAllLanguages();
    
    Language getLangById(int id) throws Exception;
    
    boolean isAlreadyExists(Language language);
    
    boolean isEmpty(Language language);
}
