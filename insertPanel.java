package manageStudent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class insertPanel extends JFrame {

	private JPanel contentPane;
	private static JTextField textInsertID;
	private static JTextField textInsertName;
	private static JTextField textInsertPlace;
	private static JTextField textInsertDate;
	private static JTextField textInsertMath;
	private static JTextField textInsertPhysic;
	private static JTextField textInsertChemistry;
	student st = new student();
	protected ButtonGroup bgg;

	public insertPanel()
	{
		initialize();
	}
	
	public void initialize() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Insert");
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		         setVisible(false);
		      }
		  });	
		setBounds(100, 100, 358, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("BirthPlace");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("BirthDate");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Math");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("Physical");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("Chemistry");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7 = new JLabel("Sex");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textInsertID = new JTextField();
		textInsertID.setColumns(10);
		textInsertID.setEditable(false);
		//Tu tao ID
	   // textInsertID.setText(String.valueOf(mainFrame.maxStudentID + 1));
		
		textInsertName = new JTextField();
		textInsertName.setColumns(10);
		
		textInsertPlace = new JTextField();
		textInsertPlace.setColumns(10);
		
		textInsertDate = new JTextField();
		textInsertDate.setColumns(10);
		
		textInsertMath = new JTextField();
		textInsertMath.setColumns(10);
		
		textInsertPhysic = new JTextField();
		textInsertPhysic.setColumns(10);
		
		textInsertChemistry = new JTextField();
		textInsertChemistry.setColumns(10);
		
		JRadioButton radioInsertMale = new JRadioButton("M");
		
		JRadioButton radioInsertFemale = new JRadioButton("FM");
		bgg = new ButtonGroup();
		bgg.add(radioInsertMale);
		bgg.add(radioInsertFemale);
		
		JButton btnInsertOK = new JButton("OK");
		
		JButton btnInsertCancel = new JButton("Cancel");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_7))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textInsertChemistry, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(textInsertPhysic)
								.addComponent(textInsertMath)
								.addComponent(textInsertDate)
								.addComponent(textInsertPlace)
								.addComponent(textInsertName)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(radioInsertMale)
									.addGap(46)
									.addComponent(radioInsertFemale))
								.addComponent(textInsertID, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addComponent(btnInsertOK)
							.addGap(46)
							.addComponent(btnInsertCancel)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textInsertID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textInsertName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textInsertPlace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textInsertDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textInsertMath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textInsertPhysic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textInsertChemistry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(radioInsertMale)
							.addComponent(radioInsertFemale)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInsertCancel)
						.addComponent(btnInsertOK)))
		);
		contentPane.setLayout(gl_contentPane);
		btnInsertOK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
				home hm = new home();
				String textID = textInsertID.getText().trim();
				String textName = textInsertName.getText().trim();
				String textPlace = textInsertPlace.getText().trim();
				String textDate = textInsertDate.getText().trim();
				String textMath = textInsertMath.getText().trim();
				String textPhysic = textInsertPhysic.getText().trim();
				String textChemistry = textInsertChemistry.getText().trim();
				//Tu tao ID
			    st.setStudentID(mainFrame.maxStudentID +1);
			    
				//Kiem tra ten
				if(!st.checkName(textName)) 
				{
				  JOptionPane.showMessageDialog(rootPane,"Name is invalid");
				  return;
				}
				else st.setName(textName);
				//Kiem tra que quan
				if(!hm.checkName(textPlace))
				{
					 JOptionPane.showMessageDialog(rootPane,"Place is invalid");
					return;
				}
				else 
				{
					if(mainFrame.stuHandle.foundHomeName(textPlace) >= 0)
						st.setHomeID(mainFrame.homeList.get(mainFrame.stuHandle.foundHomeName(textPlace)).getHomeID());
					else 
					{
						st.setHomeID(mainFrame.stuHandle.addNewHome(textPlace));
					}
				}
				//Kiem tra ngay sinh
				 if(!st.checkBirthdate(textDate))
				 {
					 JOptionPane.showMessageDialog(rootPane,"Birthdate is invalid");
					 return;
				 }
				 else
				 { 
					 if(!st.checkBirthdateBound(textDate))
				     {
						 JOptionPane.showMessageDialog(rootPane,"Birthdate is invalid");
					 return;
				      }
					 else st.setBirthdate(textDate);
				 }
				 //Kiem tra gioi tinh
				 if(!radioInsertMale.isSelected() && !radioInsertFemale.isSelected())
				 {
					 JOptionPane.showMessageDialog(rootPane,"Choose Gender");
					 return;
				 }
				 else
				 { 
					if(radioInsertMale.isSelected()) st.setGender(true);
					else st.setGender(false);
				 }
				 //Kiem tra diem toan
				 if(!st.checkPoint(textMath))
				 {
					 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
					 return;
				 }
				 else
				 {
					 if(!st.checkPointBound(Float.parseFloat(textMath)))
					 {
						 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
				    	 return;
					 }
					 else st.setMath(Float.parseFloat(textMath));
				 }
				 //Kiem tra diem ly
				 if(!st.checkPoint(textPhysic))
				 {
					 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
					 return;
				 }
				 else
				 {
					 if(!st.checkPointBound(Float.parseFloat(textPhysic)))
					 {
						 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
				    	 return;
					 }
					 else st.setPhysic(Float.parseFloat(textPhysic));
				 }
				 //Kiem tra diem hoa
				 if(!st.checkPoint(textChemistry))
				 {
					 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
					 return;
				 }
				 else
				 {
					 if(!st.checkPointBound(Float.parseFloat(textChemistry)))
					 {
						 JOptionPane.showMessageDialog(rootPane,"Mark is invalid");
				    	 return;
					 }
					 else st.setChemistry(Float.parseFloat(textChemistry));
				 }
				mainFrame.stuList.add(st);
				mainFrame.maxStudentID++;
				mainFrame.stuHandle.updateMax();
				mainFrame.stuHandle.updateCheckID(st.getStudentID());
				mainFrame.addRow(st);
				setVisible(false);
			 }
		});  
		btnInsertCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			 }
		});    
	}
	public void clearText(ButtonGroup bgg)
	{
	    textInsertID.setText(String.valueOf(mainFrame.maxStudentID + 1));
	    textInsertName.setText("");
	    textInsertPlace.setText("");
	    textInsertDate.setText("");
	    textInsertMath.setText("");
	    textInsertPhysic.setText("");
	    textInsertChemistry.setText("");
	    bgg.clearSelection();
	}
}
