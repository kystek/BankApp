package presentationLayer;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import dataLayer.Address;

public class AddressInformationWindow {

	private JFrame frame;
	private Container contentPane;
	
	private Dimension frameSize = new Dimension(250, 180);
	
	private JTextField streetTextField;
	private JTextField cityTextField;
	private JTextField postcodeTextField;
	
	private JButton acceptButton;
	private JButton cancelButton;
	
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel postcodeLabel;
	
	public AddressInformationWindow() {
		initialize();
		addComponentsToFrame();
	}

	public void show() {
		frame.setVisible(true);
	}
	
	public void show(Address address) {
		streetTextField.setText(address.getStreet());
		cityTextField.setText(address.getCity());
		postcodeTextField.setText(address.getPostcode());
		show();
	}
	
	public void addCancelButtonActionListener(ActionListener actionListener) {
		cancelButton.addActionListener(actionListener);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void addAcceptButtonActionListener(ActionListener actionListener) {
		acceptButton.addActionListener(actionListener);
	}
	
	public String getStreet() {
		return streetTextField.getText();
	}

	public String getCity() {
		return cityTextField.getText();
	}

	public String getPostcode() {
		return postcodeTextField.getText();
	}

	public void close() {
		frame.dispose();
	}
	
	private void initialize() {
		initializeFrame();
		initializeLabels();
		initializeTextFields();
		initializeButtons();
	}

	private void initializeFrame() {
		frame = new JFrame("Address");
		contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		frame.setSize(frameSize);
		centerFrame(frame);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initializeLabels() {
		cityLabel = new JLabel("City:");
		cityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelFont(cityLabel);
		
		streetLabel = new JLabel("Street:");
		streetLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelFont(streetLabel);
		
		postcodeLabel = new JLabel("Postcode:");
		postcodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		setLabelFont(postcodeLabel);
	}
	
	private void initializeTextFields() {
		streetTextField = new JTextField();
		cityTextField = new JTextField();
		postcodeTextField = new JTextField();
	}
	
	private void initializeButtons() {
		acceptButton = new JButton("Accept");
		cancelButton = new JButton("Cancel");
	}
	
	private void centerFrame(JFrame frame) {
		frame.setLocationRelativeTo(null);
	}
	
	private void setLabelFont(JLabel label) {
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	
	private void addComponentsToFrame() {
		setBounds();
		contentPane.add(streetTextField);
		contentPane.add(streetLabel);
		contentPane.add(cityTextField);
		contentPane.add(cityLabel);
		contentPane.add(postcodeTextField);
		contentPane.add(postcodeLabel);
		contentPane.add(acceptButton);
		contentPane.add(cancelButton);
	}

	private void setBounds() {
		streetLabel.setBounds(20, 14, 57, 14);
		cityLabel.setBounds(20, 45, 57, 14);
		postcodeLabel.setBounds(20, 76, 57, 14);
		
		streetTextField.setBounds(87, 11, 100, 20);
		cityTextField.setBounds(87, 42, 100, 20);
		postcodeTextField.setBounds(87, 73, 100, 20);
		
		acceptButton.setBounds(25, 115, 90, 23);
		cancelButton.setBounds(125, 115, 90, 23);
	}

	public void clear() {
		streetTextField.setText(null);
		cityTextField.setText(null);
		postcodeTextField.setText(null);
	}

}
