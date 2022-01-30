package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;


public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	DBUtils dbUtils = DBUtils.getInstance();
	
	
	//AL will hold 10 elements of type subscription
	private ArrayList<Subscription> arrayList = new ArrayList<>();
//	private Subscription[] subscriptions = new Subscription[10];
//	private static int count = -1;
	
    private SubscriptionRepositoryImpl() throws IOException {
		
	}
	
    
    //singleton instance
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() throws IOException{
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		
		return subscriptionRepository;
	
	}
	
    
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
//		boolean result = this.arrayList.add(subscription);
//		if(result)
//		{
//			return "successfully added subscription";
//		}
//		else
//		{
//			return "failed to add subscription";
//		}
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertStatement = "Insert into Subscription "+"(subscriptionId,dateOfPurchase,expiry,amount,paymentMode,status,type, autoRenewal)"+"values(?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1,subscription.getId());
			preparedStatement.setString(2,subscription.getDateOfPurchase());
			preparedStatement.setString(3,subscription.getExpiryDate());
			preparedStatement.setInt(4,subscription.getSubscriptionAmount());
			preparedStatement.setString(5,subscription.getPaymentMode());
			preparedStatement.setString(6,subscription.getStatus());
			preparedStatement.setString(7,subscription.getType());
			preparedStatement.setString(8,subscription.getAutoRenewal());
			
			
			
			int result =preparedStatement.executeUpdate();
			
			if(result>0) 
			{
					connection.commit();
					return "Success!";
			}
			else
				{
					connection.rollback();
					return "Fail";
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
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
//		Optional<Subscription> optional = this.getSubscriptionById(id);
//		
//		if(optional.isPresent())
//		{
//			boolean result = arrayList.remove(optional.get());
//			if(result)
//			{
//				return "subscription successfully deleted";
//			}
//			else
//			{
//				return "subscription failed to delete";
//			}
//		}
//
//		return "fail";
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from subscription where subscriptionId=?";
	
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
					
			int result =preparedStatement.executeUpdate();
		
			if(result>0) {
				connection.commit();
				return "Subscription record deleted"	;
			}
			else {
				connection.rollback();
				return "fail to delete subscription";
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
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
//		String result = this.deleteSubscription(id);
//		if(result=="Failed")
//			return "Failed to delete subscription";
//		result = this.addSubscription(subscription);
//		if(result=="Fail")
//			return "Failed to Add Subscription";
//		return "Subscription Modified";
		

		Connection connection;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE subscription"+" SET subscriptionId= ? , dateOfPurchase = ? , expiry = ? , amount = ? , paymentMode = ? , status = ? , type = ? , autoRenewal = ? "+ "WHERE(subsciptionId=?)";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			
			preparedStatement.setString(1,subscription.getId());
			preparedStatement.setString(2,subscription.getDateOfPurchase());
			preparedStatement.setString(3,subscription.getExpiryDate());
			preparedStatement.setInt(4,subscription.getSubscriptionAmount());
			preparedStatement.setString(5,subscription.getPaymentMode());
			preparedStatement.setString(6,subscription.getStatus());
			preparedStatement.setString(7,subscription.getType());
			preparedStatement.setString(8,subscription.getAutoRenewal());
			
		
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

	
	/*
	 * Optional is a class which is specifically designed to handle null pointer exception
	 * if we are total confident about the object(will surely get object =) then use optional.of()
	 */
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
//		Subscription subscription2 = null;
//		for (Subscription subscription : arrayList) {
//			if(subscription.getId().equals(id))
//			{
//				//return Optional.of(subscription);
//				subscription2 = subscription;
//				break;
//			}
//		}
//		return Optional.ofNullable(Optional.of(subscription2).orElseThrow(()-> new IdNotFoundException("subscription id not found")));
//		/*Optional.ofNullable():
//		 * if subscription2 is holding null it will act like an empty()
//		 * if subscription2 is holding object it will act like of()
//		 */
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM subscription WHERE subscriptionId=?";
	
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subscriptionId"));
				subscription.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setSubscriptionAmount(resultSet.getInt("subscriptionAmount"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setType(resultSet.getString("type"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				return Optional.of(subscription);
				
			}
			
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
	public Subscription[] getAllSubscription() throws InvalidAmountException {
		// TODO Auto-generated method stub
//		Subscription subscription[] = new Subscription[arrayList.size()];
//		return arrayList.toArray(subscription);
		Optional<ArrayList<Subscription>> optional = getAllSubscriptionDetails();
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			ArrayList<Subscription> list=optional.get();
			Subscription[] subscription = new Subscription[list.size()];
			return list.toArray(subscription);
		}
	}
	
	@Override
	public Optional<ArrayList<Subscription>> getAllSubscriptionDetails() throws InvalidAmountException
	{
//		Collections.sort(arrayList);
//		return arrayList;
		
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		ArrayList<Subscription>  arrayList = new ArrayList<Subscription>();
		
		String selectStatement = "SELECT * FROM subscription ";
		
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet =  preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Subscription subscription = new Subscription();
				subscription.setId(resultSet.getString("subscriptionId"));
				subscription.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setSubscriptionAmount(resultSet.getInt("subscriptionAmount"));
				subscription.setPaymentMode(resultSet.getString("paymentMode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setType(resultSet.getString("type"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				arrayList.add(subscription);
				
				
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
	

}
