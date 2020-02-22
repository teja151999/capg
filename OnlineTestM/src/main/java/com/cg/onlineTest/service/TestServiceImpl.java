package com.cg.onlineTest.service;


	import java.util.Random;

	import com.cg.onlineTest.dao.TestDao;
	import com.cg.onlineTest.dao.TestDaoMapImpl;
	import com.cg.onlineTest.exception.TestException;
	import com.cg.onlineTest.bean.Question;
	import com.cg.onlineTest.bean.Question;
	import com.cg.onlineTest.bean.Test;

	public class TestServiceImpl implements TestService
	{
		private TestDao testDao;
		public TestServiceImpl()
		{
			testDao = new TestDaoMapImpl();
		}
		
		public boolean validateName(String testTitle)
		{
		   boolean flag=false;
		   flag=testTitle.matches("[a-zA-z]+");
		   return flag;
		}
	
		public Test addTest(Test test) throws TestException 
		{
			String name=test.getTestTitle();
			boolean flag=validateName(name);
			try {
			if(!flag)
			{
				throw new TestException("Name should contain only characters");			
			} 
			}catch(TestException e) {
				e.getMessage();
			}
			test.setTestId(test.getTestId());
			test=testDao.addTest(test);
			return test;
		}
		public void assignTest(int userId, int testId) throws TestException 
		{
	       testDao.assignTest(userId,testId);     		
		}
		
		public Test updateTest(long testId, Test test) throws TestException {
			// TODO Auto-generated method stub
			return null;
		}
	
		public Test deleteTest(long testId) throws TestException {
			// TODO Auto-generated method stub
			return null;
		}
	
		public boolean assignTest(long userId, long TestId) throws TestException {
			// TODO Auto-generated method stub
			return false;
		}
	
		public Question addQuestions(long testId, Question question) throws TestException {
			// TODO Auto-generated method stub
			return null;
		}
	
		public Question deleteQuestions(long testId, Question question) throws TestException {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Double getResult(Test test) {
			// TODO Auto-generated method stub
			return 0.0;
		}	
}
