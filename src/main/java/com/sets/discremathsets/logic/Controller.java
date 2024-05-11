package com.sets.discremathsets.logic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.sets.discremathsets.domain.Set;

import java.util.Arrays;
import java.util.HashSet;

public class Controller {
    @FXML
    public TextField setAField;
    public TextField setBField;
    public Button resultsButton;
    public Button toggleButton;
    public Label setAOutput;
    public Label setBOutput;
    public Label isEqualOrUnionLabel;
    public Label isEquivalentOrUnionResultLabel;
    public Label isASubsetOfBOrIntersectionLabel;
    public Label isBSubsetOfAOrIntersectionResultLabel;
    public Label isDisjointOrDifferenceAMinusBLabel;
    public Label DifferenceAMinusBResultLabel;
    public Label DifferenceBMinusALabel;
    public Label DifferenceBMinusAResultLabel;


    private HashSet<String> getSetFromTextField(TextField setField) {
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
        // Create sets from the text field
        Set setA = new Set(getSetFromTextField(setAField));
        Set setB = new Set(getSetFromTextField(setBField));

        // Output text from text field
        setAOutput.setText(String.valueOf(setA));
        setBOutput.setText(String.valueOf(setB));

        if (resultsButton.getText().equals("Get Set Relations")) {
            // SET RELATIONS
            if (setA.isEqualTo(setB)) {
                isEqualOrUnionLabel.setText("Equal Sets: ✔");
            } else {
                isEqualOrUnionLabel.setText("Equal Sets: ✘");
            }

            if (setA.isEquivalentTo(setB)) {
                isEquivalentOrUnionResultLabel.setText("Equivalent Sets: ✔");
            } else {
                isEquivalentOrUnionResultLabel.setText("Equivalent Sets: ✘");
            }

            if (setA.isSubsetOf(setB)) {
                isASubsetOfBOrIntersectionLabel.setText("A is a subset of B: ✔");
            } else {
                isASubsetOfBOrIntersectionLabel.setText("A is a subset of B: ✘");
            }

            if (setB.isSubsetOf(setA)) {
                isBSubsetOfAOrIntersectionResultLabel.setText("B is a subset of A: ✔");
            } else {
                isBSubsetOfAOrIntersectionResultLabel.setText("B is a subset of A: ✘");
            }

            if (setA.isDisjoint(setB)) {
                isDisjointOrDifferenceAMinusBLabel.setText("Disjoint Sets: ✔");
            } else {
                isDisjointOrDifferenceAMinusBLabel.setText("Disjoint Sets: ✘");
            }
        } else {
            // SET OPERATIONS
            Set setUnion = new Set(setA.union(setB));
            Set setIntersection = new Set(setA.intersection(setB));
            Set setDifferenceAMinusB = new Set(setA.difference(setB));
            Set setDifferenceBMinusA = new Set(setB.difference(setA));

            if (setUnion.isEmpty()) {
                isEquivalentOrUnionResultLabel.setText("∅");
            } else {
                isEquivalentOrUnionResultLabel.setText("= " + setUnion);
            }

            if (setIntersection.isEmpty()) {
                isBSubsetOfAOrIntersectionResultLabel.setText("∅");
            } else {
                isBSubsetOfAOrIntersectionResultLabel.setText("= " + setIntersection);
            }

            if (setDifferenceAMinusB.isEmpty()) {
                DifferenceAMinusBResultLabel.setText("∅");
            } else {
                DifferenceAMinusBResultLabel.setText("= " + setDifferenceAMinusB);
            }

            if (setDifferenceBMinusA.isEmpty()) {
                DifferenceBMinusAResultLabel.setText("∅");
            } else {
                DifferenceBMinusAResultLabel.setText("= " + setDifferenceBMinusA);
            }
        }
    }

    // Toggle between Set Relations and Set Operations
    @FXML
    protected void onToggleButtonClick() {
        if (resultsButton.getText().equals("Get Set Relations")) {
            resultsButton.setText("Get Set Operations");
            toggleButton.setText("Switch to Set Relations");

            isEqualOrUnionLabel.setText("A Union B");
            isEquivalentOrUnionResultLabel.setText("= ∅");
            isASubsetOfBOrIntersectionLabel.setText("A Intersection B");
            isBSubsetOfAOrIntersectionResultLabel.setText(" = ∅");
            isDisjointOrDifferenceAMinusBLabel.setText("A Minus B");

            DifferenceAMinusBResultLabel.setVisible(true);
            DifferenceBMinusALabel.setVisible(true);
            DifferenceBMinusAResultLabel.setVisible(true);

        } else {
            resultsButton.setText("Get Set Relations");
            toggleButton.setText("Switch to Set Operations");

            isEqualOrUnionLabel.setText("Equal Sets: ✘");
            isEquivalentOrUnionResultLabel.setText("Equivalent Sets: ✘");
            isASubsetOfBOrIntersectionLabel.setText("A is a subset of B: ✘");
            isBSubsetOfAOrIntersectionResultLabel.setText("B is a subset of A: ✘");
            isDisjointOrDifferenceAMinusBLabel.setText("Disjoint Sets: ✘");

            DifferenceAMinusBResultLabel.setVisible(false);
            DifferenceBMinusALabel.setVisible(false);
            DifferenceBMinusAResultLabel.setVisible(false);
        }
    }
}