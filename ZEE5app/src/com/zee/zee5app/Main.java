package com.zee.zee5app;
import java.util.Iterator;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;





public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Register register = new Register();
        
        register.setFirstName("abhi");
        register.setLastName("chiv");
        register.setEmail("abhi@gmail.com");
        register.setPassword("abhi123");
        
        System.out.println(register);
        
        System.out.println(register.toString());
        
        System.out.println(register.getEmail());
        
        UserService service = UserService.getInstance();
        
        for(int i=1;i<=20;i++)
        {
        	Register register2 = new Register();
        	register2.setId("ab00"+i);
        	register2.setFirstName("abhi"+i);
        	register2.setLastName("chivate"+i);
        	register2.setPassword("abhi");
        	
        	String result = service.addUser(register2);
            System.out.println(result);
        }
        
        Register register2 = service.getUserById("ab1");
        System.out.println(register2 != null);
        
        for(Register register3: service.getUsers())
        {
        	if(register3!=null)
        		System.out.println(register3);
        }
        
	}

}
