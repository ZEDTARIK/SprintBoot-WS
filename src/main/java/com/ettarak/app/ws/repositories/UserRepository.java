package com.ettarak.app.ws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ettarak.app.ws.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
