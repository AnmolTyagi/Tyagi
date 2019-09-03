package com.Admin.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class Cust extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cust() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("act");
		HttpSession session=null; 
		if(action.equals("delete"))
		{
			session=request.getSession(false);
			CustomerPojo customerPojo=(CustomerPojo)session.getAttribute("customerPojo");
			customerSession.deleteCustomerPojo(customerPojo);
			System.out.println("after session  "+customerPojo);
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("act");
		HttpSession session=null;
		if(action.equals("Enter Details"))
		{
			String username=request.getParameter("Fname");
			System.out.println(username);
			String password=request.getParameter("password");
			CustomerPojo customerPojo=new CustomerPojo();			
			customerPojo.setPassword(password);
			customerPojo.setUsername(fname);
			System.out.println(customerPojo);
			CustomerService customerSession=new CustomerSession();
			CustomerPojo customerPojo2=new CustomerPojo();
			customerPojo2=customerSession.saveCustomerPojo(customerPojo);
			System.out.println(customerPojo2);
			if(customerPojo2!=null)
			{
				System.out.println(customerPojo2.getAccountno());
				
				request.setAttribute("accountno", customerPojo2.getAccountno());
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
				System.out.println("inside signup controller");	
			}
			else 
			{
				request.setAttribute("errormessage", "username not unique");
				RequestDispatcher rd=request.getRequestDispatcher("customerSignUp.jsp");
				rd.forward(request, response);
				System.out.println("username not unique");
			}
			
					
		}
		else if(action.equals("login"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			CustomerSession customerSession=new CustomerSession();
			CustomerPojo customerPojo=customerSession.authentiateCustomerPojo(username, password);
			if(customerPojo!=null)
			{
				session=request.getSession();
				session.setAttribute("customerPojo", customerPojo);
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
				System.out.println("inside login controller success");		
			}
			else
			{
				request.setAttribute("errormessage", "Invalid Name or Password");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				System.out.println("login  unsuccessful");		
			}
			
		}
		else if(action.equals("update") && (session=request.getSession(false))!=null)
		{
			String username=request.getParameter("username");
			String name=request.getParameter("name");
			String phoneno=request.getParameter("phoneno");
			session=request.getSession(false);
			CustomerPojo customerPojo=(CustomerPojo)session.getAttribute("customerPojo");
			System.out.println("after session in update "+customerPojo);
			customerPojo.setUsername(username);
			customerPojo.setName(name);
			customerPojo.setPhoneno(phoneno);
			CustomerService customerSession=new CustomerSession();
			CustomerPojo customerPojo2=customerSession.updateCustomerPojo(customerPojo);
			session.setAttribute("customerPojo", customerPojo2);
			
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			System.out.println("inside update controller ");		
			
		}
		
	}

}
