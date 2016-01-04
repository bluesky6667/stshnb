package com.hnb.schedule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.mapper.ScheduleMapper;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public List<?> getRateList() {
		logger.info("ScheduleServiceImpl : getRateList()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getRateList();
	}
	@Override
	public List<?> getAscList() {
		logger.info("ScheduleServiceImpl : getAscList()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getAscList();
	}
	@Override
	public List<?> getTheaterList() {
		logger.info("ScheduleServiceImpl : getTheaterList()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterList();
	}
	@Override
	public List<?> getShowDateList() {
		logger.info("ScheduleServiceImpl : getShowDateList()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateList();
	}
	@Override
	public List<?> getTheaterListByM(String movie) {
		logger.info("ScheduleServiceImpl : getTheaterListByM()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByM(movie);
	}
	@Override
	public List<?> getShowDateListByM(String movie) {
		logger.info("ScheduleServiceImpl : getShowDateListByM()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByM(movie);
	}
	@Override
	public List<?> getTheaterListByMD(String movie, String date) {
		logger.info("ScheduleServiceImpl : getTheaterListByMD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByMD(movie, date);
	}
	@Override
	public List<?> getShowDateListByMT(String movie, String theater) {
		logger.info("ScheduleServiceImpl : getShowDateListByMT()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByMT(movie, theater);
	}
	@Override
	public List<?> getMovieRateByTD(String theater, String date) {
		logger.info("ScheduleServiceImpl : getMovieRateByTD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByTD(theater, date);
	}
	@Override
	public List<?> getMovieAscByTD(String theater, String date) {
		logger.info("ScheduleServiceImpl : getMovieAscByTD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByTD(theater, date);
	}
	@Override
	public List<?> getMovieRateByT(String theater) {
		logger.info("ScheduleServiceImpl : getMovieRateByT()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByT(theater);
	}
	@Override
	public List<?> getMovieAscByT(String theater) {
		logger.info("ScheduleServiceImpl : getMovieAscByT()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByT(theater);
	}
	@Override
	public List<?> getShowDateListByT(String theater) {
		logger.info("ScheduleServiceImpl : getShowDateListByT()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByT(theater);
	}
	@Override
	public List<?> getMovieRateByD(String date) {
		logger.info("ScheduleServiceImpl : getMovieRateByD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByD(date);
	}
	@Override
	public List<?> getMovieAscByD(String date) {
		logger.info("ScheduleServiceImpl : getMovieAscByD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByD(date);
	}
	@Override
	public List<?> getTheaterListByD(String date) {
		logger.info("ScheduleServiceImpl : getTheaterListByD()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByD(date);
	}
	@Override
	public List<?> getTimeList(String movie, String theater, String date) {
		logger.info("ScheduleServiceImpl : getTimeList()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTimeList(movie, theater, date);
	}
	@Override
	public String getFilmNumberBy(String movie) {
		logger.info("ScheduleServiceImpl : getFilmNumberBy()");
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getFilmNumberBy(movie);
	}
}