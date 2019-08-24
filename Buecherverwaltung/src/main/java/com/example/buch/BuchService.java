package com.example.buch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuchService {
	
	@Autowired
	private BuchRepository buchRepo;
	
	public List<Buch> listAll(){
		return buchRepo.findAll();	 
	}
	
	public void save(Buch buch) {
		buchRepo.save(buch);
	}
	
	public Buch get(Integer id) {
		return buchRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		buchRepo.deleteById(id);
	}
	
	public List<Buch> findAllByOrderByPreisAsc(){
		List<Buch> buchListe = buchRepo.findAllByOrderByPreisAsc();
		return buchListe;
	}

}
