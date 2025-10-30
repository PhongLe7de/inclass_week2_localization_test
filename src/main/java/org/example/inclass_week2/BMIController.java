package org.example.inclass_week2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class BMIController {

    private double resultBMI;
    private ResourceBundle resources;
    @FXML
    private Label lblWeignt;

    @FXML
    private TextField tfWeight;

    @FXML
    private Label lblHeight;

    @FXML
    private TextField tfHeight;

    @FXML
    private Label lblResult;

    @FXML
    private Label lbLocalTime;

    @FXML
    public Button btnCalculate;

    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public Button button3;

    @FXML
    public Button button4;


    public void onCalculateClick() {
        try {
            double w = Double.parseDouble(tfWeight.getText());
            double h = Double.parseDouble(tfHeight.getText()) / 100;
            resultBMI = w / (h * h);
        } catch (Exception e) {
            lblResult.setText(resources.getString("lblInvalidInput.text"));
            return;
        }

    }

    public void onENClick() {
        loadLanguage(new Locale("en", "US"));
    }

    public void onFRClick() {
        loadLanguage(new Locale("fr", "FR"));
    }

    public void onURClick() {
        loadLanguage(new Locale("ur", "PA"));
    }

    public void onVNClick() {
        loadLanguage(new Locale("vi", "VI"));
    }


    public void initialize() {
        loadLanguage(new Locale("en", "US"));
    }

    private void loadLanguage(Locale locale) {
        resources = ResourceBundle.getBundle("messages", locale);
        lblWeignt.setText(resources.getString("lblWeignt.text"));
        lblHeight.setText(resources.getString("lblHeight.text"));
        if (resultBMI != 0) lblResult.setText(resources.getString("lblResult.text") + String.format(" %.2f", resultBMI));
        lbLocalTime.setText(resources.getString("lbLocalTime.text"));

        btnCalculate.setText(resources.getString("btnCalculate.text"));

        button1.setText(resources.getString("button1.text"));
        button2.setText(resources.getString("button2.text"));
        button3.setText(resources.getString("button3.text"));
        button4.setText(resources.getString("button4.text"));
    }
}
