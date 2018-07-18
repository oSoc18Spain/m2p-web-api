package com.m2p.web.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.m2p.web.api.models.entity.User;

public interface IUserDao extends CrudRepository<User, String>
{
	//@Query("select u.id, r.name from User u, role r where u.role_id=r.id")
	//public User findUserAndRole(int id);
}