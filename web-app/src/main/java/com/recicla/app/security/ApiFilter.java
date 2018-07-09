package com.recicla.app.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.recicla.app.service.LoguinService;

@Component
public class ApiFilter implements Filter{
	
	private static final String URL_LOGUIN="/oauth/token";
	private static final String URL_STATIC="/";
	
	@Autowired
	private LoguinService loguinService;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String url=request.getRequestURI().toString();
		if(url.equalsIgnoreCase(URL_LOGUIN)) {
			
		}else if(url.equalsIgnoreCase(URL_STATIC)){
			
		}else {
			try {
			String tokeAutorizacion=request.getHeader("Autorization");
			tokeAutorizacion=loguinService.verificar(tokeAutorizacion);
			response.setHeader("Autorization", tokeAutorizacion);
			}catch (SecurityException e) {
				throw e;
			}catch (Exception e) {
				throw new SecurityException(e.getMessage());
			}
		}
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader(
				"Access-Control-Allow-Headers","Origin,Accept,X-Requested-With,"
			  + "Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,"
			  + "Authorization");
		
        chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
