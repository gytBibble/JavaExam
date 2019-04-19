package application;
	
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
//import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			connectToMySQL.getInstance().connectDataBase("java", "javajava");
			Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);//���ܸı䴰�ڴ�С
			primaryStage.setTitle("login");//���ñ���
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


