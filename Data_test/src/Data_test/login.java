package Data_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1044, 781);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE\r\n");
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 50));
		lblNewLabel.setBounds(422, 54, 306, 97);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(98, 182, 227, 76);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(105, 312, 220, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(332, 194, 531, 51);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(335, 301, 528, 51);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=t1.getText();
				String pass=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ece_c","root","mrec");
					String q="Select count(*) from signup where username=? and password=?";
					 PreparedStatement ps=con.prepareStatement(q);
					 ps.setString(1, user);
					 ps.setString(2, pass);
					 ResultSet rs=ps.executeQuery();
					 rs.next();
					 int c=rs.getInt(1);
					 if((c==0))
					 {
						 JOptionPane.showMessageDialog(btnNewButton, "Invalid");
					 }
					 else
					 { 
						 JOptionPane.showMessageDialog(btnNewButton, "Done");
					 }
							 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 40));
		btnNewButton.setBounds(463, 534, 184, 59);
		frame.getContentPane().add(btnNewButton);
	}

}
