package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Repository
public class LoginRepositoryImpl implements LoginRepository{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private PasswordUtils passwordUtils;
	
	public LoginRepositoryImpl() throws IOException
	{
		
	}
//	DBUtils dbutils =DBUtils.getInstance();
//	private LoginRepositoryImpl() throws IOException {
//		
//	}
//	
//	static private LoginRepository loginRepository;
////	
////	
//////	private static LoginRepository repository;
//	public static LoginRepository getInstance() throws IOException {
//		if (loginRepository == null)
//			loginRepository = new LoginRepositoryImpl();
//		return loginRepository;
//	}

	@Override
	public String addCredentials(Login login) {
		Connection connection= null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement prepStatement;
		
		String insertStatement = "INSERT INTO login (username, password, regId, role)" + "values(?,?,?,?)";
		
		try {
			prepStatement = connection.prepareStatement(insertStatement);
			prepStatement.setString(1, login.getUserName());
			prepStatement.setString(2, login.getPassword());
			prepStatement.setString(3, login.getRegId());
			prepStatement.setString(4, login.getRole().toString());
			
			int result = prepStatement.executeUpdate();
			if (result > 0) {
				//connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String deleteStatement = "DELETE FROM login where username=?";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(deleteStatement);
			prepStatement.setString(1, userName);
			int result = prepStatement.executeUpdate();
			if (result > 0)
			{	connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		
		
	}


	@Override
	public String changeCredentials(String userName, String password) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE login SET password=? WHERE username=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userName);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
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
		
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE login SET role=? WHERE username=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, userName);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
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
		
	}
	
	
	@Override
	public String updateLoginCredentials(String regId, Login login)
	{
		Connection connection=null;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE login" + "SET username = ?, password=? , regId =? ,role=?" +"WHERE regId=?";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegId());
			preparedStatement.setString(4, login.getRole().toString());
			preparedStatement.setString(5, regId);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "success";
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
			return "Fail";
		}
	}
	
	
}
