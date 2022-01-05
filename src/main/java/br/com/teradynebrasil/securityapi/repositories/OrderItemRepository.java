package br.com.teradynebrasil.securityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.securityapi.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
