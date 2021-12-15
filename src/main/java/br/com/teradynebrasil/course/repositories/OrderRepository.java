package br.com.teradynebrasil.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
