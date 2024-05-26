package com.sets.discremathsets.logic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LearnSetOperationsController {
    public Label titleLabel;
    public Label notationLabel;
    public Label descriptionLabel;
    public Label exampleOneLabel;
    public Label exampleTwoLabel;
    public Label exampleThreeLabel;


    // TODO Set Operations Definition
    @FXML
    protected void onSetOperationsClick() {
        titleLabel.setText("Set Operations");
        notationLabel.setOpacity(0);
        descriptionLabel.setText("Set operations can be defined as the operations that are performed on two or more sets to obtain a single set containing a combination of elements from both all the sets being operated upon.");
        exampleOneLabel.setText("Union of Sets");
        exampleTwoLabel.setText("Intersection of Sets");
        exampleThreeLabel.setText("Difference of Sets");
    }

    @FXML
    protected void onComplementClick() {
        titleLabel.setText("Set Complement");
        notationLabel.setOpacity(1);
        notationLabel.setText("A'");
        descriptionLabel.setText("The complement of set A is the set of elements in the universal set which are not in set A. That is, the set of all elements in the universal set outside of set A.");
        exampleOneLabel.setText("U = {1, 2, 3, 4, 5}");
        exampleTwoLabel.setText("A = {1, 3, 5}");
        exampleThreeLabel.setText("A' = {2, 4}");
    }


    @FXML
    protected void onUnionClick() {
        titleLabel.setText("Set Union");
        notationLabel.setOpacity(1);
        notationLabel.setText("A ∪ B");
        descriptionLabel.setText("The union of the sets A and B is the set of elements that belong to A or to B or both, that is, it is the set made up combining all the elements of set A with all the elements of set B.");
        exampleOneLabel.setText("A = {1, 2, 3}");
        exampleTwoLabel.setText("B = {3, 4, 5}");
        exampleThreeLabel.setText("A ∪ B = {1, 2, 3, 4, 5}");
    }

    @FXML
    protected void onIntersectionClick() {
        titleLabel.setText("Set Intersection");
        notationLabel.setOpacity(1);
        notationLabel.setText("A ∩ B");
        descriptionLabel.setText("The intersection of the sets A and B is the set of all elements which belong to both A and B, that is, the set made up of the elements common to A and B.");
        exampleOneLabel.setText("A = {1, 2, 3, 4, 5}");
        exampleTwoLabel.setText("B = {4, 5, 6, 7, 8}");
        exampleThreeLabel.setText("A ∩ B = {4, 5}");
    }

    @FXML
    protected void onDifferenceClick() {
        titleLabel.setText("Set Difference");
        notationLabel.setOpacity(1);
        notationLabel.setText("A - B");
        descriptionLabel.setText("The difference of set A minus set B is the set of elements which belong to A but which do not belong to B, that is, the set made up of the elements of A except those that can be found in B as well.");
        exampleOneLabel.setText("A = {1, 2, 3, 4, 5}");
        exampleTwoLabel.setText("B = {2, 4}");
        exampleThreeLabel.setText("A - B = {1, 3, 5}");
    }
}
