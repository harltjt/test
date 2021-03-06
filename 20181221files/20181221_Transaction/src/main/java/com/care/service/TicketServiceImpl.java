package com.care.service;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.care.transaction_dao.TicketDAO;
import com.care.transaction_dto.TicketDTO;

public class TicketServiceImpl implements TicketService{
	private TicketDAO dao;
	
	public TicketServiceImpl() {
		String configLocation = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		dao = ctx.getBean("dao",TicketDAO.class);
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		TicketDTO ticketDTO = (TicketDTO) map.get("ticketDTO");
		int arr[] = new int[2];
		arr = dao.buyTicket(ticketDTO);
		model.addAttribute("arr", arr);
	}
}
