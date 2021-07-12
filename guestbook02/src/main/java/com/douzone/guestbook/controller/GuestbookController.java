package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;



public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("a");
		
		if("deleteform".equals(action)) {
			// 3. view로 포워딩
			System.out.println("gd");
		 	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
		 	rd.forward(request, response);
		 	
		 	
		
		}else if("add".equals(action)) {
			String name = request.getParameter("name");
			String passward = request.getParameter("password");
			String message = request.getParameter("message");

			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassward(passward);
			vo.setMessage(message);
			
			new GuestbookDao().insert(vo);
			
			response.sendRedirect(request.getContextPath() + "/gb");
			
		} else if("delete".equals(action)) {
			
			Long no = Long.parseLong(request.getParameter("no")); 
			String passward = request.getParameter("password");
			System.out.println(no + "  "+ passward );
			
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(no);
			vo.setPassward(passward);
			
			new GuestbookDao().delete(vo);
			
			response.sendRedirect(request.getContextPath() + "/gb");
			
		} else {
			/* default request(action) */
			// 1.요청 처리
			System.out.println("ddd");
		 	List<GuestbookVo> list = new GuestbookDao().findAll();
		 	
		 	// 2. request범위에 데이터(객체) 저장
		 	request.setAttribute("list", list);
		 	
		 	// 3. view로 포워딩
		 	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		 	rd.forward(request, response);
		}
			
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
