
	package com.cg.onlineTest.bean;


	import java.util.ArrayList;
	import java.util.List;

	public class Question 
	{
			// fields
			long questionId ; 
		    List<String> questionOptions = new ArrayList<String>();
			String questionTitle ;
			int questionAnswer ;
			double questionMarks ;
			int chosenAnswer ;
			double marksScored ;		
			public Question(long questionId, List<String> questionOptions, String questionTitle, int questionAnswer,
					double questionMarks, int chosenAnswer, double marksScored) {
				super();
				this.questionId = questionId;
				this.questionOptions = questionOptions;
				this.questionTitle = questionTitle;
				this.questionAnswer = questionAnswer;
				this.questionMarks = questionMarks;
				this.chosenAnswer = chosenAnswer;
				this.marksScored = marksScored;
			}
			public Question() {
				super();
			}
			// setters and getters
			public long getQuestionId() {
				return questionId;
			}
			public void setQuestionId(long questionId) {
				this.questionId = questionId;
			}
			public  List<String> getQuestionOptions() {
				return questionOptions;
			}
			public void setQuestionOptions(List<String> ls) {
				this.questionOptions = ls;
			}
			public String getQuestionTitle() {
				return questionTitle;
			}
			public void setQuestionTitle(String questionTitle) {
				this.questionTitle = questionTitle;
			}
			public int getQuestionAnswer() {
				return questionAnswer;
			}
			public void setQuestionAnswer(int questionAnswer) {
				this.questionAnswer = questionAnswer;
			}
			public double getQuestionMarks() {
				return questionMarks;
			}
			public void setQuestionMarks(double questionMarks) {
				this.questionMarks = questionMarks;
			}
			public int getChosenAnswer() {
				return chosenAnswer;
			}
			public void setChosenAnswer(int chosenAnswer) {
				this.chosenAnswer = chosenAnswer;
			}
			public double getMarksScored() {
				return marksScored;
			}
			public void setMarksScored(double marksScored) {
				this.marksScored = marksScored;		
			}
	}


