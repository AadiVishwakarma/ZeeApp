package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;


public class UserRepositoryImpl implements UserRepository {
	
	LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	DBUtils dbUtils = DBUtils.getInstance();
	
	private UserRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() throws IOException {
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		return repository;
	}

	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		// add the user details to the table.
		
		
		String insertStatement = "insert into register"
				+ " (regId,firstname,lastname,email,contactnumber,password)"
				+ " values(?,?,?,?,?,?)";
		// we will concatenate the values in values spec
		// we will use ? 
		// here we will provide the values against ? (placeholder)
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			// do we need to provide the values against ? placeholder?
			preparedStatement.setString(1,register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			String salt= PasswordUtils.getSalt(30);
			String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedPassword);
			
			int result =preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted
			// 
			
			if(result>0) 
			{
				Login login=new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				
				String res = loginRepository.addCredentials(login);
				if(res.equals("success"))
				{
					connection.commit();
					return "Success!";
				}
				else
				{
					connection.rollback();
					return "Fail";
				}
				
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			// closure work 
			// closing the connection
			dbUtils.closeConnection(connection);
		}
		
		
	}

	@Override
	public String updateUser(String id, Register register)throws IdNotFoundException{
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE register"+" SET regId=? , firstName=?, lastName=? , email=? , contactNumber=? , password=?"+ "WHERE(regId=?)";
		connection = dbUtils.getConnection();
		
		try {
		preparedStatement = connection.prepareStatement(updateStatement);
		preparedStatement.setString(1, register.getId());
		preparedStatement.setString(2, register.getFirstName());
		preparedStatement.setString(3, register.getLastName());
		preparedStatement.setString(4, register.getEmail());
		preparedStatement.setBigDecimal(5, register.getContactNumber());
		String salt = PasswordUtils.getSalt(30);
		String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(), salt);
		preparedStatement.setString(6, encryptedPassword);
		preparedStatement.setString(7, id);
		
		int result = preparedStatement.executeUpdate();
		if(result>0)
		{
			connection.commit();
			return "success";
		}
		else {
			connection.rollback();
			return "fail";
		}
		} catch(SQLException e)
		{
			e.printStackTrace();
			try {
			connection.rollback();
			}catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
//		ArrayList<Register> arrayList = new ArrayList<>();
		
		String selectStatement = "select * from register where regId=?";
		
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			if (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				//arrayList.add(register);
				return Optional.of(register);
				
			}
			return Optional.ofNullable(null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
		
	}

	@Override
	public Register[] getAllUsers() throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException{
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			List<Register> list=optional.get();
			Register[] registers=new Register[list.size()];
			return list.toArray(registers);
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException{
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Register> arrayList = new ArrayList<>();
		
		String selectStatement = "select * from register where regId=?";
		
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet =  preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				arrayList.add(register);
				
				
			}
			return Optional.ofNullable(null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
		
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		// add the user details to the table.
		
		
		String deleteStatement = "delete from register where regId=?";
		// we will concatenate the values in values spec
		// we will use ? 
		// here we will provide the values against ? (placeholder)
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			// do we need to provide the values against ? placeholder?
//			preparedStatement.setString(1,register.getId());
//			preparedStatement.setString(2, register.getFirstName());
//			preparedStatement.setString(3, register.getLastName());
//			preparedStatement.setString(4, register.getEmail());
//			preparedStatement.setBigDecimal(5, register.getContactNumber());
//			preparedStatement.setString(6, register.getPassword());
//			
			
			int result =preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted
			// 
			
			if(result>0) {
				connection.commit();
				return "record deleted"	;
			}
			else {
				connection.rollback();
				return "fail to delete";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			// closure work 
			// closing the connection
			dbUtils.closeConnection(connection);
		}
	}
}
