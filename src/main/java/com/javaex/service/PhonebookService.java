package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	//필드
	@Autowired
	private PhonebookDao phonebookDao;
	//생성자
	//메소드 gs
	//메소디 일반
	
	//수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personUpdate(personVo);
		
		return count;
		
	}
	

	
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();
		
		return personList;
	}
	
	//등록
	public int exeWrite2(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//비지니스로직X
		//PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personInsert(personVo);
		
		return count;
	}
	
	//등록2
	public int exeWrite(String name, String hp, String company) {
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		Map<String, String> personMap = new HashMap<String, String>();
		
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		phonebookDao.personInsert2(personMap);
		
		return 0;
	}
	
	
	
	
	

	
	//수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(no);
		
		return personVo;
		
	}
	
	//수정폼2
	public Map<String, Object> exeModifyForm2(int no) {
		System.out.println("PhonebookService.exeModifyForm2()");
		
		Map<String, Object> pMap = phonebookDao.personSelectOne2(no);
		
		return pMap;
		
	}
	
	
	
	//삭제 
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personDelete(no);
		
		return count;
	}
	

	

	
}
