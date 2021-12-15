package br.com.teradynebrasil.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
