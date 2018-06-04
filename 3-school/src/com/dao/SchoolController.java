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
			System.out.println("  1. �л�");
			System.out.println("  2. ����");
			System.out.println("  3. ������");
			System.out.println("  4. �����޴�");
			System.out.println("****************");
			System.out.print("  ��ȣ ���� : ");
			num = scan.nextInt();

			if (num == 4)
				break;

			System.out.print("�̸� �Է� : ");
			name = scan.next();

			switch (num) {
			case 1:
				System.out.print("�й� �Է� : ");
				value = scan.next();
				code = 1;
				break;

			case 2:
				System.out.print("���� �Է� : ");
				value = scan.next();
				code = 2;
				break;

			case 3:
				System.out.print("�μ� �Է� : ");
				value = scan.next();
				code = 3;
				break;
			}

			SchoolDTO schoolDTO = new SchoolDTO(name, value, code);				
			int su = schoolDAO.insertArticle(schoolDTO);
			System.out.println(su + "���� ���� ����������ϴ�.");
		} // while
	}
	
	public void output(SchoolDTO schoolDTO) {
		System.out.print("�̸�="+schoolDTO.getName()+"\t\t");
		
		if(schoolDTO.getCode()==1) 
			System.out.println("�й�=" + schoolDTO.getValue());
		else if(schoolDTO.getCode()==2) 
			System.out.println("����="+ schoolDTO.getValue());
		else if(schoolDTO.getCode()==3) 
			System.out.println("�μ�="+ schoolDTO.getValue());
	}

	public void select() {			
		String name = null;
		List<SchoolDTO> list = null;
		SchoolDTO schoolDTO = null;
		int num=0;
		
		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("  1. �̸� �˻�");
			System.out.println("  2. ��ü �˻�");
			System.out.println("  3. �����޴�");
			System.out.println("****************");
			System.out.print("  ��ȣ ���� : ");
			num = scan.nextInt();
			
			if(num == 3) break;
			
			switch (num) {
			case 1:
				System.out.print("�˻��� �̸� �Է� : ");
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
		
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		name = scan.next();	

		su = schoolDAO.deleteArticle(name); 		 // ���� - ������ ���ϵ�
		if(su >= 1) System.out.println("�����Ǿ����ϴ�.");
	}

	public void menu() {
		int num;

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("  ����");
			System.out.println("****************");
			System.out.println("  1. �Է�");
			System.out.println("  2. �˻�");
			System.out.println("  3. ����");
			System.out.println("  4. ����");
			System.out.println("****************");
			System.out.print("  ��ȣ ���� : ");
			num = scan.nextInt();

			if (num == 4) {
				System.out.println("���α׷��� �����մϴ�.");
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
