package br.com.teradynebrasil.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
