package com.user.UserService.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.UserService.model.User;
import com.user.UserService.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	public UserController(@RequestBody UserService userService) {
	    super();
	    this.userService = userService;
	}

	public UserController() {
	    super();
	}
	@PostMapping("/add-doctor")
	public User addNewDoctorUser(@RequestBody User user)
	{
	    return userService.addNewDoctorUser(user);
	}
	@PostMapping("/add-admin")
	public User addNewAdminUser(@RequestBody User user)
	{
	    return userService.addNewAdminUser(user);
	}
	@PostMapping("/add-delivaryuser")
	public User addNewDelivaryUser(@RequestBody User user)
	{
	    return userService.addNewDelivaryUser(user);
	}
	@GetMapping("/getallusers")
	public List<User> getAllUsers()
	{
	    return  userService.getAllUsers();
	}
	@GetMapping("/getbyuserid/{userId}")
	public Optional<User> getByUserId(@PathVariable int id)
	{
	    return userService.getByUserId(id);
	}
	@GetMapping("/getbymobileno/{mobileNumber}")
	public User getByAllByMobileNo(@PathVariable Long mobileNumber)
	{
	    return  userService.findAllByMobileNo(mobileNumber);
	}
	@PutMapping("/updateuser/{userId}")
	public User updateUser(@PathVariable int userId,@RequestBody User user)
	{
	    return  userService.updateUser(user);
	}
	@DeleteMapping("/deleteuser/{userId}")
	public void deleteUser(@PathVariable int userId)
	{
	     userService.deleteUser(userId);
	}
	@GetMapping("/getbyusername/{userName}")
	public User getByUserName(@PathVariable String userName)
	{
	    return  userService.getByUserName(userName);
	}

}


