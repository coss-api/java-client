package coss.api.client;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * java-json.jar license.
 * 
 * Copyright (c) 2002 JSON.org
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 */


/**
 * 
 * This file contains examples for calling coss api.   
 * 
 */

public class Examples {
	
	/**
	 * Get account detail for a user. This is a Signed function.
	 */
	
	public static void getAccountDetails() {
		StringBuffer params = new StringBuffer("recvWindow=5000&timestamp=").append(System.currentTimeMillis());
		   String response = RequestHandler.makeRequestGET(false,Constants.getAccountDetailsURLL(),params.toString());
			System.out.println("response = " +  response);
		   

	}
	/**
	 * Get account balances for a use. This is a Signed function.
	 */
	public static void getAccountBalances() {
		StringBuffer params = new StringBuffer("recvWindow=5000&timestamp=").append(System.currentTimeMillis());
		 String response = RequestHandler.makeRequestGET(false,Constants.getAccountBalancesURL(), params.toString());
			System.out.println("response = " +  response);
		 
	}
	
	/**
	 * Get exchange information and trading rules etc.
	 * This is a public function.
	 */
	public static void getExchangeInfo() {
		String response =  RequestHandler.makeRequestGET(true,Constants.getExchangeInfoURL(), null);
		System.out.println("response = " +  response);
		
		
	}
	/**
	 * Get market summary for a specific symbol, e.g coss-eth.
	 * This is a public function.
	 */
	public static void getMarketSummaries() {

		String response =   
		RequestHandler.makeRequestGET(true,Constants.getMarketSummariesURL(), "symbol=coss-eth");
		System.out.println("response = " +  response);
		
	}
	
	/**
	 * Get market depth for a specific symbol, e.g. coss-eth
	 * This is a public function.
	 */
	public static void getMarketDepth() {
		String response =   
		RequestHandler.makeRequestGET(true,Constants.getMarketDepthURL(), "symbol=coss-eth");
		System.out.println("response = " +  response);
		
		
	}
	/**
	 * Get market price for a specific symbol, e.g. coss-eth
	 * This is a public function.
	 */
	public static void getMarketPrice() {
		String response = 
		RequestHandler.makeRequestGET(false,Constants.getMarketPriceURL(), "symbol=coss-eth");
		System.out.println("response = " +  response);
		
	}
	
	/**
	 * Create a new order.
	 * This is a signed function.
	 */
	public static void createNewOrder() {
		
		//provide your order values
		
		JSONObject json = new JSONObject();
		try {
			json.put("order_symbol", "coss-eth");
			json.put("order_side", "SELL");
			json.put("order_price", "0.000458000");
			json.put("order_size", "10");
			json.put("type", "limit");
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String response = 
				RequestHandler.makeRequestPOSTDELETE(false, Constants.POST, Constants.getOrderAddURL(), json);

		System.out.println("response = " +  response);
		
	}
	/**
	 * Cancel an open order.
	 * This is a signed function.
	 */
	public static void cancelOrder() {
		
		//provide your order_id and symbol
		
		JSONObject json = new JSONObject();
		try {
			//use your order_id
			json.put("order_id", "e2186036-b978-42c0-86d1-0749765xxxxx");
			//use your symbol
			json.put("order_symbol", "coss-eth");
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = RequestHandler.makeRequestPOSTDELETE(false, Constants.DELETE, Constants.getOrderCancelURL(), json);
		System.out.println("response = " +  response);

	}
	
	/**
	 * Get order details for a specific order.
	 * This is a signed function.
	 */
	
	public static void getOrderDetails() {
	
		JSONObject json = new JSONObject();
		try {
			json.put("order_id", "e2186036-b978-42c0-86d1-0749765xxxxx");
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String response =  RequestHandler.makeRequestPOSTDELETE(false, Constants.POST, Constants.getOrderDetailsURL(), json);
		System.out.println("response = " +  response);
	}
	
	/**
	 * Get open orders for a user.
	 * This is a signed function.
	 */
	
	public static void getOpenOrders() {
		
		JSONObject json = new JSONObject();
		try {
			json.put("limit", 50);
			json.put("symbol", "coss-eth");
			json.put("page", 0);
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String response =  RequestHandler.makeRequestPOSTDELETE(false, Constants.POST, Constants.getOpenOrdersURL(), json);
		System.out.println("response = " +  response);
		
	}
	
	/**
	 * Get all orders for a user.
	 * This is a signed function.
	 */
	
	public static void getAllOrders() {
		JSONObject json = new JSONObject();
		try {
			json.put("limit", 50);
			json.put("symbol", "coss-eth");
			json.put("page", 0);
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String response =  RequestHandler.makeRequestPOSTDELETE(false, Constants.POST, Constants.getAllOrdersURL(), json);
		System.out.println("response = " +  response);
		
	}
	/**
	 * Get completed orders for a user.
	 * This is a signed function.
	 */
	public static void getCompletedOrders() {
		
		JSONObject json = new JSONObject();
		try {
			json.put("limit", 50);
			json.put("symbol", "coss-eth");
			json.put("page", 0);
			json.put("timestamp", System.currentTimeMillis());
			json.put("recvWindow", 5000);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String response =  RequestHandler.makeRequestPOSTDELETE(false, Constants.POST, Constants.getCompletedOrdersURL(), json);
		System.out.println("response = " +  response);

	
	}
	
	public static void main(String[] args) {
		
		//getAccountDetails();
		//getAccountBalances();
		//getExchangeInfo();
		//getMarketSummaries();
		//getMarketDepth();
		//getMarketPrice();
		//createNewOrder();
		//cancelOrder();
		//getOrderDetails();
		//getOpenOrders();
		//getAllOrders();
		//getCompletedOrders();
	}

}
