package com.sets.discremathsets.logic;

import com.sets.discremathsets.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import com.sets.discremathsets.domain.Set;
import javafx.stage.Stage;

import java.io.IOException;
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
    public CheckBox notationToggle;
    public Button powerSetOrComplementButton;
    public MenuItem learnSet;
    public MenuItem learnSetRelations;
    public MenuItem learnSetOperations;
    public MenuItem helpUsage;
    public MenuItem helpAbout;
    public MenuItem helpCredits;


    // Instance variable to check whether current mode is set relations or not. True by default
    private boolean modeIsSetRelations = true;

    // Instance variables to check the set relations of the two current sets. False by default.
    private boolean notationToggled = false;
    private boolean setsAreEqual = false;
    private boolean setsAreEquivalent = false;
    private boolean setAIsSubsetOfB = false;
    private boolean setBIsSubsetOfA = false;
    private boolean setsAreDisjoint = false;

    // Get set from the text field
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

    // Updates labels of set relations depending on whether notation is toggled
    private void updateSetRelations() {
        if (!notationToggled) {
            if (setsAreEqual) {
                isEqualOrUnionLabel.setText("Equal Sets: ✔");
            } else {
                isEqualOrUnionLabel.setText("Equal Sets: ✘");
            }

            if (setsAreEquivalent) {
                isEquivalentOrUnionResultLabel.setText("Equivalent Sets: ✔");
            } else {
                isEquivalentOrUnionResultLabel.setText("Equivalent Sets: ✘");
            }

            if (setAIsSubsetOfB) {
                isASubsetOfBOrIntersectionLabel.setText("A is a subset of B: ✔");
            } else {
                isASubsetOfBOrIntersectionLabel.setText("A is a subset of B: ✘");
            }

            if (setBIsSubsetOfA) {
                isBSubsetOfAOrIntersectionResultLabel.setText("B is a subset of A: ✔");
            } else {
                isBSubsetOfAOrIntersectionResultLabel.setText("B is a subset of A: ✘");
            }

            if (setsAreDisjoint) {
                isDisjointOrDifferenceAMinusBLabel.setText("Disjoint Sets: ✔");
            } else {
                isDisjointOrDifferenceAMinusBLabel.setText("Disjoint Sets: ✘");
            }
        } else {
            if (setsAreEqual) {
                isEqualOrUnionLabel.setText("A = B");
            } else {
                isEqualOrUnionLabel.setText("A ≠ B");
            }

            if (setsAreEquivalent) {
                isEquivalentOrUnionResultLabel.setText("A ≈ B");
            } else {
                isEquivalentOrUnionResultLabel.setText("A ≉ B");
            }

            if (setAIsSubsetOfB) {
                isASubsetOfBOrIntersectionLabel.setText("A ⊂ B");
            } else {
                isASubsetOfBOrIntersectionLabel.setText("A ⊄ B");
            }

            if (setBIsSubsetOfA) {
                isBSubsetOfAOrIntersectionResultLabel.setText("B ⊂ A");
            } else {
                isBSubsetOfAOrIntersectionResultLabel.setText("B ⊄ A");
            }

            if (setsAreDisjoint) {
                isDisjointOrDifferenceAMinusBLabel.setText("A ∩ B = ∅");
            } else {
                isDisjointOrDifferenceAMinusBLabel.setText("A ∩ B ≠ ∅");
            }
        }
    }

    // Updates labels of set operations depending on whether notation is toggled
    private void updateSetOperations() {
        if (!notationToggled) {
            isEqualOrUnionLabel.setText("A Union B");
            isASubsetOfBOrIntersectionLabel.setText("A Intersection B");
            isDisjointOrDifferenceAMinusBLabel.setText("A Minus B");
            DifferenceBMinusALabel.setText("B Minus A");
        } else {
            isEqualOrUnionLabel.setText("A ∪ B");
            isASubsetOfBOrIntersectionLabel.setText("A ∩ B");
            isDisjointOrDifferenceAMinusBLabel.setText("A - B");
            DifferenceBMinusALabel.setText("B - A");
        }
    }

    // Runs when "Get Set Relations" or "Get Set Operations" button is clicked
    @FXML
    protected void onResultsButtonClick() {
        // Create sets from the text field
        Set setA = new Set(getSetFromTextField(setAField));
        Set setB = new Set(getSetFromTextField(setBField));

        // Output text from text field
        if (setA.isEmpty()) {
            setAOutput.setText("∅");
        } else {
            setAOutput.setText(String.valueOf(setA));
        }

        if (setB.isEmpty()) {
            setBOutput.setText("∅");
        } else {
            setBOutput.setText(String.valueOf(setB));
        }

        if (modeIsSetRelations) {
            // SET RELATIONS
            setsAreEqual = setA.isEqualTo(setB);
            setsAreEquivalent = setA.isEquivalentTo(setB);
            setAIsSubsetOfB = setA.isSubsetOf(setB);
            setBIsSubsetOfA = setB.isSubsetOf(setA);
            setsAreDisjoint = setA.isDisjoint(setB);
            updateSetRelations();
        } else {
            // SET OPERATIONS
            updateSetOperations();
            Set setUnion = new Set(setA.union(setB));
            Set setIntersection = new Set(setA.intersection(setB));
            Set setDifferenceAMinusB = new Set(setA.difference(setB));
            Set setDifferenceBMinusA = new Set(setB.difference(setA));

            if (setUnion.isEmpty()) {
                isEquivalentOrUnionResultLabel.setText("= ∅");
            } else {
                isEquivalentOrUnionResultLabel.setText("= " + setUnion);
            }

            if (setIntersection.isEmpty()) {
                isBSubsetOfAOrIntersectionResultLabel.setText("= ∅");
            } else {
                isBSubsetOfAOrIntersectionResultLabel.setText("= " + setIntersection);
            }

            if (setDifferenceAMinusB.isEmpty()) {
                DifferenceAMinusBResultLabel.setText("= ∅");
            } else {
                DifferenceAMinusBResultLabel.setText("= " + setDifferenceAMinusB);
            }

            if (setDifferenceBMinusA.isEmpty()) {
                DifferenceBMinusAResultLabel.setText("= ∅");
            } else {
                DifferenceBMinusAResultLabel.setText("= " + setDifferenceBMinusA);
            }
        }
    }

    // Toggles between Set Relations and Set Operations
    @FXML
    protected void onToggleButtonClick() {
        if (modeIsSetRelations) {
            modeIsSetRelations = false;
            resultsButton.setText("Get Set Operations");
            toggleButton.setText("Switch to Set Relations");
            powerSetOrComplementButton.setText("Complement");

            onResultsButtonClick();

            DifferenceAMinusBResultLabel.setVisible(true);
            DifferenceBMinusALabel.setVisible(true);
            DifferenceBMinusAResultLabel.setVisible(true);

        } else {
            modeIsSetRelations = true;
            resultsButton.setText("Get Set Relations");
            toggleButton.setText("Switch to Set Operations");
            powerSetOrComplementButton.setText("Power Set");

            onResultsButtonClick();

            DifferenceAMinusBResultLabel.setVisible(false);
            DifferenceBMinusALabel.setVisible(false);
            DifferenceBMinusAResultLabel.setVisible(false);
        }
    }

    // Toggle between words and notation
    @FXML
    protected void onNotationToggle() {
        notationToggled = notationToggle.isSelected();

        if (modeIsSetRelations) {
            updateSetRelations();
        } else {
            updateSetOperations();
        }
    }

    // Power Set or Complement Windows
    @FXML
    protected void calculatePowerSetOrComplement() {
        if (powerSetOrComplementButton.getText().equals("Power Set")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("powerset-window.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Power Set");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to open new window: " + e.getMessage());
            }
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("complement-window.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Complement");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to open new window: " + e.getMessage());
            }
        }
    }

    // Menu Items
    @FXML
    protected void onLearnSetClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("learn-set.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Set Definition");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to open new window: " + e.getMessage());
        }
    }

    @FXML
    protected void onLearnSetRelationsClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("learn-set-relations.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("Set Relations");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to open new window: " + e.getMessage());
        }
    }

    @FXML
    protected void onLearnSetOperationsClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("learn-set-operations.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("Set Operations");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to open new window: " + e.getMessage());
        }
    }
}