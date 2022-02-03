package com.zee.zee5app.service.impl;

import javax.transaction.Transactional;

//mport org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2 = roleRepository.save(role);
		if(role2 != null)
		{
			return "success";
		}
		return "fail";
	}

	@Override
	public void deleterRole(int roleId) {
		// TODO Auto-generated method stub
		
	}

}
