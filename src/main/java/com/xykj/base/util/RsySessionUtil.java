package com.xykj.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class RsySessionUtil {
	
	@Autowired
	private HttpServletRequest request;
	
	public RsySession getRsySession(){
		HttpSession httpSession = request.getSession();
		System.out.println(httpSession.getId());
//		System.out.println(httpSession);
//		if(httpSession == null ) {
//			return null;
//		}
		RsySession session = (RsySession) httpSession.getAttribute("session");
		System.out.println(session);
		return session;
	}
}
