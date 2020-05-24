package manageStudent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFindPlace;
	private JTextField textFieldFindID;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldDate;
	private JTextField textFieldPlace;
	private JTextField textFieldMath;
	private JTextField textFieldPhysic;
	private JTextField textFieldChemistry;
	private JTextField textFieldTotal;
	
	static studentHandle stuHandle = new studentHandle();
	static ArrayList<student> stuList = new ArrayList<>();
	static ArrayList<home> homeList = new ArrayList<>();
	ArrayList<student> findstu = new ArrayList<>();
	HashSet<Integer> checkStudentID = new HashSet<>();
	int rowIndex = 0, rowView = 0;
	static int maxStudentID = 0;
    static JTable table = new JTable();
	Boolean isEdit = false, isOpen = false;
	//Create Insert Form
	insertPanel in;

	/**
	 * Create the frame.
	 */
	public mainFrame() {
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
        		IllegalAccessException | UnsupportedLookAndFeelException ex) {
           System.out.println(ex.toString());
        }
        SwingUtilities.updateComponentTreeUI(this);
        
		setMinimumSize(new Dimension(650, 600));
	    setLocationRelativeTo(null);
		setTitle("Student Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 579);
		//Confirm Panel Exit
		addWindowListener((WindowListener) new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		        confirmExitPanel();
		      }
		  });	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuOpen = new JMenuItem("Open ...");
		mnNewMenu.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close ...");
		mnNewMenu.add(menuClose);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		mnNewMenu.add(menuExit);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuAbout = new JMenuItem("About me ...");
		mnNewMenu_1.add(menuAbout);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2, true), "Student Filter", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2, true), "Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "List Student", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(42)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(42)
					.addComponent(btnOK, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInsert)
						.addComponent(btnClear)
						.addComponent(btnDelete)
						.addComponent(btnOK)
						.addComponent(btnEdit))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
		);

		//Create Table

		table.setModel(new DefaultTableModel(
			new Object[][] { },
			new String[] {
				"No", "ID", "Name", "Place", "Date", "Sex", "Math", "Physical", "Chemistry"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class, String.class, Float.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel labelID = new JLabel("ID\r\n");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel labelName = new JLabel("Name");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel labelPlace = new JLabel("BirthPlace");
		labelPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel labelDate = new JLabel("Date");
		labelDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setEditable(false);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setEditable(false);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		textFieldDate.setEditable(false);
		
		textFieldPlace = new JTextField();
		textFieldPlace.setColumns(10);
		textFieldPlace.setEditable(false);
		
		JLabel labelSex = new JLabel("Sex");
		labelSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton radioMale = new JRadioButton("M");
		radioMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton radioFemale = new JRadioButton("FM");
		radioFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioMale);
		bg.add(radioFemale);
		radioMale.setEnabled(false);
		radioFemale.setEnabled(false);
		
		
		JLabel labelMath = new JLabel("Math");
		labelMath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel labelPhysic = new JLabel("Physical");
		labelPhysic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel labelTotal = new JLabel("Total");
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldMath = new JTextField();
		textFieldMath.setColumns(10);
		textFieldMath.setEditable(false);
		
		textFieldPhysic = new JTextField();
		textFieldPhysic.setColumns(10);
		textFieldPhysic.setEditable(false);
		
		textFieldChemistry = new JTextField();
		textFieldChemistry.setColumns(10);
		textFieldChemistry.setEditable(false);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setEditable(false);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(labelSex)
						.addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelPlace)
						.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldID, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(textFieldPlace, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(textFieldDate, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(radioMale)
							.addGap(53)
							.addComponent(radioFemale))
						.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addGap(127)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(labelMath)
						.addComponent(labelPhysic)
						.addComponent(lblChemistry)
						.addComponent(labelTotal))
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldMath, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldPhysic, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldChemistry, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldTotal, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
					.addGap(31))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelID)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelMath)
						.addComponent(textFieldMath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelPhysic)
								.addComponent(textFieldPhysic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChemistry)
								.addComponent(textFieldChemistry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelTotal)
										.addComponent(textFieldTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(labelName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelPlace)
								.addComponent(textFieldPlace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(labelDate)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelSex)
						.addComponent(radioFemale, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioMale, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnFilter = new JButton("Filter");
		
		JLabel labelFindPlace = new JLabel("BirthPlace");
		labelFindPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldFindPlace = new JTextField();
		textFieldFindPlace.setColumns(10);
		
		JLabel labelFindID = new JLabel("StudentID");
		labelFindID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldFindID = new JTextField();
		textFieldFindID.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelFindPlace, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldFindPlace, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(labelFindID, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldFindID, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(btnFilter, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnReturn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelFindPlace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textFieldFindPlace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelFindID)
						.addComponent(textFieldFindID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFilter)
						.addComponent(btnReturn))
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		//Default Table Model
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		//Hien thi du lieu tu 1 hang trong bang ra textfield
		table.addMouseListener((MouseListener) new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                rowView = table.getSelectedRow();
                rowIndex = table.convertRowIndexToModel(rowView);
                fillText(radioMale, radioFemale, tableModel);
            }
        });
		//Set Auto Create Row Sorter
		table.setAutoCreateRowSorter(true);
		//Tu dong sap xep theo MSV ngay sau khi doc file
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		int columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING)); 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		//Dieu chinh STT sau khi sap xep
		sorter.addRowSorterListener(new RowSorterListener() {
		    @Override
		    public void sorterChanged(RowSorterEvent evt) {
		        int indexOfNoColumn = 0;
		        for (int i = 0; i < table.getRowCount(); i++) {
		            table.setValueAt(i + 1, i, indexOfNoColumn);
		        }
		    }
		});
		//Khong sap xep STT va Ngay sinh
		sorter.setSortable(0, false);
		sorter.setSortable(4, false);
		//Can le cho bang
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		table.setDefaultRenderer(Float.class, centerRenderer);
		
		//Chon Open 
		menuOpen.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) {
						
						stuHandle.inputHomeFromFile();
						stuHandle.inputStudentFromFile();
						isOpen = true;
						stuList = stuHandle.getStudentList();
						homeList = stuHandle.getHomeList();
						maxStudentID = stuHandle.getMaxStudentID();
						checkStudentID = stuHandle.getCheckStudentID();
						printTable(tableModel, stuList);
					}
		});
		//Chon CLose
		menuClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if(isOpen == true)
				{
				stuHandle.outputHomeToFile();
				stuHandle.outputStudentToFile();
				if(tableModel.getRowCount() > 0)
					for(int i = tableModel.getRowCount() - 1 ; i >= 0 ; i--)
						tableModel.removeRow(i);
				isOpen = false;
				}
				else showMessage("Chua mo file");
			}
		});
		
	    //Chon Exit
		menuExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				confirmExitPanel();
			}
		});
		//Chon Edit
		btnEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if(isEdit == false)
				{
				//Bam lan 1 de cho phep sua text
				setEdit(radioMale, radioFemale);
				isEdit = true;
				}
				else
				{
				//Bam lan 2 de khoa tinh nang sua text 
					setNonEdit(radioMale, radioFemale);
					isEdit = false;
				}
			 }
		});
		//Chon Clear
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				clearText(bg);
			}
		});   
		//Chon Insert
		btnInsert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				student st = new student();
				/*if(!dataValidation(radioMale, radioFemale, st, 1))
				return;
				stuList.add(st);*/
				in = new insertPanel();
				if(!in.isVisible())
				{
					in.clearText(in.bgg);
					in.setVisible(true);
				}
				/*st = stuList.get(stuList.size() -1);
				maxStudentID++;
				stuHandle.updateMax();
				stuHandle.updateCheckID(st.getStudentID());
				printRow(tableModel , table.getRowCount() , st);*/
				
			 }
		});    
		//Chon OK
		btnOK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				student st = new student();
				if(!dataValidation(radioMale, radioFemale, st, 0))
				 return;
				int result = JOptionPane.showConfirmDialog(rootPane,"Are you sure?","Message",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{	

				for(int i = 0 ; i < stuList.size() ; i++)
				{
				  if(stuList.get(i).getStudentID() == st.getStudentID())
				  {
					  stuList.get(i).setStudentID(st.getStudentID());
					  stuList.get(i).setName(st.getName());
					  stuList.get(i).setBirthdate(st.getBirthdate());
					  stuList.get(i).setHomeID(st.getHomeID());
					  stuList.get(i).setGender(st.isGender());
					  stuList.get(i).setMath(st.getMath());
					  stuList.get(i).setPhysic(st.getPhysic());
					  stuList.get(i).setChemistry(st.getChemistry());
				  }
				}
				//Thay doi data cua bang
				tableModel.setValueAt(st.getStudentID(), rowIndex, 1);
				tableModel.setValueAt(st.getName(), rowIndex, 2);
				int checkID = stuHandle.foundHomeID(st.getHomeID());
				if(checkID >= 0) 
				  tableModel.setValueAt(homeList.get(checkID).getName(), rowIndex, 3);
				else tableModel.setValueAt("", rowIndex, 3);
				tableModel.setValueAt(st.getBirthdate(), rowIndex, 4);
				if(st.isGender() == true) 
				 tableModel.setValueAt("M", rowIndex, 5);
				else tableModel.setValueAt("FM", rowIndex, 5);
				tableModel.setValueAt(st.getMath(), rowIndex, 6);
				tableModel.setValueAt(st.getPhysic(), rowIndex, 7);
				tableModel.setValueAt(st.getChemistry(), rowIndex, 8);
				}
				if(result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			 }
		});   
		//chon delete
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(rootPane,"Are you sure?","Message",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{	
				   tableModel.removeRow(rowIndex);	
				   for(int i = 0 ; i < stuList.size() ; i++)
					   if(stuList.get(i).getStudentID() == Integer.parseInt(textFieldID.getText()))
						   stuList.remove(i);
				}
				if(result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			 }
		});    
		//Chon Filter
		btnFilter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				String s1 = textFieldFindPlace.getText();
				String s2 = textFieldFindID.getText();
				s1 = s1.trim();
				s2 = s2.trim();
				if(s1.equals("") && s2.equals("")) return;
				List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
				s1 = String.format("(?i)%s", s1);
				filters.add(RowFilter.regexFilter(s1 , 3));
				filters.add(RowFilter.regexFilter(s2 , 1));
				sorter.setRowFilter(RowFilter.andFilter(filters));
			 }
		});    
		//Chon Return
		btnReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				//Tat filter
				sorter.setRowFilter(null);
			 }
		});    
		//Chon about
		menuAbout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Nhom 10 Java CNTT3 - K59\n"
						+ "- Pham Minh Tri\n- Nguyen Huu Thao\n- Dao Anh Khoa\n"
						+ "- Luong Thi Huong\n- Nguyen Duc Vinh","About",JOptionPane.PLAIN_MESSAGE);
			 }
		});    
		/* .addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
			 }
		});    
		*/
	}
    //Lay du lieu tu bang ra textfield
	public void fillText(JRadioButton radioMale, JRadioButton radioFemale, DefaultTableModel tableModel) {
		float math = 0, physic = 0, chemistry = 0;
		String sex= "";
		if(tableModel.getValueAt(rowIndex, 6) != null)
		 math = Float.parseFloat(tableModel.getValueAt(rowIndex, 6).toString());
		
		if(tableModel.getValueAt(rowIndex, 7) != null)
		 physic = Float.parseFloat(tableModel.getValueAt(rowIndex, 7).toString());
		
		if(tableModel.getValueAt(rowIndex, 8) != null)
		 chemistry = Float.parseFloat(tableModel.getValueAt(rowIndex, 8).toString());
		
		if(tableModel.getValueAt(rowIndex, 5) != null)
		 sex = tableModel.getValueAt(rowIndex, 5).toString();
		
		if(tableModel.getValueAt(rowIndex, 1) != null)    
		textFieldID.setText(tableModel.getValueAt(rowIndex, 1).toString());
		
		if(tableModel.getValueAt(rowIndex, 2) != null)
		textFieldName.setText(tableModel.getValueAt(rowIndex, 2).toString());
		
		if(tableModel.getValueAt(rowIndex, 3) != null)
		textFieldPlace.setText(tableModel.getValueAt(rowIndex, 3).toString());
		
		if(tableModel.getValueAt(rowIndex, 4) != null)
		textFieldDate.setText(tableModel.getValueAt(rowIndex, 4).toString());
		
		if(sex.equals("FM")) radioFemale.setSelected(true);
		if(sex.equals("M")) radioMale.setSelected(true);
		
		textFieldMath.setText(String.valueOf(math));
		textFieldPhysic.setText(String.valueOf(physic));
		textFieldChemistry.setText(String.valueOf(chemistry));
		textFieldTotal.setText(String.valueOf(math + physic + chemistry));
	}

	//In du lieu ra bang
	public void printTable(DefaultTableModel tableModel, ArrayList<student> stuList) {
		//Xoa bang cu di
		if(tableModel.getRowCount() > 0)
		   for(int i = tableModel.getRowCount() - 1 ; i >= 0 ; i--)
			   tableModel.removeRow(i);
		//Tao bang moi
		for(int i = 0 ; i < stuList.size() ; i ++)
		{
		 student st = new student();	
		 st = stuList.get(i);
		 printRow(tableModel, i, st);
		}
	}

	public static void printRow(DefaultTableModel tableModel, int i, student st) {
		int studentID = st.getStudentID();
		 String name = st.getName();
		 String place = "";
		 int checkID = stuHandle.foundHomeID(st.getHomeID());
		 if(checkID >= 0)  place = homeList.get(checkID).getName();
		 String date = st.getBirthdate();
		 String sex = "";
		 if(st.isGender() == true) sex = "M";
		 if(st.isGender() == false) sex = "FM";
		 float math = st.getMath(), physical = st.getPhysic(), chemistry = st.getChemistry();
		 
		 tableModel.addRow(new Object[] {i + 1 , studentID , name , place ,
				            date , sex , math, physical , chemistry});
	}
	public static void addRow(student st)
	{
		DefaultTableModel tableMo = (DefaultTableModel) table.getModel();
		 int studentID = st.getStudentID();
		 String name = st.getName();
		 String place = "";
		 int checkID = stuHandle.foundHomeID(st.getHomeID());
		 if(checkID >= 0)  place = homeList.get(checkID).getName();
		 String date = st.getBirthdate();
		 String sex = "";
		 if(st.isGender() == true) sex = "M";
		 if(st.isGender() == false) sex = "FM";
		 float math = st.getMath(), physical = st.getPhysic(), chemistry = st.getChemistry();
		 int i = tableMo.getRowCount();
		 tableMo.addRow(new Object[] {i , studentID , name , place ,
				            date , sex , math, physical , chemistry});
	}

	public void setNonEdit(JRadioButton radioMale, JRadioButton radioFemale) {
		textFieldName.setEditable(false);
		textFieldDate.setEditable(false);
		textFieldPlace.setEditable(false);
		textFieldMath.setEditable(false);
		textFieldPhysic.setEditable(false);
		textFieldChemistry.setEditable(false);
		radioMale.setEnabled(false);
		radioFemale.setEnabled(false);
	}

	public void setEdit(JRadioButton radioMale, JRadioButton radioFemale) {
		textFieldName.setEditable(true);
		textFieldDate.setEditable(true);
		textFieldPlace.setEditable(true);
		textFieldMath.setEditable(true);
		textFieldPhysic.setEditable(true);
		textFieldChemistry.setEditable(true);
		radioMale.setEnabled(true);
		radioFemale.setEnabled(true);
	}
	public void clearText(ButtonGroup bg) {
		textFieldID.setText("");
		textFieldName.setText("");
		textFieldDate.setText("");
		textFieldPlace.setText("");
		textFieldMath.setText("");
		textFieldPhysic.setText("");
		textFieldChemistry.setText("");
		textFieldTotal.setText("");
		bg.clearSelection();
	}

	public void confirmExitPanel() {
		int result = JOptionPane.showConfirmDialog(rootPane,
				"The process is not saved, do you want to save before exit?");
		if(result == JOptionPane.CLOSED_OPTION)
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if(result == JOptionPane.CANCEL_OPTION)
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if (result == JOptionPane.YES_OPTION)
		{
		  if(isOpen == true)
			  {
			  stuHandle.outputHomeToFile();
			  stuHandle.outputStudentToFile();
			  }
		  dispose();
		}
		else if (result == JOptionPane.NO_OPTION)
		  dispose();
	}
	public void showMessage(String s)
	{
	   JOptionPane.showMessageDialog(rootPane, s,"Message",JOptionPane.WARNING_MESSAGE);
	}

	public boolean dataValidation(JRadioButton radioMale, JRadioButton radioFemale, student st,int ne) 
	{
		home hm = new home();
		String textID = textFieldID.getText().trim();
		String textName = textFieldName.getText().trim();
		String textPlace = textFieldPlace.getText().trim();
		String textDate = textFieldDate.getText().trim();
		String textMath = textFieldMath.getText().trim();
		String textPhysic = textFieldPhysic.getText().trim();
		String textChemistry = textFieldChemistry.getText().trim();
		//Tu tao ID
		if(ne == 1)
		{
	    textFieldID.setText(String.valueOf(maxStudentID + 1));
	    st.setStudentID(maxStudentID +1);
		}
		else st.setStudentID(Integer.parseInt(textID));
		//Kiem tra ten
		if(!st.checkName(textName)) 
		{
		  showMessage("Name is invalid!");
		  return false;
		}
		else st.setName(textName);
		//Kiem tra que quan
		if(!hm.checkName(textPlace))
		{
			showMessage("Place is invalid!");
			return false;
		}
		else 
		{
			if(stuHandle.foundHomeName(textPlace) >= 0)
				st.setHomeID(homeList.get(stuHandle.foundHomeName(textPlace)).getHomeID());
			else 
			{
				st.setHomeID(stuHandle.addNewHome(textPlace));
			}
		}
		//Kiem tra ngay sinh
		 if(!st.checkBirthdate(textDate))
		 {
			 showMessage("Birthdate is invalid!");
			 return false;
		 }
		 else
		 { 
			 if(!st.checkBirthdateBound(textDate))
		     {
			 showMessage("Birthdate is invalid!");
			 return false;
		      }
			 else st.setBirthdate(textDate);
		 }
		 //Kiem tra gioi tinh
		 if(!radioMale.isSelected() && !radioFemale.isSelected())
		 {
			 showMessage("Choose gender!");
			 return false;
		 }
		 else
		 { 
			if(radioMale.isSelected()) st.setGender(true);
			else st.setGender(false);
		 }
		 //Kiem tra diem toan
		 if(!st.checkPoint(textMath))
		 {
			 showMessage("Mark is invalid!");
			 return false;
		 }
		 else
		 {
			 if(!st.checkPointBound(Float.parseFloat(textMath)))
			 {
				 showMessage("Mark is invalid!");
		    	 return false;
			 }
			 else st.setMath(Float.parseFloat(textMath));
		 }
		 //Kiem tra diem ly
		 if(!st.checkPoint(textPhysic))
		 {
			 showMessage("Mark is invalid!");
			 return false;
		 }
		 else
		 {
			 if(!st.checkPointBound(Float.parseFloat(textPhysic)))
			 {
				 showMessage("Mark is invalid!");
		    	 return false;
			 }
			 else st.setPhysic(Float.parseFloat(textPhysic));
		 }
		 //Kiem tra diem hoa
		 if(!st.checkPoint(textChemistry))
		 {
			 showMessage("Mark is invalid!");
			 return false;
		 }
		 else
		 {
			 if(!st.checkPointBound(Float.parseFloat(textChemistry)))
			 {
				 showMessage("Mark is invalid!");
		    	 return false;
			 }
			 else st.setChemistry(Float.parseFloat(textChemistry));
		 }
		 return true;
	}
}
