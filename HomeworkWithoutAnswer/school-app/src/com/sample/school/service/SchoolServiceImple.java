package com.sample.school.service;

import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	
	@Override
	public void addNewProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addNewSubject(Subject subject) {
		// TODO Auto-generated method stub
		
	}
	
}
