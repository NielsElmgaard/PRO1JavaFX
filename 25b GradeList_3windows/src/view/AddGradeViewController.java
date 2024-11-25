package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Grade;
import model.GradeListModel;

public class AddGradeViewController
{
  @FXML private TextField courseTextField;
  @FXML private TextField gradeTextField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private GradeListModel model;

  public AddGradeViewController()
  {

  }

  public void init(ViewHandler viewHandler, GradeListModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addGradeSubmitButton()
  {
    try
    {
      int grade = Integer.parseInt(gradeTextField.getText());
      String course = courseTextField.getText();
      model.addGrade(new Grade(grade, course));
      viewHandler.openView("list");
    }
    catch (Exception e)
    {
      errorLabel.setText("Not a legal grade!");
    }
  }

  @FXML private void addGradeCancelButton()
  {
    viewHandler.openView("list");
  }
}
