package com.simple.basic.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;
import com.simple.basic.command.UsersVO;

//Mapper 어노테이션 필수필수~! 
//스프링 부트에서는 매퍼 인터페이스 꼭 붙이세요
@Mapper 
public interface TestMapper {
   
   public String getTime();
   //N:1조인의 모형 글 - 회원정보
   public List<MemoVO> joinOne();
   //1:N조인의 모형 회원정보 - 글
   //아래처럼 가져와야 에러해결 but N:1조인의 모형이 됨
   //public List<UsersVO> joinTwo();
   public UsersVO joinTwo();
   
   
   
}