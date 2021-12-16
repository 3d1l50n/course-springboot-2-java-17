package br.com.teradynebrasil.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
