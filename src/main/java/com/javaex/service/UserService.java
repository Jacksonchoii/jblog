package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	
	//회원가입 -- 자동으로 블로그 생성
	public int join(UserVo userVo) {
		System.out.println("[UserService : join()]");
	
		userVo.setBlogTitle(userVo.getUserName() + "의 블로그입니다.");
		userVo.setLogoFile("/assets/images/spring-logo.jpg");
		
		//user 회원가입
		int count = userDao.insert(userVo);
		
		//blog 생성
		userDao.insertBlog(userVo);
		
		return count;
	}
	
	//아이디 중복체크
	public String idcheck(String id) {
		System.out.println("[UserService : idcheck()]" + id);
	
		UserVo userVo = userDao.selectOne(id);
		
		String result = "";
		
		if(userVo == null) {
			result = "can";
		} else {
			result = "cant";
		}
		
		return result;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[UserService : login()]");
		
		return userDao.selectUser(userVo);
	}
	
}
