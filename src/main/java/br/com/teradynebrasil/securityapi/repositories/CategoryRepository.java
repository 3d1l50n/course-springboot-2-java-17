package br.com.teradynebrasil.securityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.securityapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
