package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 회원가입
	public int insert(UserVo userVo) {
		System.out.println("[UserDao : insert()]");

		return sqlSession.insert("user.insert", userVo);
	}

	// 블로그 생성
	public int insertBlog(UserVo userVo) {
		System.out.println("[UserDao : insertBlog()]");

		return sqlSession.insert("user.insertBlog", userVo);
	}

	// 아이디 중복체크
	public UserVo selectOne(String id) {
		System.out.println("[UserDao : selectOne()]");

		return sqlSession.selectOne("user.selectOne", id);
	}

	// 로그인
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao : selectUser()]");

		return sqlSession.selectOne("user.selectUser", userVo);
	}
}
