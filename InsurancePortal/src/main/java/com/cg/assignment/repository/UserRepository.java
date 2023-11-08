package com.cg.assignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.assignment.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
