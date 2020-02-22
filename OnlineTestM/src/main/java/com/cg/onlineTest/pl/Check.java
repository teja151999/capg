

package com.cg.onlineTest.pl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cg.onlineTest.bean.Question;
import com.cg.onlineTest.bean.Test;
import com.cg.onlineTest.bean.User;
import com.cg.onlineTest.dao.TestDao;
import com.cg.onlineTest.dao.TestDaoMapImpl;
import com.cg.onlineTest.exception.TestException;
import com.cg.onlineTest.service.TestService;
import com.cg.onlineTest.service.TestServiceImpl;

public class Check
{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TestDao testDao = new TestDaoMapImpl(); 
		TestService testservice=new TestServiceImpl();
		int choice=0;
		Test test=new Test();
		User user=new User();
		while(choice<9)
		{
		   System.out.println("1.AddTest");
		   System.out.println("2.updateTest");
		   System.out.println("3.deleteTest");
		   System.out.println("4.AssignTest");
		   System.out.println("5.AddQuestion");
		   System.out.println("6.UpdateQuestion");
		   System.out.println("7.DeleteQuestion");
		   System.out.println("Enter the choice");
		   choice=sc.nextInt();
		   Check check =new Check();
		   Question  question=new  Question();
		    long testId=0;
		    long userId=0;
		    long questionId=0;	    
		    switch(choice)
		    {
		    case 1:
				System.out.print("Enter Test ID:");
				testId = sc.nextLong();
				System.out.print("Enter Test Title:");
				String testTitle = sc.next()+sc.nextLine();
				LocalTime testDuration = LocalTime.now();
				System.out.print("Enter the number of Questions:");
				int n = sc.nextInt();
				Set<Question> testQuestions = new HashSet<Question>();
				double testTotalMarks = 0.0;
				for(int i=0; i<n; i++) {	
					Question q = new Question();
					q = questionMethod();
					testQuestions.add(q);
					testTotalMarks += q.getQuestionMarks();
				}
				LocalDateTime startTime = LocalDateTime.now();
				LocalDateTime endTime = LocalDateTime.now().plusHours(2);
				test.setTestId(testId);
				test.setTestTitle(testTitle);
				test.setTestQuestions(testQuestions);
				test.setTestDuration(testDuration);	
				test.setTestTotalMarks(testTotalMarks);
				test.setStartTime(startTime);
				test.setEndTime(endTime);
	           try
	           {
	           test=testservice.addTest(test);
	           System.out.println("test id " +test.getTestId());
	           }
	           catch(TestException e)
	           {
	        	   System.err.println(e.getMessage());
	           }
	           break;
		    	
		    case 2:
		    	try
		    	{
		    		 System.out.println("Enter the testId");
		    		 testId=sc.nextInt();
		    		 test=testservice.updateTest(testId,test); 
		    		 System.out.println("TestId = "+ test.getTestId());
		    		 System.out.println("TestName = "+test.getTestTitle());
		    		 System.out.println("TestDuration = "+test.getTestDuration());
		    		 
		    	}
		    	catch(TestException e)
		    	{
		    		System.err.println(e.getMessage());
		    	}
		    	break;
		    case 3:
		    	try
		    	{
		    		System.out.println("Enter the testId");
		    		testId=sc.nextInt();
		    		test=testservice.deleteTest(testId);
		    		System.out.println(testId +" is deleted");
		    	}
		    	catch(TestException e)
		    	{
		    		System.err.println(e.getMessage());
		    	}
		    	break;		    				    	
		    case 4:	    	
		    		System.out.println("Enter the userId");
		    		userId=sc.nextInt();
		    		System.out.println("enter test id");
		    		testId=sc.nextInt();
		    		user.setUserId(userId);
		    		test.setTestId(testId);		    		
		    		try
		    		{
		    		   testservice.assignTest(userId,testId);
		    		   System.out.println("Test is assigned to the given user "+userId);
		    	    }
		    	catch(TestException e)
		    	{
		    		System.err.println(e.getMessage());
		    	}	
		    		break;
		    case 5:
		    	try
		    	{
		    		System.out.println("Enter the testId in which you want to add question");
		    		testId=sc.nextInt(); 
		    		question=testDao.addQuestions(testId,question);
		    		System.out.println("QuestionId = "+question.getQuestionId());
		    		System.out.println("QuestionName = "+question.getQuestionTitle());
		    		System.out.println("QuestionOptions = "+question.getQuestionOptions());		
		    	}
		    	catch(TestException e)
		    	{
		    		System.err.println(e.getMessage());
		    	}
		    	break;
		    case 6:
				try {	
		    		System.out.println("Enter the question id to update");
		    		questionId=sc.nextInt();
					question=testDao.updateQuestion(questionId, question);
					System.out.println(questionId+" is updated");
				}catch (TestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		    		
		    		break;
		    case 7:
		    	try
		    	{
		    		System.out.println("Enter the question id to delete");
		    		questionId=sc.nextInt();
		    		Question questionDeleted;
		    		//questionId=testDao.deleteQuestions(questionId,question);
		    		questionDeleted=testDao.deleteQuestions(questionId,question);
		    		System.out.println(questionId+" is deleted");
		    	}
		    	catch(TestException e)
		    	{
		    		System.err.println(e.getMessage());
		    	}
		    	break;
		    case 8:
		    	
		    	System.out.println("exit");
		    	break;
		    default:
		    	
		    	System.out.println("Invalid choice");
		    	break; 
		    }
		   
		}
	}
	public static void register() throws TestException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter userID:");
		Long userId = sc.nextLong();
		System.out.println("Enter TestID:");
		long TestId = sc.nextLong();
		Check c = new Check();
		System.out.println("Candidate Register successfully!!!");
		TestService t = new TestServiceImpl();
		boolean b = t.assignTest(userId, TestId);
		try {
			if(b) {
				System.out.println("Test Assigned Successfully!!!");
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.err.println("No test available");
		}
	}
	public static Question questionMethod() {
			Scanner sc = new Scanner(System.in);
			Question q1 = new Question();
			System.out.print("Enter Question id:");
			long qId = sc.nextLong();
			System.out.print("Enter Question Title:");
			String qTitle = sc.next()+sc.nextLine();
			q1.setQuestionTitle(qTitle);
			List<String> ls = new ArrayList<String>();
			System.out.println("Enter options:");
			for(int  i=0; i<4; i++) {
				String s = sc.nextLine();
				ls.add(s);
			}
			q1.setQuestionOptions(ls);
			q1.setQuestionId(qId);
			System.out.print("Enter the Key:");
			int qKey = sc.nextInt();
			q1.setQuestionAnswer(qKey);

			System.out.println("Emter marks for the Question");
			double qMarks = sc.nextDouble();
			q1.setQuestionMarks(qMarks);
			return q1;
	}
}


