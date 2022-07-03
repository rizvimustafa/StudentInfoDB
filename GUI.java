package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DAOStudentImpl;
import Model.StudentModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterName;
	private JTextField txtEnterCourse;
	private JTextField txtEnterFee;
	private JTable table;
	private int searchID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Student Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 561, 52);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.GREEN);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Student Information");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		panel.add(lblNewLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(5, 57, 561, 34);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModel student = new StudentModel();
				String name = txtEnterName.getText();
				String course = txtEnterCourse.getText();
				int fee = Integer.parseInt(txtEnterFee.getText());
				
				student.setName(name);
				student.setCourse(course);
				student.setFee(fee);
				
				DAOStudentImpl daostudent = new DAOStudentImpl();
				daostudent.save(student);
				Load();
				
				txtEnterName.setText("");
				txtEnterCourse.setText("");
				txtEnterFee.setText("");
				txtEnterName.requestFocus();
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.CYAN);
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModel student = new StudentModel();
				String name = txtEnterName.getText();
				String course = txtEnterCourse.getText();
				int fee = Integer.parseInt(txtEnterFee.getText());
				
				student.setName(name);
				student.setCourse(course);
				student.setFee(fee);
				student.setID(searchID);
				
				DAOStudentImpl daostudent = new DAOStudentImpl();
				daostudent.update(student);
				Load();
				
				txtEnterName.setText("");
				txtEnterCourse.setText("");
				txtEnterFee.setText("");
				txtEnterName.requestFocus();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		toolBar.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.CYAN);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModel student = new StudentModel();
				student.setID(searchID);
				
				DAOStudentImpl daostudent = new DAOStudentImpl();
				daostudent.delete(student);
				Load();
				
				txtEnterName.setText("");
				txtEnterCourse.setText("");
				txtEnterFee.setText("");
				txtEnterName.requestFocus();
			}
		}); 
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.CYAN);
		toolBar.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 98, 163, 102);
		panel_2.setBorder(null);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(10, 11, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel_2);
		
		txtEnterName = new JTextField();
		txtEnterName.setBounds(59, 8, 86, 20);
		panel_2.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		txtEnterCourse = new JTextField();
		txtEnterCourse.setColumns(10);
		txtEnterCourse.setBounds(59, 36, 86, 20);
		panel_2.add(txtEnterCourse);
		
		JLabel lblNewLabel_2_1 = new JLabel("Course:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(10, 39, 46, 14);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fee:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setBounds(10, 67, 46, 14);
		panel_2.add(lblNewLabel_2_2);
		
		txtEnterFee = new JTextField();
		txtEnterFee.setColumns(10);
		txtEnterFee.setBounds(59, 64, 86, 20);
		panel_2.add(txtEnterFee);
		
		JLabel lblNewLabel_1 = new JLabel("MUSTAFA RIZVI");
		lblNewLabel_1.setBounds(463, 298, 103, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(lblNewLabel_1);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(5, 211, 103, 25);
		contentPane.add(toolBar_1);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchID = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID: "));
				DAOStudentImpl studentdao = new DAOStudentImpl();
				StudentModel s = studentdao.search(searchID);
				
				txtEnterName.setText(s.getName());
				txtEnterCourse.setText(s.getCourse());
				txtEnterFee.setText(String.valueOf(s.getFee()));
				
				
			}
		});
		toolBar_1.add(btnNewButton_3);
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBackground(Color.CYAN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(178, 98, 388, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 388, 189);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Student Name", "Course Name", "Course Fee"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(71);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		Load();
		txtEnterName.requestFocus();
		scrollPane.setViewportView(table);
	}
	
	void Load(){
		DAOStudentImpl studentdao = new DAOStudentImpl();
		List<StudentModel> list = studentdao.studentList();
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		
		for(StudentModel s: list){
			int id = s.getID();
			String name = s.getName();
			String course = s.getCourse();
			int fee = s.getFee();
			dft.addRow(new Object[] {id,name,course,fee});
		}
	}
}
