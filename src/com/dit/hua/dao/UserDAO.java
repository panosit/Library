package com.dit.hua.dao;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface UserDAO{
	void insertUser(User user);
	List<User> getUserByUsername(String username);
	void deleteUser(User user);
	void updateUser(User user);
	List<User> getUsers();
}