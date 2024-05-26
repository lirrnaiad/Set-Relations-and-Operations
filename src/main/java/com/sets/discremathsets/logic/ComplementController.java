package com.sets.discremathsets.logic;

import com.sets.discremathsets.domain.Set;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashSet;

public class ComplementController {
    public TextField universalSetTextField;

    public TextField setATextField;
    public Button getComplementButton;
    public Label complementLabel;

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
    protected void onComplementButtonClicked() {
        Set universalSet = new Set(getSetFromTextField(universalSetTextField));
        Set toBeComplemented = new Set(getSetFromTextField(setATextField));

        complementLabel.setText(String.valueOf(new Set(toBeComplemented.complement(universalSet))));
    }
}
