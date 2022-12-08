package com.user.UserService.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.UserService.model.User;
import com.user.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

	@Override
	public User addNewDoctorUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getByUserId(int userId) 
	{
		return Optional.empty();
	}

	@Override
	public User updateUser(User user) 
	{
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
	    userRepository.deleteById(userId);
	}

	@Override
	public User addNewAdminUser(User user)
	{
		return userRepository.save(user);
	}

	@Override
	public User addNewDelivaryUser(User user) 
	{
		return userRepository.save(user);
	}

	@Override
	public User findAllByMobileNo(Long mobileNumber) 
	{
	     return userRepository.findAllByMobileNumber(mobileNumber);
	}

	@Override
	public User getByUserName(String fullName)
	{
		return userRepository.findByFullName(fullName);
	}
}