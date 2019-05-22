package application;
	
import java.util.Base64;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(10,10,10,10));
			Scene scene = new Scene(grid,350,100);
			Label etiqueta = new Label("Palabra :");
			grid.add(etiqueta, 0, 1);
			TextField palabra = new TextField("");
			grid.add(palabra, 1, 1);
			Button btn = new Button("Encriptar");
			Button btn1 = new Button("Desencriptar");
			grid.add(btn, 2, 1);
			grid.add(btn1, 2, 2);
			Label resultado = new Label("palabra encriptada");
			grid.add(resultado, 1, 2);
			
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					byte[] palabra1 = palabra.getText().getBytes();
					String palabraEncriptata = Base64.getEncoder().encodeToString(palabra1);
					palabra.setText(palabraEncriptata);
				}
				
			});
			
			btn1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
				Base64.Decoder desencriptar = Base64.getDecoder();
				byte[] arreglo = desencriptar.decode(palabra.getText());
				String palabraDesencriptada = new String(arreglo);
					palabra.setText(palabraDesencriptada);
				}
				
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
