package com.sdze.school.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrossFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse resp = (HttpServletResponse) response;
		
		  HttpServletRequest req = (HttpServletRequest) request;
		  
		  resp.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		  resp.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT");
		  resp.setHeader("Access-Control-Max-Age","3600");
		  resp.setHeader("Access-control-Allow-Credentials", "true");
		  resp.setHeader("Access-control-Allow-Headers","x-requested-with, authorization,Content-Type,Authorization,credential,X-XSRF-TOKEN" );
		  
		  if("OPTION".equalsIgnoreCase(req.getMethod())) {
		  resp.setStatus(HttpServletResponse.SC_OK);
		  }else { 
			  chain.doFilter(request,response);
		  }
		 
		
	}
	
	public void destroy() {}

}
