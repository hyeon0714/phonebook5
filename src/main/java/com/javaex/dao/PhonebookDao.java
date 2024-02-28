package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 삭제
	public int personDelete(int no) {
		System.out.println("personDelete");
		
		sqlSession.delete("phonebook.delete", no);
		
		return 0;
	}
	
	// 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("personUpdate");
		
		int count = sqlSession.update("phonebook.update", personVo);
		
		return count;
	}
	
	
	// 1개 가져오기
	public PersonVo personSelectOne(int no) {
		System.out.println("personSelectOne");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		
		return personVo;
	}
	
	// 전체가져오기
	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		System.out.println(personList);
		return personList;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		
		int count = sqlSession.insert("phonebook.insert", personVo);
		
		System.out.println(count);
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Autowired
	private DataSource dataSource;
	
	// 생성자
	// 메소드-gs
	// 메소드-일반
	// 연결
	public void getConnection() {
		try {

			// 2. Connection 얻어오기
			conn = dataSource.getConnection();

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}
	}

	// 종료
	public void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	*/
	/*
	// 등록
	public int personInsert(PersonVo personVo) {
		int count = -1;

		this.getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " insert into person ";
			query += " values(null, ?, ?, ?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();

		return count;
	}
	*/
	/*
	// 삭제
	public int personDelete(int no) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " delete from person ";
			query += " where person_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}
	*/
	/*
	// 1개 가져오기
	public PersonVo personSelectOne(int no) {

		this.getConnection();

		PersonVo personVo = null;

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select person_id, ";
			query += "	      name, ";
			query += "        hp, ";
			query += "	      company ";
			query += " from person ";
			query += " where person_id=? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {// 반복
				int personId = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				// db에서 가져온 데이터 vo로 묶기
				personVo = new PersonVo(personId, name, hp, company);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return personVo;
	}
	*/
	
	/*
	// 수정
	public int personUpdate(PersonVo personVo) {
		int count = -1;

		this.getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " update person ";
			query += " set name=?, ";
			query += " 	   hp=?, ";
			query += "     company=? ";
			query += " where person_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());
			
			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		this.close();

		return count;
	}
	*/
}