/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author x555u
 */
@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private final String ALERT_EMPTY = "programming language can not be empty";
    private final String ALERT_RECURE = "programming language already exists";
    private final String ALERT_NOT_FOUND = "programming language can not found";

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(Language language) throws Exception {
        if (isAlreadyExists(language)) {
            throw new Exception(ALERT_RECURE);
        }
        if (isEmpty(language)) {
            throw new Exception(ALERT_EMPTY);
        }
        languageRepository.add(language);
    }

    @Override
    public void delete(int id) throws Exception {
        if (isEmpty(languageRepository.getLangById(id))) {
            throw new Exception(ALERT_EMPTY);
        }
        languageRepository.delete(id);

    }

    @Override
    public void update(int predecessorId, Language succesor) throws Exception {
        if (isAlreadyExists(succesor)) {
            throw new Exception("succesor " + ALERT_RECURE);
        } else if (isEmpty(succesor)) {
            throw new Exception(ALERT_EMPTY);
        } else if (!isAlreadyExists(getLangById(predecessorId))) {
            throw new Exception(" programmin language to be changed does not exists");
        }

        getAllLanguages().remove(getLangById(predecessorId));
        getAllLanguages().add(succesor);

    }

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.getAllLanguages();
    }

    @Override
    public Language getLangById(int id) throws Exception{
        if (languageRepository.getLangById(id) == null){
            throw new Exception (ALERT_NOT_FOUND);
        }
        return languageRepository.getLangById(id);
    }

    @Override
    public boolean isEmpty(Language language) {
        if (language.getName().trim().isBlank()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAlreadyExists(Language language) {
        for (Language languageItem : getAllLanguages()) { 
            if (languageItem.getName().equals(language.getName()) && languageItem.getId() == language.getId()) {
                return true;
            }
        }
        return false;
    }
}
