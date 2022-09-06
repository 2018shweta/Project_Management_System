package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthTokenFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = ((HttpServletRequest) (req));

		String url = request.getRequestURL().toString();

		System.out.println("incoming url ---> " + url);
		

		if (url.contains("/public_api/")|| request.getMethod().toLowerCase().equals("options")) {
			System.out.println("authtoken filter");// goahed
			chain.doFilter(req, res);
		} else {
			
//			String authToken = request.getHeader("authToken private");
//			System.out.println("authToken => " + authToken);
//			if (authToken == null || authToken.trim().length() != 16) {
//
//				System.out.println("token verification failed.......");
//				HttpServletResponse response = ((HttpServletResponse) res);
//				response.setContentType("application/json");
//				response.setStatus(401);
//				response.getWriter().write("{'msg':'Please Login before access service'}");
//			} else {
//				
				System.out.println("user verfied....");
				chain.doFilter(req, res);// go ahead -> { Filter , Controller }
//			}

		}
		
	} 
	
	
	
	
}//main
