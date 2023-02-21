/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x555u
 */
@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages;
    

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));
    }
    @Override
    public Language getLangById(int id) {
        for (Language languageItem : languages) {
            if (languageItem.getId() == id) {
                return languageItem;
            }
        }
        return null;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void delete(int id) {
        languages.remove(getLangById(id));
    }

    @Override
    public void update(Language predecessor, Language succesor) {
        delete(predecessor.getId());
        languages.add(succesor);
    }

    @Override
    public List<Language> getAllLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
    
   
}
