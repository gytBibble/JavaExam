package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

@SuppressWarnings("restriction")
public class LoginSceneController {
	private String ComboBoxValueSelect = "";
	@FXML
	private Button ButtonLogin;
	@FXML
	private Button ButtonClear;
	@FXML
	private Button ButtonExit;
	@FXML
	private TextField TextFieldUserName;
	@FXML
	private TextField TextFieldPassword;
	@FXML
	private Text txt_1;
	@FXML
	private Text txt_2;
	@FXML
	private Text txt_3;
	@FXML
	private Text txt_4;
	@FXML
	private ComboBox<String> ComboBoxLogin;
	
	// Event Listener on Button[#ButtonLogin].onAction
	@FXML
	public void loginEvent() throws ClassNotFoundException, IOException {
		System.out.println("The login button is clicked");
		String usernameText = TextFieldUserName.getText();
		String passwordText = TextFieldPassword.getText();
		System.out.println("username: " + usernameText);
		System.out.println("password: " + passwordText);
		
		
		if(ComboBoxValueSelect.equals("")) {
			JOptionPane.showMessageDialog(null, "��ѡ���½���");
			return;
		}
		//If username or password input is null
		if(usernameText.equals("")) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ��������û���");
			return;
		}
		if(passwordText.equals("")) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�����������");
			return;
		}
		
		/*set up connection */
		ResultSet result = null;
		if(ComboBoxValueSelect.equals("����")) {
			System.out.println("you are patient");
			result = connectToMySQL.getInstance().getPatientInfo(usernameText.trim());
			if(result == null) {
				JOptionPane.showMessageDialog(null, "��ȡ���ݿ����");
				return;
			}else {
				try {
					if(!result.next()) {
						JOptionPane.showMessageDialog(null, "�û�������");
						return;
					}else if(!result.getString("password").equals(passwordText)) {
						JOptionPane.showMessageDialog(null, "�������");
						return;
					}else {
						String patientName = result.getString("name");
						double patientBalance = result.getDouble("balance");
						String patientId = result.getString("pid");
						System.out.println("succeed to login : " + patientName + " " + patientId + ", you have " + patientBalance);
						connectToMySQL.getInstance().updatePatientLoginTime(patientId,
								LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
						Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Registered.fxml")));
						FXRobotHelper.getStages().get(0).setScene(scene);
					}					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(ComboBoxValueSelect.equals("ҽ��")){
			System.out.println("you are doctor");
			result = connectToMySQL.getInstance().getDoctorInfo(usernameText.trim());
			if(result == null) {
				JOptionPane.showMessageDialog(null, "��ȡ���ݿ����");
				return;
			}else {
				try {
					if(!result.next()) {
						JOptionPane.showMessageDialog(null, "�û�������");
						return;
					}else if (!result.getString("password").equals(passwordText)) {
						JOptionPane.showMessageDialog(null, "�������");
						return;
					}else {
						String doctorName = result.getString("name");
						String doctorId = result.getString("docid");
						System.out.println("succeed to login : " + doctorName + " " + doctorId);
						connectToMySQL.getInstance().updatePatientLoginTime(doctorId,
								LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
						Scene scene = new Scene(FXMLLoader.load(getClass().getResource("DoctorView.fxml")));
						FXRobotHelper.getStages().get(0).setScene(scene);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		/*go to the next scene*/
		
		/*close statement and connection*/
		
	}
	
	// Event Listener on Button[#ButtonClear].onAction
	@FXML
	public void clearEvent(ActionEvent event) {
		TextFieldUserName.clear();
		TextFieldPassword.clear();
	}
	
	
	@FXML
	public void ChooseEvent(ActionEvent event) {
		//ComboBoxLogin.getItems().addAll("����","ҽ��");
		ComboBoxValueSelect = ComboBoxLogin.getValue();
	}
	
	@FXML
	public void ExitEvent(ActionEvent event) {
		
	}
	
}
