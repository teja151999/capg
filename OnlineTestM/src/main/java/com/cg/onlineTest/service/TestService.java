package com.cg.onlineTest.service;

	import com.cg.onlineTest.exception.TestException;
	import com.cg.onlineTest.bean.Question;
	import com.cg.onlineTest.bean.Test;
	import com.cg.onlineTest.bean.User;

	public interface TestService 
	{
		public boolean validateName(String testTitle); 	
		public Test addTest(Test test)throws TestException;
		public Test updateTest(long testId,Test test) throws TestException;
		public Test deleteTest(long testId) throws TestException;
		public boolean assignTest(long userId,long TestId)throws TestException;
		public Question addQuestions(long testId, Question question) throws TestException;
		public Question deleteQuestions(long testId, Question question) throws TestException;
		public Double getResult(Test test);
	}

