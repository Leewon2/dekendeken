
package com.ssafy.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인 데이터는 어디에 들어있나요?
		// 세션에 들어있다.
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userInfo") != null) {
			// 로그인 데이터가 들어있따.
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/user/login");
		return false;
	}
}
