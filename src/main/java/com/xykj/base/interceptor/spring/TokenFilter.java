package com.xykj.base.interceptor.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.xykj.base.commom.RsyResponse;
import com.xykj.base.entity.sys.account.Account;
import com.xykj.base.service.sys.account.AccountService;
import com.xykj.base.service.token.TokenManager;

public class TokenFilter implements Filter{
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private AccountService accountService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        accountService = ctx.getBean(AccountService.class);
        tokenManager = ctx.getBean(TokenManager.class);
		
		
//		System.out.println(httpServletRequest.getRequestURI());
		//如果 是 登录页面的请求,放行
        if (httpServletRequest.getRequestURI().equals("/ruisiyuan/backstage/attendance/upload")
        		|| httpServletRequest.getRequestURI().equals("/ruisiyuan/backstage/social/download")
        		|| httpServletRequest.getRequestURI().equals("/ruisiyuan/backstage/social/upload")
        		|| httpServletRequest.getRequestURI().equals("/ruisiyuan/backstage/classStudent/export")
        		|| httpServletRequest.getRequestURI().equals("/ruisiyuan/login.jsp")
        		|| httpServletRequest.getRequestURI().endsWith("js")) {
//			System.out.println(httpServletRequest.getRequestURI());
		} else if(httpServletRequest.getRequestURI().equals("/ruisiyuan/backstage/account/login")
	) {
			String accountName = httpServletRequest.getParameter("accountName");
			String password = httpServletRequest.getParameter("password");
			Account account = new Account();
			account.setPassword(password);
			account.setAccountName(accountName);
			Account checkAccount = accountService.findByNameAndPwd(account);
			String accountId = checkAccount.getAccountId();
			String tokenId = tokenManager.getToken(accountId);
			if(tokenId == null || tokenId.length() == 0) {
				tokenManager.createToken(accountId);
			}
		} else {
			String token = httpServletRequest.getParameter("token");
//			System.out.println("请求中的token : " + token);
			boolean flag = tokenManager.checkToken(token);
			if (!flag) {
				httpServletResponse.setCharacterEncoding("utf-8");
				httpServletResponse.setContentType("text/html;utf-8");
				httpServletResponse.getWriter().write(JSON.toJSONString(RsyResponse.error("token校验未通过", null)));
				return ;
			}
		}
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	@Override
	public void destroy() {
		
	}
	
}
