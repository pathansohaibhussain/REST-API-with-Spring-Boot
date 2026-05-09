package com.app.UserManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.UserManagementApplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
