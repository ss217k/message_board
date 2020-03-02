package com.board.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.User;
import com.board.service.impl.MessageService;
import com.board.service.impl.MessageServiceImpl;

/**
 * Servlet implementation class AddEditMessageServlet
 */
@WebServlet("/AddEditMessageServlet")
public class AddEditMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEditMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		if("update".equals(methodName)) {
			change(request,response);
		}else if("add".equals(methodName)) {
			add(request,response);
		}else if("delete".equals(methodName)) {
			delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		MessageService messageService=new MessageServiceImpl();
		messageService.delete(id);
		response.sendRedirect("/message_board/MessageServlet?method=findOne");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		User user=(User)request.getSession().getAttribute("existUser");
		Integer user_id=user.getId();
		String username=user.getUsername();
		MessageService messageService=new MessageServiceImpl();
		messageService.add(user_id,username,title,content);
		response.sendRedirect("/message_board/MessageServlet?method=findAll");
	}

	private void change(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		MessageService messageService=new MessageServiceImpl();
		messageService.change(id,title,content);
		response.sendRedirect("/message_board/MessageServlet?method=findOne");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
