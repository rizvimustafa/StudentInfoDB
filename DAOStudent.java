package Controller;

import java.util.List;

import Model.StudentModel;

public interface DAOStudent {
	void save(StudentModel student);
	void delete(StudentModel student);
	void update(StudentModel student);
	StudentModel search(int ID);
	List<StudentModel> studentList();
	
}
