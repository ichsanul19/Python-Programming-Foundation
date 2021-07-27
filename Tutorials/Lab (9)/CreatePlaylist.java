
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class CreatePlaylist extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gp = new GridPane(); //Membuat Pane
        gp.setAlignment(Pos.CENTER); 
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));

        // membuat greetings text dan icon
        FileInputStream fis = new FileInputStream("note.jpg"); //directory gambar
        Image img = new Image(fis, 50 , 50, false, false); //set image 50 x 50 
        ImageView iv = new ImageView(img);	//membuat node gambar
        
        // membuat pane HBox
        HBox greetings = new HBox(); 
        greetings.setAlignment(Pos.CENTER); 
        greetings.setSpacing(10);
        greetings.getChildren().add(iv);
        greetings.setCenterShape(true);
        
        //membuat node shape 
        Text hello = new Text();
        hello.setFont(new Font("tahoma", 14)); // set font
        hello.setText("Hello, Dek Depe!"); // set text
        
        greetings.getChildren().add(hello); //menambahkan text ke HBox greetings
        
        //menambahkan HBox greetings ke GridPane
        gp.add(greetings, 0, 0, 2, 1);
        
        //membuat label dan text field playlist
        gp.add(new Label("Playlist name:"), 0, 1); // baris 1 kolom 0
        TextField playlistNameField = new TextField();
        gp.add(playlistNameField, 1, 1); // baris 1 kolom 1  

        //membuat label dan text field lagu
        gp.add(new Label("Song title:"), 0, 2);
        TextField songNameField = new TextField();
        gp.add(songNameField, 1, 2);

        //membuat label dan choice box genre
        gp.add(new Label("Genre:"), 0, 3);
        String[] genre = {"Rock", "Jazz", "Pop"};
        ChoiceBox genreCB = new ChoiceBox(FXCollections.observableArrayList(genre));
        gp.add(genreCB, 1, 3); 

        //membuat label dan text field artist
        gp.add(new Label("Artist name:"), 0, 4);
        TextField artistNameField = new TextField();
        gp.add(artistNameField, 1, 4);

        //membuat button
        Button btn = new Button("Add to Playlist"); 
        gp.add(btn, 1,5);

        //membuat notifikasi
        btn.setOnAction(event -> {
            primaryStage.setTitle("Java Music | Succesfully added!");
            playlistNameField.clear();
            songNameField.clear();
            genreCB.getItems().clear();
            artistNameField.clear();
        });

        //Stage utama
        
        //menampung GridPane ke Scene
        Scene createPlaylist = new Scene(gp, 350, 380); // setSize windows lebar, tinggi 
        primaryStage.setTitle("Java Music"); 
        primaryStage.setScene(createPlaylist);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    //run aplikasi
    public static void main(String[] args) {
        launch(args);
    }
}

