package com.example.manager.repository;

import com.example.manager.entity.EnterpriseUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EnterpriseUserRepository extends CrudRepository<EnterpriseUser, Integer> {

    Optional<EnterpriseUser> findByUsername(String username);
}
