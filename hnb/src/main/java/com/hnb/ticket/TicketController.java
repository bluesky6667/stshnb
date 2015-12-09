package com.hnb.ticket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	@Autowired
	TicketServiceImpl ticketService;
	@Autowired
	TicketVO ticket;
	
	@RequestMapping("/Ticket")
	public String ticketMain(){
		logger.info("TicketController-ticketMain() 진입");
		return "ticket/Ticket";
	}
	
	@RequestMapping("/movieSelect")
	public Model movieSelect(
			String movie,
			String theater,
			String date,
			Model model
			){
		logger.info("TicketController-movieSelect() 진입");
		List theaterList = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		if (theater==null && date!=null) {
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (theater!=null && date==null) {
			dateList = ticketService.getShowDateListByMT(movie,theater);
		} else if (theater==null && date==null) {
			theaterList = ticketService.getTheaterListByM(movie);
			dateList = ticketService.getShowDateListByM(movie);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}
		model.addAttribute("theaterList",theaterList);
		model.addAttribute("dateList",dateList);
		model.addAttribute("timeList",timeList);
		return model;
	}
	@RequestMapping("/theaterSelect")
	public Model theaterSelect(
			String movie,
			String theater,
			String date,
			Model model
			){
		logger.info("TicketController-theaterSelect() 진입");
		List movieListRate = new ArrayList();
		List movieListAsc = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		if (movie==null && date!=null) {
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			dateList = ticketService.getShowDateListByMT(movie, theater);
		} else if (movie==null && date==null) {
			movieListRate = ticketService.getMovieRateByT(theater);
			movieListAsc = ticketService.getMovieAscByT(theater);
			dateList = ticketService.getShowDateListByT(theater);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}
		model.addAttribute("movieListRate", movieListRate);
		model.addAttribute("movieListAsc", movieListAsc);
		model.addAttribute("dateList", dateList);
		model.addAttribute("timeList", timeList);
		return model;
	}
	@RequestMapping("/dateSelect")
	public Model dateSelect(
			String movie,
			String theater,
			String date,
			Model model
			){
		logger.info("TicketController-dateSelect() 진입");
		List movieListRate = new ArrayList();
		List movieListAsc = new ArrayList();
		List theaterList = new ArrayList();
		List timeList = new ArrayList();
		if (movie==null && theater!=null) {
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			movieListRate = ticketService.getMovieRateByD(date);
			movieListAsc = ticketService.getMovieAscByD(date);
			theaterList = ticketService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}
		model.addAttribute("movieListRate", movieListRate);
		model.addAttribute("movieListAsc", movieListAsc);
		model.addAttribute("theaterList", theaterList);
		model.addAttribute("timeList", timeList);
		return model;
	}
	@RequestMapping("/choiceseat")
	public Model choiceseat(
			String movie,
			String theater,
			String date,
			String time,
			Model model
			){
		logger.info("TicketController-choiceseat() 진입");
		String filmNumber = ticketService.getFilmNumberBy(movie);
		logger.info("영화번호 : {}", filmNumber);
		ticket.setFilmNumber(filmNumber);
		ticket.setTheaterName(theater);
		ticket.setTheaterName(date);
		ticket.setTheaterName(time.split(" ")[0]);
		ticket.setTheaterName(time.split(" ")[1]);
		logger.info("영화번호 : {}", ticket.getFilmNumber());
		logger.info("영화관 : {}", ticket.getTheaterName());
		logger.info("날짜 : {}", ticket.getDate());
		logger.info("관번호 : {}", ticket.getRoomName());
		logger.info("시작시간 : {}", ticket.getStartTime());
		model.addAttribute("result", "success");
		return model;
	}
	
	@RequestMapping("/initList")
	public Model initList(Model model){
		logger.info("TicketController-initList() 진입");
		List movieListRate = ticketService.getRateList();
		List movieListAsc = ticketService.getAscList();
		List theaterList = ticketService.getTheaterList();
		List dateList = ticketService.getShowDateList();
		model.addAttribute("movieListRate", movieListRate);
		model.addAttribute("movieListAsc", movieListAsc);
		model.addAttribute("theaterList", theaterList);
		model.addAttribute("dateList", dateList);
		logger.info("initList : {}",model);
		return model;
	}
	@RequestMapping("/Seats")
	public Model seatsMain(Model model){
		logger.info("TicketController-seatsMain() 진입");
		model.addAttribute("movie", ticket.getFilmNumber());
		model.addAttribute("date", ticket.getDate());
		model.addAttribute("time", ticket.getStartTime());
		return model;
	}
	@RequestMapping("/initSeats")
	public Model initSeats(Model model){
		logger.info("TicketController-initSeats() 진입");
		model.addAttribute("seatList", ticketService.getSeatList(ticket.getTheaterName(),ticket.getRoomName()));
		return model;
	}
	@RequestMapping("/infoSave")
	public Model infoSave(
			String adult,
			String old_man,
			String teenager,
			String price,
			String seat_number,
			Model model
			){
		logger.info("TicketController-infoSave() 진입");
		ticket.setAdult(Integer.parseInt(adult));
		ticket.setOldMan(Integer.parseInt(old_man));
		ticket.setTeenager(Integer.parseInt(teenager));
		ticket.setPrice(Integer.parseInt(price));
		ticket.setSeatNumber(seat_number);
		model.addAttribute("result", "success");
		return model;
	}
	@RequestMapping("/Confirm")
	public Model confirmMain(Model model){
		logger.info("TicketController-confirmMain() 진입");
		model.addAttribute("movie", ticket.getFilmNumber());
		model.addAttribute("ticket", ticket);
		return model;
	}
}
