import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.NumberFormat;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Cursor;

public class BusReservation {

	private JFrame frmReservation;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField Contact;
	private JTextField Email;
	private JTextField Passengers;
	private JTextField DiscPassengers;
	private JTextField Payment;
	private JTable tblHistory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusReservation window = new BusReservation();
					window.frmReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BusReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservation = new JFrame();
		frmReservation.setResizable(false);
		frmReservation.setBackground(new Color(255, 255, 255));
		frmReservation.setTitle("Reservation");
		frmReservation.setBounds(100, 100, 978, 719);
		frmReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservation.getContentPane().setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 962, 691);
		frmReservation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel Destination = new JPanel();
		Destination.setBackground(Color.LIGHT_GRAY);
		Destination.setBounds(418, 91, 298, 230);
		panel.add(Destination);
		Destination.setLayout(null);
		
		JLabel lblDestinationDetails = new JLabel("Destination Details");
		lblDestinationDetails.setBounds(56, 27, 232, 25);
		Destination.add(lblDestinationDetails);
		lblDestinationDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("Selected Destination:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(66, 70, 172, 25);
		Destination.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fare Price: ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(23, 157, 88, 20);
		Destination.add(lblNewLabel_1_2_1);
		
		JLabel destFare = new JLabel("");
		destFare.setHorizontalAlignment(SwingConstants.RIGHT);
		destFare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		destFare.setBounds(130, 159, 58, 20);
		Destination.add(destFare);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1.setBounds(208, 157, 41, 20);
		Destination.add(lblNewLabel_1_2_1_1_1);
		
		// TODO: make the models dynamically set according to the database
		JComboBox City = new JComboBox();
		City.setModel(new DefaultComboBoxModel(new String[] {"Davao City", "Butuan City", "Baguio City", "Cagayan City", "Valenzuela City", "Cavite City"}));
		City.setBounds(86, 106, 139, 22);
		Destination.add(City);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Seats Available:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(23, 188, 132, 20);
		Destination.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_3 = new JLabel("Seats");
		lblNewLabel_1_2_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_3.setBounds(208, 188, 64, 20);
		Destination.add(lblNewLabel_1_2_1_1_1_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(10, 144, 278, 2);
		Destination.add(panel_1);
		
		JLabel CitySeat = new JLabel("");
		CitySeat.setHorizontalAlignment(SwingConstants.RIGHT);
		CitySeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CitySeat.setBounds(159, 188, 30, 20);
		Destination.add(CitySeat);
		
		JLabel lblNewLabel = new JLabel("RESERVATION SYSTEM");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(326, 22, 343, 44);
		panel.add(lblNewLabel);
		
		JPanel Information = new JPanel();
		Information.setBackground(new Color(192, 192, 192));
		Information.setBounds(26, 91, 382, 566);
		panel.add(Information);
		Information.setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(133, 84, 203, 20);
		Information.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(133, 125, 203, 20);
		Information.add(lastName);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(157, 207, 179, 20);
		Information.add(Email);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        
        Contact = new JTextField();
        Contact.setColumns(10);
        Contact.setBounds(180, 166, 156, 20);
        Information.add(Contact);
			
		Passengers = new JFormattedTextField(formatter);
		Passengers.setColumns(10);
		Passengers.setBounds(180, 274, 156, 20);
		Information.add(Passengers);
		
		DiscPassengers = new JFormattedTextField(formatter);
		DiscPassengers.setColumns(10);
		DiscPassengers.setBounds(229, 313, 107, 20);
		Information.add(DiscPassengers);		
		// Destination Details
		City.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			// DONE!
			// TODO set text of seats according to destination table seats 
			// TODO set the items of the comboBox according to the destination database 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");	
					Statement st = con.createStatement();		
					String desQuery = "SELECT id, Price, Seats FROM destination";
					ResultSet desrs = st.executeQuery(desQuery);

					while(desrs.next()) {
						int id = Integer.parseInt(desrs.getString(1));
						String price = desrs.getString(2);
						String seats = desrs.getString(3);
						int item = City.getSelectedIndex();
						
						if((item+1) == id) {	
							destFare.setText(price);
							CitySeat.setText(seats);					
						}
					}
					con.close();
	        	}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
	        	}

			}
		});

		
		Payment = new JTextField();
		Payment.setColumns(10);
		Payment.setBounds(180, 477, 156, 20);
		Information.add(Payment);
		
		JLabel passengerInfo = new JLabel("Passenger Information");
		passengerInfo.setBounds(72, 40, 232, 25);
		passengerInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		Information.add(passengerInfo);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 84, 115, 20);
		Information.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(29, 125, 115, 20);
		Information.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact Number:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(29, 166, 148, 20);
		Information.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email Address:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(29, 207, 141, 20);
		Information.add(lblNewLabel_1_1_2);
		
		JLabel lblDiscountFor = new JLabel("20% Discount for Children & Elders!");
		lblDiscountFor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiscountFor.setBounds(29, 238, 307, 25);
		Information.add(lblDiscountFor);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Total Passengers:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(29, 274, 141, 20);
		Information.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Discounted Passengers:");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_1.setBounds(29, 313, 191, 20);
		Information.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Total Fare:");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2.setBounds(29, 356, 103, 20);
		Information.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Total Discount:");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2_1.setBounds(29, 387, 129, 20);
		Information.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("Total:");
		lblNewLabel_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2_1_1.setBounds(29, 418, 129, 20);
		Information.add(lblNewLabel_1_2_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Payment Amount:");
		lblNewLabel_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1_2.setBounds(29, 477, 148, 20);
		Information.add(lblNewLabel_1_1_2_1_2);
		
		JLabel totalFare = new JLabel("0.0");
		totalFare.setHorizontalAlignment(SwingConstants.RIGHT);
		totalFare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalFare.setBounds(213, 356, 76, 20);
		Information.add(totalFare);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_1.setBounds(295, 356, 41, 20);
		Information.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_2.setBounds(295, 387, 41, 20);
		Information.add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel totalDiscount = new JLabel("0.0");
		totalDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalDiscount.setBounds(213, 387, 76, 20);
		Information.add(totalDiscount);
		
		JLabel lblNewLabel_1_2_1_1_1_2_1 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_2_1.setBounds(295, 418, 41, 20);
		Information.add(lblNewLabel_1_2_1_1_1_2_1);
		
		JLabel totalPay = new JLabel("0.0");
		totalPay.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalPay.setBounds(213, 418, 76, 20);
		Information.add(totalPay);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(45, 72, 278, 2);
		Information.add(panel_1_1);
		
		// setting items into database (DONE)
		JButton submitPassInfo = new JButton("SUBMIT DETAILS");
		submitPassInfo.setEnabled(false);
		submitPassInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Passenger Information		
				String fname = firstName.getText();
				String lname = lastName.getText();
				String contNum = Contact.getText();
				String email = Email.getText();		
				double payment;													
				
				if(fname.trim().isBlank() || lname.trim().isBlank() || contNum.trim().isBlank() || email.trim().isBlank() || Passengers.getText().trim().isBlank() ||
						DiscPassengers.getText().trim().isBlank()  || Payment.getText().trim().isBlank()) {
					 				
					JOptionPane.showMessageDialog(null, "Please Fill out all fields");
				}
				else {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
					
					try {
						if (result == JOptionPane.YES_OPTION) {
							submitPassInfo.setEnabled(false);
							payment = Double.parseDouble(Payment.getText());
							int passengers = Integer.parseInt(Passengers.getText());
							int discPass = Integer.parseInt(DiscPassengers.getText());
							double fare = Double.parseDouble(destFare.getText());
							int item = City.getSelectedIndex();
							// TODO: add Database functions as well (DONE)
							// TODO: add update btn functions (it should only affect the balance and add the value to the amount paid). (DONE)
							double discountedPass = (fare * 0.2) * discPass;
							double totFare = fare * passengers;
							double total =  totFare - discountedPass;												
							
							if(payment > total) {
								JOptionPane.showMessageDialog(null, "Please pay exact amount!");
							}			
							else {
								try{			
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");
									String sql = "INSERT INTO `passengers`(`fname`, `lname`, `contact`, `email`, `tickets`, `payment`, `fareCost`, `discountedTicket`, `city`) VALUES (?,?,?,?,?,?,?,?,?)";
									PreparedStatement pst = con.prepareStatement(sql);
									item += 1;
									pst.setString(1, fname);
									pst.setString(2, lname);
									pst.setString(3, contNum);
									pst.setString(4, email);
									pst.setString(5, String.valueOf(passengers));
									pst.setString(6, String.valueOf(payment));
									pst.setString(7, String.valueOf(total));
									pst.setString(8, String.valueOf(discPass));
									pst.setString(9, String.valueOf(item));
									pst.executeUpdate();
									
									// done!
									PreparedStatement desPst = con.prepareStatement("UPDATE destination SET Seats = Seats - ? WHERE ID = ?");
									desPst.setInt(1, passengers);
									desPst.setInt(2, item);
									desPst.executeUpdate();

									JOptionPane.showMessageDialog(null, "Registered Successfully");
									
									refreshTable();
									
									// resets textfields
									firstName.setText("");
									lastName.setText("");
									Contact.setText("");
									Email.setText("");
									Passengers.setText("");
									DiscPassengers.setText("");
									Payment.setText("");		
									con.close();
								}catch (Exception e2) {
									JOptionPane.showMessageDialog(null, e2);
								}
								totalFare.setText(String.valueOf(totFare));
								totalDiscount.setText(String.valueOf(discountedPass));
								totalPay.setText(String.valueOf(total));
							}
							
						}				
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Please enter a number!");
					}
				}
			}
		});
		submitPassInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		submitPassInfo.setBounds(48, 516, 129, 37);
		Information.add(submitPassInfo);
		
		JButton btnUpdateDetails = new JButton("UPDATE DETAILS");
		btnUpdateDetails.setEnabled(false);
		btnUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateDetails.setBounds(203, 516, 129, 37);
		Information.add(btnUpdateDetails);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheck.setBounds(145, 441, 87, 25);
		Information.add(btnCheck);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnCancel.setBounds(295, 11, 77, 20);
		Information.add(btnCancel);
		
		JPanel History = new JPanel();
		History.setBackground(Color.LIGHT_GRAY);
		History.setBounds(726, 91, 202, 566);
		panel.add(History);
		History.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 182, 426);
		History.add(scrollPane);
		
		tblHistory = new JTable();
		tblHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportView(tblHistory);
		tblHistory.setDefaultEditor(Object.class, null);
		tblHistory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "tickets"
			}
		));
		
		JPanel PassengerDetails = new JPanel();
		PassengerDetails.setBackground(Color.LIGHT_GRAY);
		PassengerDetails.setBounds(418, 332, 298, 325);
		panel.add(PassengerDetails);
		PassengerDetails.setLayout(null);
		
		JLabel lblPassengerDetails = new JLabel("Passenger  Details");
		lblPassengerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassengerDetails.setBounds(56, 11, 232, 25);
		PassengerDetails.add(lblPassengerDetails);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Passenger Name:");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_2.setBounds(21, 59, 120, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_2);
		
		JLabel lblNewLabel_1_2_1_2_1_2 = new JLabel("Contact Number:");
		lblNewLabel_1_2_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_1_2.setBounds(21, 90, 120, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1 = new JLabel("Email Address:");
		lblNewLabel_1_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_1_1_1.setBounds(21, 118, 111, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1_1 = new JLabel("Balance:");
		lblNewLabel_1_2_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_1_1_1_1.setBounds(21, 213, 102, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_2_1 = new JLabel("Amount Paid:");
		lblNewLabel_1_2_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_1_2_1.setBounds(21, 189, 102, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Total Tickets:");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_2_2_1.setBounds(21, 168, 120, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_2_2_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1_1_1 = new JLabel("Status:");
		lblNewLabel_1_2_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_2_1_2_1_1_1_1_1.setBounds(21, 270, 102, 28);
		PassengerDetails.add(lblNewLabel_1_2_1_2_1_1_1_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.BLACK);
		panel_1_2.setBounds(10, 46, 278, 2);
		PassengerDetails.add(panel_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1_2_2 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1_1_2_2.setBounds(224, 189, 41, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_1_1_2_2);
		
		JLabel lblNewLabel_1_2_1_1_1_2_1_1 = new JLabel("PHP");
		lblNewLabel_1_2_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1_1_2_1_1.setBounds(224, 213, 41, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_1_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_2_2_1 = new JLabel("Tickets");
		lblNewLabel_1_2_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1_1_2_2_1.setBounds(224, 168, 64, 20);
		PassengerDetails.add(lblNewLabel_1_2_1_1_1_2_2_1);
		
		JLabel passName = new JLabel("");
		passName.setHorizontalAlignment(SwingConstants.LEFT);
		passName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passName.setBounds(145, 59, 143, 20);
		PassengerDetails.add(passName);
		
		JLabel contactNum = new JLabel("");
		contactNum.setHorizontalAlignment(SwingConstants.LEFT);
		contactNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contactNum.setBounds(145, 90, 143, 20);
		PassengerDetails.add(contactNum);
		
		JLabel EmailAdd = new JLabel("");
		EmailAdd.setHorizontalAlignment(SwingConstants.LEFT);
		EmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		EmailAdd.setBounds(145, 118, 143, 20);
		PassengerDetails.add(EmailAdd);
		
		JLabel ticket = new JLabel("");
		ticket.setHorizontalAlignment(SwingConstants.RIGHT);
		ticket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ticket.setBounds(188, 168, 26, 20);
		PassengerDetails.add(ticket);
		
		JLabel passAmount = new JLabel("");
		passAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		passAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passAmount.setBounds(155, 189, 59, 20);
		PassengerDetails.add(passAmount);
		
		JLabel passBalance = new JLabel("");
		passBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		passBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passBalance.setBounds(155, 213, 59, 20);
		PassengerDetails.add(passBalance);
		
		JLabel lblStatus = new JLabel("N/A");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblStatus.setBounds(133, 270, 155, 28);
		PassengerDetails.add(lblStatus);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(Color.BLACK);
		panel_1_2_1.setBounds(10, 250, 278, 2);
		PassengerDetails.add(panel_1_2_1);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setBackground(Color.BLACK);
		panel_1_2_2.setBounds(21, 155, 94, 2);
		PassengerDetails.add(panel_1_2_2);
		
		JPanel panel_1_2_2_1 = new JPanel();
		panel_1_2_2_1.setBackground(Color.BLACK);
		panel_1_2_2_1.setBounds(155, 155, 121, 2);
		PassengerDetails.add(panel_1_2_2_1);
		
		// getting data from the database 
		tblHistory.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				String selectedCellValue = (String) tblHistory.getValueAt(tblHistory.getSelectedRow(), 0);
				int tempCity = 0;
	            try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");	
					Statement st = con.createStatement();		
					String query = "SELECT * FROM passengers";
					ResultSet rs = st.executeQuery(query);		
					String id, fname, lname, contact, email, tickets, payment, total, discTicket, clientDest;
					String Cityid, price, seats;
					
					while(rs.next()) {
						// assign data from database to local variables
						id = rs.getString(1);
						fname = rs.getString(2);
						lname = rs.getString(3);
						contact = rs.getString(4);
						email = rs.getString(5);
						tickets = rs.getString(6);
						payment = rs.getString(7);
						total = rs.getString(8);
						discTicket = rs.getString(9);
						clientDest = rs.getString(10);	
						
						if(selectedCellValue.equals(id)) {
							// Passenger details
							passName.setText(fname.toUpperCase() + " " + lname.toUpperCase());
							contactNum.setText(contact);
							EmailAdd.setText(email);
							ticket.setText(tickets);
							passAmount.setText(payment);
							totalPay.setText(total);
							City.setSelectedIndex(Integer.parseInt(clientDest) - 1);
							
							// Destination Details					        
							tempCity = Integer.parseInt(clientDest);
							
							//Passenger Information		
							double balance = Double.parseDouble(total) - Double.parseDouble(payment);
							passBalance.setText(String.valueOf(balance));
							if(balance <= 0) {
								btnUpdateDetails.setEnabled(false);
								lblStatus.setText("COMPLETE");
								Payment.setText("Fully Paid!");
								Payment.setEditable(false);
							}else {
								btnUpdateDetails.setEnabled(true);
								lblStatus.setText("INCOMPLETE");
								Payment.setEditable(true);
							}
							
							City.setEnabled(false);
							submitPassInfo.setEnabled(false);
							btnCancel.setEnabled(true);
							
							totalFare.setText("0.0");
							totalDiscount.setText("0.0");
							
							firstName.setText(fname);
							firstName.setEditable(false);
							
							lastName.setText(lname);
							lastName.setEditable(false);
							
							Contact.setText(contact);
							Contact.setEditable(false);
							
							Email.setText(email);
							Email.setEditable(false);
							
							Passengers.setText(tickets);
							Passengers.setEditable(false);
							
							DiscPassengers.setText(discTicket);
							DiscPassengers.setEditable(false);
							
							Payment.setText("");	
						}
					}
					
					rs.close();
					String desQuery = "SELECT id, Price, Seats FROM destination";
					ResultSet desrs = st.executeQuery(desQuery);
					
					while(desrs.next()) {
						Cityid = desrs.getString(1);
						price = desrs.getString(2);
						seats = desrs.getString(3);
						
						if(tempCity == Integer.parseInt(Cityid)) {
							destFare.setText(String.valueOf(price));
							CitySeat.setText(String.valueOf(seats));			
						}
					}
					desrs.close();
					con.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
	            
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");	
					Statement st = con.createStatement();		
					String desQuery = "SELECT id, Seats FROM destination";
					ResultSet desrs = st.executeQuery(desQuery);
					
            		int passengers = Integer.parseInt(Passengers.getText());
    				int discPass = Integer.parseInt(DiscPassengers.getText());
    				double fare = Double.parseDouble(destFare.getText());
    				
    				while(desrs.next()) {
    					int id = Integer.parseInt(desrs.getString(1));
    					int seats = Integer.parseInt(desrs.getString(2));
    					
    					if((City.getSelectedIndex()+1) == id) {
    						if(discPass > passengers) {
    							JOptionPane.showMessageDialog(null, "discounted passengers should be equal with passengers!");
    						}else {
    							if(passengers > seats) {
    								JOptionPane.showMessageDialog(null, "There is only " + seats + " seats available.");
    							}else {
    								if(firstName.isEditable()) {
    				    				submitPassInfo.setEnabled(true);
    								}
    								
    								double discountedPass = (fare * 0.2) * discPass;
    								double totFare = fare * passengers;
    								double total =  totFare - discountedPass;
    								
    								totalFare.setText(String.valueOf(totFare));
    								totalDiscount.setText(String.valueOf(discountedPass));
    								totalPay.setText(String.valueOf(total));							
    							}
    						}    			
    					}
    				}
					con.close();
            	}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please select a destination or fill up the form.");
            	}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
            	}
			}
		});
		
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHistory.setBounds(65, 24, 87, 25);
		History.add(lblHistory);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");	
					Statement st = con.createStatement();		
					
					String desQuery = "UPDATE passengers SET payment = payment + ? WHERE id = ?";
					PreparedStatement ps = con.prepareStatement(desQuery);
					String selectedCellValue = (String) tblHistory.getValueAt(tblHistory.getSelectedRow(), 0);
					
					String newPay = Payment.getText();
					
					if(newPay.isBlank()) {
						JOptionPane.showMessageDialog(null, "Please enter payment.");
					}else {
						if(Double.parseDouble(newPay) > Double.parseDouble(passBalance.getText())) {
							JOptionPane.showMessageDialog(null, "Payment should not exceed balance.");
						}else {
							ps.setDouble(1, Double.parseDouble(Payment.getText()));
							ps.setString(2, selectedCellValue);
							btnUpdateDetails.setEnabled(false);
							ps.executeUpdate();	
							JOptionPane.showMessageDialog(null, "Payment Received!");
						}
					}
						
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh.setBounds(34, 511, 129, 37);
		History.add(btnRefresh);	
		refreshTable();

		btnCancel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				passName.setText("");
				contactNum.setText("");
				EmailAdd.setText("");
				ticket.setText("");
				passAmount.setText("");
				totalPay.setText("0.0");
				passBalance.setText("");

				btnCancel.setEnabled(false);
				btnUpdateDetails.setEnabled(false);
				
				firstName.setText("");
				firstName.setEditable(true);
				
				lastName.setText("");
				lastName.setEditable(true);
				
				Contact.setText("");
				Contact.setEditable(true);
				
				Email.setText("");
				Email.setEditable(true);
				
				Passengers.setText("");
				Passengers.setEditable(true);
				
				DiscPassengers.setText("");
				DiscPassengers.setEditable(true);
				
				Payment.setText("");
				Payment.setEditable(true);
				City.setEnabled(true);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}
	
	
	
	public void refreshTable() {
		DefaultTableModel model = (DefaultTableModel)tblHistory.getModel();
		model.setRowCount(0);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","");	
			Statement st = con.createStatement();
			String query = "SELECT id, CONCAT(fname, ' ', lname) AS name, tickets FROM passengers";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i = 0; i<cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			String id, name, tickets;
			
			while(rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				tickets = rs.getString(3);
				String[] row = {id, name, tickets};
				
				model.addRow(row);
			}
			st.close();
			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
