package com.example.buch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuchRepository extends JpaRepository<Buch,Integer>{
	public List<Buch> findAllByOrderByPreisAsc();
}
