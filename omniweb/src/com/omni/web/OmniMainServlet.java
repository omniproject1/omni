package com.omni.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omni.core.UserInfoBusiness;
import com.omni.data.vo.UserInfoVO;

public class OmniMainServlet extends HttpServlet {
	private static final long serialVersionUID = 4302056826373533040L;
	private String message;
	
	public void init() throws ServletException {
		// Do required initialization
		message = "Welcome to Omni Web Services";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");		
		String eMail = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipCode");
		String homePhone = request.getParameter("homePhone");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("passowrd");
		
		
		
		UserInfoVO user = new UserInfoVO();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setEmail(eMail);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZipCode(Integer.parseInt(zipcode));
		user.setHomePhone(Integer.parseInt(homePhone));
		user.setUserName(userName);
		user.setPassowrd(passWord);
		
		UserInfoBusiness userBuss = new UserInfoBusiness();
		String errors = userBuss.updateUserInfo(user);
		
		/*
		
		System.out.println(firstName);
		//String lastName = request.getParameter("lastname");
		System.out.println(lastName);
		//String eMail = request.getParameter("email");
		System.out.println(eMail);
		//String Address = request.getParameter("address");
		System.out.println(Address);
		//String City = request.getParameter("city");
		System.out.println(City);
		//String State = request.getParameter("state");
		System.out.println(State);
		//String Zipcode = request.getParameter("zipCode");
		System.out.println(Zipcode);
		//String HomePhone = request.getParameter("homePhone");
		System.out.println(HomePhone);
		//String userName = request.getParameter("username");
		System.out.println(userName);
		//String passWord = request.getParameter("passowrd");
		System.out.println(passWord);
		*/
		
		// Set response content type
		response.setContentType("text/html");
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		if (errors == null || errors.equalsIgnoreCase("1")) {
			out.println("<h1>Successfully Signed in</h1>");
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<h1>");
			buffer.append(errors);
			buffer.append("<h1>");
			out.println(buffer.toString());
		}
	}

	public void destroy() {
	      // do nothing.
	}
}
