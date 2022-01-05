package br.com.teradynebrasil.securityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teradynebrasil.securityapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
