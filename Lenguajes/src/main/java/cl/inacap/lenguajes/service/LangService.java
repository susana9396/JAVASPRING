package cl.inacap.lenguajes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cl.inacap.lenguajes.models.Language;
import cl.inacap.lenguajes.repository.LangRepo;

@Service
public class LangService {
	private final LangRepo langRepo;
	
	public LangService(LangRepo langRepo) {
		this.langRepo=langRepo;
	}
	
	public List<Language> all(){
		return langRepo.findAll();
	}

	public Language addL(@Valid Language lang) {
		return langRepo.save(lang);
		
	}

	public Language findL(Long id) {
		Optional<Language> l=langRepo.findById(id);
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}

	public Language update(Long id, String name, String creator, Integer curren_version) {
		
		Language lang=findL(id);
		if(lang==null) {
			return null;
		}
		
		lang.setName(name);
		lang.setCurrenVersion(curren_version);
		lang.setCreator(creator);
		
		return langRepo.save(lang);
		
	}

	public void delete(Long id) {
		Language lang=findL(id);
		if(lang==null) {
			return;
		}
		langRepo.deleteById(id);
		
	}

	public void update(@Valid Language lang) {
		langRepo.save(lang);
	}



}
