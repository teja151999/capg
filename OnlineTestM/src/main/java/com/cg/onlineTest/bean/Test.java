package com.cg.onlineTest.bean;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

public class Test {
	private long testId;
    private String testTitle;
    private LocalTime testDuration; 
    Set<Question> testQuestions;
    private double testTotalMarks;
    private double testMarksScored;
    Question currentQuestion;
    LocalDateTime startTime;
    LocalDateTime endTime;   
    Map<Integer, Question> map;	
    public Test(long testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
			double testTotalMarks, double testMarksScored, LocalDateTime startTime,
			LocalDateTime endTime, Map<Integer, Question> map) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.map = map;
	}
    public Test(long testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
			double testTotalMarks, LocalDateTime startTime,LocalDateTime endTime, Map<Integer, Question> map) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.startTime = startTime;
		this.endTime = endTime;
		this.map = map;
	}
	public Test() {
		super();
	}
	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	public Set<Question> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public double getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public double getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Map<Integer, Question> getMap() {
		return map;
	}
	public void setMap(Map<Integer, Question> map) {
		this.map = map;
	}
}
