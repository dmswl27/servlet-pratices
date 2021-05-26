<%@page import="com.douzone.emaillist.dao.EmaillistDao"%>
<%@page import="com.douzone.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String first_name = request.getParameter("fn");
	String last_name = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirst_name(first_name);
	vo.setLast_name(last_name);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);
	
	response.sendRedirect(request.getContextPath());
%>