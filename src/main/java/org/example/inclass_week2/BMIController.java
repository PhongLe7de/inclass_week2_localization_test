package org.example.inclass_week2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class BMIController {

    private double resultBMI;
    private ResourceBundle resources;
    private Locale currentLocale;


    private Map<String, String> localizedStrings;
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
        currentLocale = locale;
        lblResult.setText("");
        localizedStrings = LocalizationService.getLocalizedStrings(locale);
        lblWeignt.setText(localizedStrings.getOrDefault("weight", "Weight"));
        lblHeight.setText(localizedStrings.getOrDefault("height", "Height"));
        btnCalculate.setText(localizedStrings.getOrDefault("calculate", "Calculate"));
    }

    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText()) / 100.0;
            double bmi = weight / (height * height);
            DecimalFormat df = new DecimalFormat("#0.00");
            lblResult.setText(localizedStrings.getOrDefault("result", "Your BMI is") + " " + df.format(bmi));
            // Save to database
            String language = currentLocale.getLanguage();
            BMIResultService.saveResult(weight, height * 100, bmi, language);
        } catch (NumberFormatException e) {
            lblResult.setText(localizedStrings.getOrDefault("invalid", "Invalid input"));
        }
    }
}
