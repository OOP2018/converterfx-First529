package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {

	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	ComboBox<Length> unitbox1;
	@FXML
	ComboBox<Length> unitbox2;

	public void handleConvert(ActionEvent event) {

		String text1 = textfield1.getText().trim();
		Length unit1 = unitbox1.getValue();
		String text2 = textfield2.getText().trim();
		Length unit2 = unitbox2.getValue();

		double t;
		double meter;

		if (text2.isEmpty()) {
			try {
				meter = unit1.getValue() / unit2.getValue();
				t = Double.parseDouble(text1) * meter;
				textfield2.setText(String.format("%.4g", t));
			} catch (NumberFormatException ex) {
				textfield2.setText("Invalid input");
				textfield2.setStyle("-fx-text-fill: red;");
			}
		} else if (text1.isEmpty()) {
			try {
				meter = unit2.getValue() / unit1.getValue();
				t = Double.parseDouble(text2) * meter;
				textfield1.setText(String.format("%.4g", t));
			} catch (NumberFormatException ex) {
				textfield1.setText("Invalid input");
				textfield1.setStyle("-fx-text-fill: red;");
			}
		}

	}

	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
		textfield1.setStyle("-fx-text-fill: black;");
		textfield2.setStyle("-fx-text-fill: black;");
	}

	@FXML
	public void initialize() {

		if (unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1); // select an item to show
		}
	}

}
