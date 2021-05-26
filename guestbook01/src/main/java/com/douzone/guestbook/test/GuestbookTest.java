package com.douzone.guestbook.test;

import java.util.Date;
import java.util.List;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;



public class GuestbookTest {

	public static void main(String[] args) {
		//insertTest();
		findAllTest();
		deleteTest();
	}

	private static void deleteTest() {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(2);
		
		new GuestbookDao().delete(vo);
	}

	private static void findAllTest() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		//Date time = new Date();
		GuestbookVo vo = new GuestbookVo();
		vo.setName("은지");
		vo.setPassward("****");
		vo.setMessage("hi~");
		
		
		new GuestbookDao().insert(vo);
		
	}


}
