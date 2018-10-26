package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.HowtocookVo;
import com.javaex.vo.IngreVo;
import com.javaex.vo.Std_info_Vo;


@Repository
public class UserDao {

	@Autowired
	SqlSession sqlsession;
	
	public List<Std_info_Vo> getAllList(){
		List<Std_info_Vo> allList = sqlsession.selectList("user.allList");	
		return allList;
	}

	
	public List<Std_info_Vo> searchedList(String searchKwd){
//		System.out.println(searchKwd.toString());
//		System.out.println(searchedList.toString());
		return sqlsession.selectList("user.searchedList", searchKwd);
	}
	
	//기본레시피정보 가져오기
	public Std_info_Vo readContent_std(String recipe_code) {
		Std_info_Vo readStdContent = sqlsession.selectOne("user.readContent_std", recipe_code);
		return readStdContent;
	}
	
	//요리순서 리스트
	public List<IngreVo> readIngre_info(String recipe_code){
		List<IngreVo> readIngreInfoContentList = sqlsession.selectList("user.readContent_ingre", recipe_code);
		return readIngreInfoContentList;
	}
	
	//재료리스트 가져오기
	public List<HowtocookVo> readContent_howToCook(String recipe_code){
		List<HowtocookVo> readHTCContentList  = sqlsession.selectList("user.readContent_howToCook", recipe_code);
		return readHTCContentList;
	}
	
	//메뉴 검색된 갯수
	public String searchedCount(String searchedcount) {
		System.out.println(searchedcount);
		return sqlsession.selectOne("user.searchedCount",searchedcount);
	}
	
	//메뉴 총 갯수
	public String totalCount(String totalCount) {
		System.out.println(totalCount.toString());
		return sqlsession.selectOne("user.allListCount", totalCount);
	}
	
	//랜덤 추천
	public  List<Std_info_Vo> recommandDao(String recommand) {
		List<Std_info_Vo> recommandList = sqlsession.selectList("recommandation.recommandFoodType", recommand);
//		System.out.println(recommandList.toString());
		
		
		return recommandList;
	}
	
	
	
	
}
