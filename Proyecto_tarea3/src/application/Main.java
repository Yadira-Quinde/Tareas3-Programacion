package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("DatePicker and ColorPicker Example");

        // Crear los controles
        Label dateLabel = new Label("Selecciona una fecha:");
        DatePicker datePicker = new DatePicker();

        Label colorLabel = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker();

        Button confirmButton = new Button("Confirmar");

        Text selectedDateText = new Text();
        Text selectedColorText = new Text();

        // Acción del botón
        confirmButton.setOnAction(e -> {
            LocalDate selectedDate = datePicker.getValue();
            Color selectedColor = colorPicker.getValue();

            if (selectedDate != null && selectedColor != null) {
                String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                selectedDateText.setText("Día seleccionado: " + formattedDate);

                String colorName = getColorName(selectedColor);
                selectedColorText.setText("Color seleccionado: " + colorName);
            } else {
                selectedDateText.setText("Por favor selecciona una fecha y un color.");
                selectedColorText.setText("");
            }
        });

        // Disposición vertical (VBox)
        VBox vbox = new VBox(10, dateLabel, datePicker, colorLabel, colorPicker, confirmButton, selectedDateText, selectedColorText);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 10;");

        // Crear la escena
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para obtener el nombre del color
    private String getColorName(Color color) {
        if (color.equals(Color.RED)) return "Rojo";
        else if (color.equals(Color.GREEN)) return "Verde";
        else if (color.equals(Color.BLUE)) return "Azul";
        else if (color.equals(Color.YELLOW)) return "Amarillo";
        else if (color.equals(Color.BLACK)) return "Negro";
        else if (color.equals(Color.WHITE)) return "Blanco";
        else if (color.equals(Color.PURPLE)) return "Púrpura";
        else if (color.equals(Color.ORANGE)) return "Naranja";
        else if (color.equals(Color.PINK)) return "Rosa";
        else if (color.equals(Color.BROWN)) return "Marrón";
        else return "Otro color";
    }

    public static void main(String[] args) {
        launch(args);
    }
}

