package com.care.service;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.care.transaction_dao.TicketDAO;

public class TicketResultServiceImpl implements TicketService{
	private TicketDAO dao;
	
	public TicketResultServiceImpl() {
		String configLocation = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		dao = ctx.getBean("dao",TicketDAO.class);
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub		
		model.addAttribute("result", dao.resultTicket());
	}

}
