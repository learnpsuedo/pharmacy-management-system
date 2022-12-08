package com.user.UserService.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.user.UserService.model.User;

@Service
public interface UserService
{
	
	public User addNewDoctorUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getByUserId(int userId);
	public User updateUser(User user);
	public void deleteUser(int userId);
	public User addNewAdminUser(User user);
	public User addNewDelivaryUser(User user);
	public User findAllByMobileNo(Long mobileNumber);
	public User getByUserName(String fullName);
	
}


