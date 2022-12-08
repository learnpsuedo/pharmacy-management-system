package com.user.UserService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.UserService.model.User;


@Repository
public interface UserRepository extends MongoRepository<User,Integer>
{
   public User findAllByMobileNumber(Long mobileNumber);
   public User findByFullName(String fullName);
}

