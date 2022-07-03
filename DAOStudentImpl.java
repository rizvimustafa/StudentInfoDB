package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.StudentModel;
import StudentDB.StudentDBConnection;

public class DAOStudentImpl implements DAOStudent{

	@Override
	public void save(StudentModel student) {
		try {
			Connection c = StudentDBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("INSERT INTO student(name,course,fee) VALUES (?,?,?)");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setInt(3, student.getFee());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "SAVED!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
	}

	@Override
	public void delete(StudentModel student) {
		// TODO Auto-generated method stub
		try {
			Connection c = StudentDBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM student WHERE ID = ?");
			ps.setInt(1, student.getID());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "DELETED!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
		
	}

	@Override
	public void update(StudentModel student) {
		// TODO Auto-generated method stub
		try {
			Connection c = StudentDBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE student SET name = ?, course = ?, fee = ? WHERE ID = ?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setInt(3, student.getFee());
			ps.setInt(4, student.getID());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "UPDATED!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
		
	}

	@Override
	public StudentModel search(int ID) {
		// TODO Auto-generated method stub
		StudentModel s = new StudentModel();
		try {
			Connection c = StudentDBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM student WHERE ID = ?");
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s.setID(rs.getInt("ID"));
				s.setName(rs.getString("name"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
			}
		}
		catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
		return s;
	}

	@Override
	public List<StudentModel> studentList() {
		// TODO Auto-generated method stub
		
		List<StudentModel> list = new ArrayList<StudentModel>();
		try {
			Connection c = StudentDBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentModel student = new StudentModel();
				student.setID(rs.getInt("ID"));
				student.setName(rs.getString("name"));
				student.setCourse(rs.getString("course"));
				student.setFee(rs.getInt("fee"));
				list.add(student);	
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
		return list;
	}

}
