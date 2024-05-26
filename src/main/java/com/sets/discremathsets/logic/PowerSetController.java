package com.sets.discremathsets.logic;

import com.sets.discremathsets.domain.Set;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.util.HashSet;

public class PowerSetController {
    public TextField powerSetTextField;
    public Button resultsButton;
    public Label resultsLabel;
    public Label subsetNumberLabel;

    private HashSet<String> getSetFromTextField(TextField setField) {
        if (setField.getText().isEmpty()) {
            return new HashSet<>();
        }

        String[] elements = setField.getText().split(",");
        HashSet<String> set = new HashSet<>();

        // Remove any leading or trailing whitespaces from the elements
        for (String element : elements) {
            set.add(element.trim());
        }

        return set;
    }

    @FXML
    protected void onResultsButtonClick() {
        Set setA = new Set(getSetFromTextField(powerSetTextField));
        int numberOfSubsets = (int) Math.pow(2, setA.size());
        subsetNumberLabel.setText("Total subsets: " + numberOfSubsets);

        // Change font size depending on number of subsets
        if (numberOfSubsets <= 32) {
            resultsLabel.setFont(new Font(20.0));
        } else if (numberOfSubsets <= 128) {
            resultsLabel.setFont(new Font(12.0));
        } else if (numberOfSubsets <= 256) {
            resultsLabel.setFont(new Font(10.0));
        } else {
            resultsLabel.setFont(new Font(5.0));
        }

        resultsLabel.setText(String.valueOf(setA.powerSet()));
    }
}
