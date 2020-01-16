package com.example.jwtfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthFilter extends GenericFilterBean
{
	@Override
	public void doFilter(ServletRequest request,ServletResponse response,
			FilterChain chain) throws IOException,ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String header = req.getHeader("Authorization");
		if(header == null || !header.startsWith("Bearer")) {
			throw new ServletException("Missing or invalid authorization");
		}
		try {
			String token = header.substring(7);
			Claims claim = Jwts.parser().setSigningKey("userkey").
					parseClaimsJws(token).getBody();
			req.setAttribute("claims", claim);
		}
		catch(Exception e) {
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}
