package com.board.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.Message;
import com.board.domain.PageBean;
import com.board.domain.User;
import com.board.service.impl.MessageService;
import com.board.service.impl.MessageServiceImpl;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName=request.getParameter("method");
		if("findAll".equals(methodName)) {
			findAll(request,response);
		}else if("findOne".equals(methodName)) {
			findOne(request,response);
		}else if("update".equals(methodName)) {
			update(request,response);
		}
		
	//	request.getRequestDispatcher("/admin/message_list.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		MessageService messageService=new MessageServiceImpl();
		Message message=messageService.findupdate(id);
		//System.out.println(message);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/edit_message.jsp").forward(request, response);
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=0;
		String currPage=request.getParameter("page");
		if(currPage==null) {
			page=1;
		}else {
			page=Integer.parseInt(currPage);
		}
		User user=(User)request.getSession().getAttribute("existUser");
		Integer user_id=user.getId();
		//System.out.println(user_id);
		MessageService messageService=new MessageServiceImpl();
		List<Message> messageList=messageService.findOne(user_id);
		PageBean<Message> pageBean=messageService.findByPage2(page,user_id);
		System.out.println(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("/admin/my_message_list.jsp").forward(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=0;
		String currPage=request.getParameter("page");
		if(currPage==null) {
			page=1;
		}else {
			page=Integer.parseInt(currPage);
		}
		MessageService messageService=new MessageServiceImpl();
		List<Message> messageList=messageService.findAll();
		request.setAttribute("messageList", messageList);
	
		PageBean<Message> pageBean=messageService.findByPage(page);
	
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin/message_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
