package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

@SuppressWarnings("restriction")
public class RegisteredController implements Initializable{
	
	@FXML
	private Label LabelRegistered;
	@FXML
	private Text TextDepartmentName;
	@FXML
	private Text TextDoctorName;
	@FXML
	private Text TextHZLB;
	@FXML
	private Text TextJKJE;
	@FXML
	private Text TextZLJE;
	@FXML
	private Text TextHZMC;
	@FXML
	private Text TextYJJE;
	@FXML
	private Text TextGHHM;
	@FXML
	private Button ButtonConfirm;
	@FXML
	private Button ButtonClear;
	@FXML
	private Button ButtonExit;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		FXRobotHelper.getStages().get(0).setTitle("นาบล");
	}

}
