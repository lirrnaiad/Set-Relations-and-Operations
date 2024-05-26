package com.sets.discremathsets.logic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LearnSetRelationsController {
    public Label titleLabel;
    public Label notationLabel;
    public Label descriptionLabel;
    public Label exampleOneLabel;
    public Label exampleTwoLabel;
    public Label exampleThreeLabel;

    @FXML
    protected void onSetRelationsClick() {
        titleLabel.setText("Set Relations");
        notationLabel.setOpacity(0);
        descriptionLabel.setText("Sets can be related to one another in a number of ways. They can be completely different, have some elements in common, be exactly the same, have the same number of elements, or one set can be part of another.");
        exampleOneLabel.setText("Equal Sets");
        exampleTwoLabel.setText("Equivalent Sets");
        exampleThreeLabel.setText("Disjoint Sets");
    }

    @FXML
    protected void onEqualSetsClick() {
        titleLabel.setText("Equal Sets");
        notationLabel.setOpacity(1);
        notationLabel.setText("A = B");
        descriptionLabel.setText("Two sets A and B are equal (A = B) if and only if every element of set A is an element of set B is an element of set A. That is, two sets have exactly the same elements. If two sets A and B are not equal, we write A ≠ B.");
        exampleOneLabel.setText("{1, 3, 5, 7} = {1, 3, 5, 7}");
        exampleTwoLabel.setText("{2, 2, 4, 6, 8} = {2, 4, 4, 6, 8}");
        exampleThreeLabel.setText("{1, 5, 7} ≠ {1, 3, 7}");
    }

    @FXML
    protected void onEquivalentSetsClick() {
        titleLabel.setText("Equivalent Sets");
        notationLabel.setOpacity(1);
        notationLabel.setText("A ≈ B");
        descriptionLabel.setText("Two sets A and B are equivalent (A ≈ B) if and only if for each element in A there is exactly one element in B and for each element in B there is exactly one element in A. If two sets A and B are not equivalent, we write A ≉ B.");
        exampleOneLabel.setText("{2, 9, 4, 6} ≈ {3, 7, 1, 5}");
        exampleTwoLabel.setText("{1, 2, 3, 4, 5} ≈ {6, 7, 8, 9, 10}");
        exampleThreeLabel.setText("{1, 5, 7} ≉ {1, 3, 7, 4}");
    }

    @FXML
    protected void onSubsetsClick() {
        titleLabel.setText("Subsets");
        notationLabel.setOpacity(1);
        notationLabel.setText("A ⊂ B");
        descriptionLabel.setText("Set A is a subset of B if and only if each element of set A is an element of set B. That is, if x ∈ A, then x ∈ B. To indicate that A is a subset of B, we write A ⊂ B. This is read as 'A is a subset of B'. The negation of this idea, or 'A is not a subset of B' is written as A ⊄ B. From this definition, we see that every set is a subset of itself, that is for any set A, we have A ⊂ A.");
        exampleOneLabel.setText("{1, 2, 4} ⊂ {1, 2, 3, 4, 5}");
        exampleTwoLabel.setText("{a, b, c} ⊂ {a, b, c}");
        exampleThreeLabel.setText("{1, 3, 5} ⊄ {1, 2, 3, 4}");
    }

    @FXML
    protected void onDisjointSetsClick() {
        titleLabel.setText("Disjoint Sets");
        notationLabel.setOpacity(1);
        notationLabel.setText("A ∩ B = ∅");
        descriptionLabel.setText("Two sets A and B are disjoint if and only if no element of set A is an element of set B and no element of set B is an element of set A; that is, sets A and B have no elements in common.");
        exampleOneLabel.setText("{1, 3, 5} and {2, 4, 6} are disjoint.");
        exampleTwoLabel.setText("{a, b, c} and {A, B, C} are disjoint.");
        exampleThreeLabel.setText("{1, 2, 4} and {2, 4, 5} are not disjoint.");
    }

    @FXML
    protected void onUniversalSetClick() {
        titleLabel.setText("Universal Set");
        notationLabel.setOpacity(1);
        notationLabel.setText("U");
        descriptionLabel.setText("The universal set, denoted by U is the set containing all the elements under discussion. All the sets under consideration are subsets of the universal set U.");
        exampleOneLabel.setText("U = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}");
        exampleTwoLabel.setText("U = {a, b, c, ..., z}");
        exampleThreeLabel.setText("U = {x|x is a student in UEP}");
    }

    @FXML
    protected void onEmptySetClick() {
        titleLabel.setText("Empty Set");
        notationLabel.setOpacity(1);
        notationLabel.setText("{} or ∅");
        descriptionLabel.setText("The null or empty set denoted by ∅ or {} is the set containing no elements.");
        exampleOneLabel.setText("{}");
        exampleTwoLabel.setText("∅");
        exampleThreeLabel.setText("");
    }

    @FXML
    protected void onPowerSetClick() {
        titleLabel.setText("Power Set");
        notationLabel.setOpacity(1);
        notationLabel.setText("P(A)");
        descriptionLabel.setText("By the power set of a given set A, we mean the set of all possible subsets of Set A. If set A contain n number of elements, then 2^n number of subsets of A.");
        exampleOneLabel.setText("A = {a, b, c}");
        exampleTwoLabel.setText("P(A) =");
        exampleThreeLabel.setText("{{}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c}}");
    }
}
