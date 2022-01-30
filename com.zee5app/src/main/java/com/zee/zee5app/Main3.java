package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.utils.PasswordUtils;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String myPassword = "myPassword123";
//
//		// Generate Salt. The generated value can be stored in DB.
//		String salt = PasswordUtils.getSalt(30);
//
//		// Protect user's password. The generated value can be stored in DB.
//		String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
//
//		// Print out protected password
//		System.out.println("My secure password = " + mySecurePassword);
//		System.out.println("Salt value = " + salt);

//		UserService service;
//		try
//		{
//			service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getllUserDetails();
//			
//			if(optional.isEmpty())
//			{
//				System.out.println("there is no records");
//			}
//			else
//			{
//				optional.get().forEach(e->System.out.println(e));
//			}
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}

		try {
		Register register = new Register("error16f", "abhisssvjs", "chigvyyhvate", "errfu8234@gmail.com", "12345678", null);
		
		register.setContactNumber(new BigDecimal("9975111164"));
		
		UserService service = UserServiceImpl.getInstance();
		
		String result = service.addUser(register);
		System.out.println(result);
		
	} catch (InvalidIdLengthException | InvalidNameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidEmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidPasswordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<Register> register = service.getUserById("ab000001");
//			System.out.println(register.get());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
