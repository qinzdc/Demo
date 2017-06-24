package com.piggymetrics.auth.repository;

import com.piggymetrics.auth.domain.User;

public interface UserRepository  {

	User findOne(String username);

	void save(User user);

}
