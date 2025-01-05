package com.anwar.Dto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.anwar.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
}
