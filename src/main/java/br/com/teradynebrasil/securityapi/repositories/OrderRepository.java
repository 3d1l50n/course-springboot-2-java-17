package br.com.teradynebrasil.securityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.securityapi.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
