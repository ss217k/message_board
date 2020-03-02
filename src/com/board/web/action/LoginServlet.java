package com.board.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.User;
import com.board.service.impl.UserService;
import com.board.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String code=(String)request.getSession().getAttribute("checkcode");
		String checkcode=request.getParameter("checkcode");
		if(checkcode==null||!checkcode.equalsIgnoreCase(code)) {
			request.setAttribute("info", "验证码输入不正确！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);;
			return;
		}
		UserService userService=new UserServiceImpl();
		User user=userService.getUser(username,password);
		if(user!=null) {
			//登录成功
			request.getSession().setAttribute("existUser", user);
			response.sendRedirect("/message_board/MessageServlet?method=findAll");
		}else {
			//登录失败
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
