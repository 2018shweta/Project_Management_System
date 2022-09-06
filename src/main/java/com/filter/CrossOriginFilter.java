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
public class CrossOriginFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("crossOrigin filter");
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		System.out.println("Origin -->"+request.getHeader("origin"));
		response.setHeader("Access-Control-Allw-Origin", request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Crdentials", "true");
		response.setHeader("Access-Control-Allow-Method", "POST,GET,PUT,DELETE,OPTIONS");
		response.setHeader("Access-Cotrol-Allow-Headers", "Content-Type,Accept,authToken");
		
		chain.doFilter(req, res);
	}
}
