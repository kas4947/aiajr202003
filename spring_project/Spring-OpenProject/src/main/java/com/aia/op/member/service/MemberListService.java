package com.aia.op.member.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import com.aia.op.member.dao.JdbcTemplateMemberDao;
import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberListView;

@Service
public class MemberListService {

//	@Autowired
//	MemberDao dao;

//	@Inject
//	JdbcTemplateMemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public MemberListView getView(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		dao = template.getMapper(MemberDaoInterface.class);
		
		//검색 데이터 : search type, keyword
		String searchType = request.getParameter("searchType");
			if(searchType == null || searchType.isEmpty()){
				searchType = null;
			}
		String keyword = request.getParameter("keyword");
			if(keyword == null || keyword.isEmpty()){
				keyword = null;
			}
		
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("searchType", searchType);
		search.put("keyword", keyword);
		
		// view 로 전달할 결과 데이터
		MemberListView listView = null;

		// 전체 게시물 개수 구하기
		int totalCnt = dao.totalCount(search);
		// 한 페이지 당 노출할 게시물의 개수
		final int MEMBER_CNT_PER_PAGE = 2;

		// 현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		if (page != null && page.length() > 0) {
			currentPageNumber = Integer.parseInt(page);
		}
		
		

		// 게시물의 첫번째 행의 index
		int startRow = 0;

		// 한 페이지에 누출할 리스트
		List<Member> memberList = null;

		if (totalCnt > 0) {
			startRow = (currentPageNumber - 1) * MEMBER_CNT_PER_PAGE;

			System.out.println(startRow);
			
			search.put("startRow", startRow);
			search.put("count", MEMBER_CNT_PER_PAGE);

			memberList = dao.selectList(search);
		} else {
			currentPageNumber = 0;
			memberList = Collections.emptyList();
		}

		listView = new MemberListView(totalCnt, currentPageNumber, memberList, MEMBER_CNT_PER_PAGE, startRow);
		
		request.setAttribute("search", search);
		System.out.println(listView);

		return listView;
	}

}
