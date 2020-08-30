package com.training.cdac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class School
{
	int studentSize;
	int teachersSize;
	int schoolrevenue;
	int schoolexpense;
	
	School(int size,int tsize)
	{
		studentSize=size;
		teachersSize=tsize;
	}
	static Students[] s;
	
	
	Teachers[] t;
	//System.out.println(studentSize);
	public void addStudents(String sname,int id,int grade,int feepaid,int totalfees)
	{
		//System.out.println(this.studentSize);
		s=new Students[studentSize];
		for(int i=0;i<studentSize;i++)
		{
			
			s[i]=new Students(sname,  id,  grade,  feepaid, totalfees);
		
		}
	}
	
	public Students[] getAllStudents()
	{
		return s;
	}
	
	public void addTeachers(String tname,int id,int salary)
	{
		t=new Teachers[teachersSize];
		
		for(int i=0;i<teachersSize;i++)
		{
			t[i]=new Teachers(tname,  id,  salary);
		}
	}
	
	
	
	public Teachers[] getAllTeachers()
	{
		return t;
	}
	
	public void totalRevenvue()
	{
		for(int i=0;i<studentSize;i++)
		{
			schoolrevenue+=s[i].feePaid();
		}
		System.out.println(schoolrevenue);
		
	}
	
	
	public void totalExpense()
	{
		for(int i=0;i<teachersSize;i++)
		{
			schoolexpense+=t[i].salaryPaid();
		}
		System.out.println(schoolexpense);
		
	}
	
	
	
	
}
class Teachers
{
	public String tname;
	public int id;
	public int salary;
	
	Teachers(String tname,int id,int salary)
	{
		this.tname=tname;
		this.id=id;
		this.salary=salary;
	}
	
	Teachers()
	{
		
	}
	public int salaryPaid()
	{
		return salary;
	}
	
}
class Students
{
	public String sname;
	public int id;
	public int grade;
	public int feepaid;
	//private int totalfees;
	public int totalfees;
	
	Students(String sname,int id,int grade,int feepaid,int totalfees)
	{
		this.sname=sname;
		this.id=id;
		this.grade=grade;
		this.feepaid=feepaid;
		this.totalfees=totalfees;
	}
	Students()
	{
		
	}

	public int  feePaid()
	{
		return feepaid;
	}
	
}
public class SchoolManagement {

	static School s;
	static int ss,tt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int choice;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.println("School Management");
			System.out.println("If you wana add Students Press 1");
			System.out.println("If you wana add Teachers Press 2");
			System.out.println("If you wana get all Students Press 3");
			System.out.println("If you wana get All Teachers Press 4");
			System.out.println("If you wana get Revenue of school press 5");
			System.out.println("If you wana get Expense of schoool press 6");
			choice =Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			
			case 1:
				System.out.println("If you wana add only students press the number of students you wana add and also and zero");
				ss=Integer.parseInt(br.readLine());
				
				tt=Integer.parseInt(br.readLine());
				System.out.println(ss+""+ tt);
				SchoolManagement.s=new School(ss,tt);
				do
				{	
				System.out.println("Enter name of student");
				String name=br.readLine();
				System.out.println("Enter id");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter grade");
				int  grade=Integer.parseInt(br.readLine());
				System.out.println("Enter feespaid");
				int feespaid=Integer.parseInt(br.readLine());
				System.out.println("Enter total fees");
				int totalFees=Integer.parseInt(br.readLine());
				
				s.addStudents(name, id, grade, feespaid, totalFees);
				ss=ss-1;
				
				}while(ss>0);
				
				
				break;
			case 2:
				
				
				System.out.println("If you wana add only Teachers press the number of Teachers you wana add and also and zero");
				ss=Integer.parseInt(br.readLine());
				tt=Integer.parseInt(br.readLine());
				s=new School(ss,tt);
				do
				{	
				System.out.println("Enter name of Teacher");
				String name=br.readLine();
				System.out.println("Enter id");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter salary");
				int  salary=Integer.parseInt(br.readLine());
				
				s.addTeachers(name, id, salary);
				
				
				}while(tt>=0);
				
				break;
				
			case 3:
				Students[]st=s.getAllStudents();
				//System.out.println(st);
				
				for(int i=0;i<st.length;i++)
				{
					System.out.println(st[i].id+" "+st[i].sname+" "+st[i].grade+" "+st[i].feepaid+" "+st[i].totalfees);
				}
				
				
				
				break;
			case 4:
				Teachers[]ts=s.getAllTeachers();
				
				for(int i=0;i<ts.length;i++)
				{
					System.out.println(ts[i].id+" "+ts[i].tname+" "+ts[i].salary);
				}
				
				
				
				
				break;
				
			case 5:
				s.totalRevenvue();
				
				break;
			case 6:
				s.totalExpense();
	
				break;
			case 7:
				
				System.out.println("Invalid Choice");
				break;
				
			
			}
			
			
			
			
		}while(choice<=6);
		
		
		

	}

}
