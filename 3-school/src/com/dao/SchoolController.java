package com.dao;

import java.util.List;
import java.util.Scanner;

public class SchoolController {
	Scanner scan =  new Scanner(System.in);
	SchoolDAO schoolDAO = new SchoolDAO();
	
	public void insert() {
		String name = null;
		String value = null;
		int code = 0;
		int num = 0;

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("  1. 학생");
			System.out.println("  2. 교수");
			System.out.println("  3. 관리자");
			System.out.println("  4. 이전메뉴");
			System.out.println("****************");
			System.out.print("  번호 선택 : ");
			num = scan.nextInt();

			if (num == 4)
				break;

			System.out.print("이름 입력 : ");
			name = scan.next();

			switch (num) {
			case 1:
				System.out.print("학번 입력 : ");
				value = scan.next();
				code = 1;
				break;

			case 2:
				System.out.print("과목 입력 : ");
				value = scan.next();
				code = 2;
				break;

			case 3:
				System.out.print("부서 입력 : ");
				value = scan.next();
				code = 3;
				break;
			}

			SchoolDTO schoolDTO = new SchoolDTO(name, value, code);				
			int su = schoolDAO.insertArticle(schoolDTO);
			System.out.println(su + "개의 행이 만들어졌습니다.");
		} // while
	}
	
	public void output(SchoolDTO schoolDTO) {
		System.out.print("이름="+schoolDTO.getName()+"\t\t");
		
		if(schoolDTO.getCode()==1) 
			System.out.println("학번=" + schoolDTO.getValue());
		else if(schoolDTO.getCode()==2) 
			System.out.println("과목="+ schoolDTO.getValue());
		else if(schoolDTO.getCode()==3) 
			System.out.println("부서="+ schoolDTO.getValue());
	}

	public void select() {			
		String name = null;
		List<SchoolDTO> list = null;
		SchoolDTO schoolDTO = null;
		int num=0;
		
		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("  1. 이름 검색");
			System.out.println("  2. 전체 검색");
			System.out.println("  3. 이전메뉴");
			System.out.println("****************");
			System.out.print("  번호 선택 : ");
			num = scan.nextInt();
			
			if(num == 3) break;
			
			switch (num) {
			case 1:
				System.out.print("검색할 이름 입력 : ");
				name = scan.next();
				schoolDTO = schoolDAO.selectArticle(name);
				output(schoolDTO);
				break;

			case 2:
				list = schoolDAO.selectList();
				for(int i=0; i<list.size(); i++) {
					schoolDTO = list.get(i);
					output(schoolDTO);
				}
				break;
			}			
		} // while
	}

	public void delete() {		
		String name = null;	
		int su = 0;
		
		System.out.print("삭제를 원하는 이름 입력 : ");
		name = scan.next();	

		su = schoolDAO.deleteArticle(name); 		 // 실행 - 개수가 리턴됨
		if(su >= 1) System.out.println("삭제되었습니다.");
	}

	public void menu() {
		int num;

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("  관리");
			System.out.println("****************");
			System.out.println("  1. 입력");
			System.out.println("  2. 검색");
			System.out.println("  3. 삭제");
			System.out.println("  4. 종료");
			System.out.println("****************");
			System.out.print("  번호 선택 : ");
			num = scan.nextInt();

			if (num == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			switch (num) {
			case 1:
				insert();
				break;

			case 2:
				select();
				break;

			case 3:
				delete();
				break;
			}
		}
	}	
}
