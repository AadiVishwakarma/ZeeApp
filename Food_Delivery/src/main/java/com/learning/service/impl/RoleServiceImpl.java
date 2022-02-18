package com.learning.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.dto.Role;
import com.learning.repo.RoleRepository;
import com.learning.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2=roleRepository.save(role);
		if(role2 != null)
		{
			return "success";
		}
		return "fail";
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		
	}

}
