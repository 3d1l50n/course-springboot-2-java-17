package br.com.teradynebrasil.securityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.securityapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
