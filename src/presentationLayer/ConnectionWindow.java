package presentationLayer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ConnectionWindow {

	private final String DEFAULT_LOGIN = "user";
	private final String DEFAULT_PASSWORD = "logitech1";
	
	private final Dimension FRAME_SIZE = new Dimension(330, 220);
	private final int TEXT_FIELD_NUMBER_OF_COLUMNS = 10;
	
	private JFrame frame;
	private Container frameContentPane;
	private JLabel infoLabel;
	private JLabel loginLabel, passwordLabel;
	private JFormattedTextField loginTextField;
	private JPasswordField passwordField;
	private JButton connectButton;

	public ConnectionWindow() {
		initialize();
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void close() {
		frame.setVisible(false);
	}
	
	public void addConnectButtonListener(ActionListener actionListener) {
		connectButton.addActionListener(actionListener);
	}
	
	public String getLogin() {
		return loginTextField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText(); //FIXME: maybe I will
	}
	
	public void displayMessageDialog(String title, String message) {
		JOptionPane.showMessageDialog(frame, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	private void initialize() {
		createFrame();
		createFrameLayout();
		createInfoLabel();
		createInputComponents();		
		createButtons();
		addComponentsToLayout();
	}

	private void createFrame() {
		frame = new JFrame("Bank App - Connect");
		frameContentPane = frame.getContentPane();
		frame.setSize(FRAME_SIZE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerFrame(frame);
	}
	
	private void centerFrame(JFrame frame) {
		frame.setLocationRelativeTo(null);
	}
	
	private void createFrameLayout() {
	}
	
	private void createInfoLabel() {
		infoLabel = new JLabel("Welcome! Log into MySql database.");
	}
	
	private void createInputComponents() {
		createLoginInputComponents();
		createPasswordInputComponents();
	}

	private void createLoginInputComponents() {
		loginLabel = new JLabel("Login: ");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));	
		
		loginTextField = new JFormattedTextField();
		loginTextField.setText(DEFAULT_LOGIN);
		loginTextField.setColumns(TEXT_FIELD_NUMBER_OF_COLUMNS);
	}
	
	private void createPasswordInputComponents() {
		passwordLabel = new JLabel("Password: ");		
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		passwordField = new JPasswordField();
		passwordField.setText(DEFAULT_PASSWORD);
		passwordField.setColumns(TEXT_FIELD_NUMBER_OF_COLUMNS);
	}

	private void createButtons() {
		connectButton = new JButton("Connect");
	}
	
	private void addComponentsToLayout() {
		setBounds();
		frame.getContentPane().setLayout(null);
		frameContentPane.add(infoLabel);
		frameContentPane.add(loginLabel);
		frameContentPane.add(loginTextField);
		frameContentPane.add(passwordLabel);
		frameContentPane.add(passwordField);
		frameContentPane.add(connectButton);
	}
	
	private void setBounds() {
		//auto-generated by Window Designer
		infoLabel.setBounds(65, 20, 220, 14);
		loginLabel.setBounds(85, 67, 32, 14);
		loginTextField.setBounds(120, 64, 86, 20);
		passwordLabel.setBounds(64, 93, 53, 14);
		passwordField.setBounds(120, 90, 86, 20);
		connectButton.setBounds(120, 135, 86, 23);
	}
	
}