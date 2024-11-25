package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.GradeListModel;


public class DetailsViewController
{
  @FXML private TextField countField;
  @FXML private TextField maxField;
  @FXML private TextField minField;
  @FXML private TextField averageField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private GradeListModel model;

  public DetailsViewController(){

  }

  public void init(ViewHandler viewHandler, GradeListModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    countField.setText(String.valueOf(model.gradeListSize()));
    maxField.setText(String.valueOf(model.getMaxGrade()));
    minField.setText(String.valueOf(model.getMinGrade()));
    averageField.setText(String.valueOf(model.getAverageGrade()));
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  @FXML void backButtonPressed(){
    viewHandler.openView("list");
  }
}
