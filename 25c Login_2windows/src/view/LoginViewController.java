package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.LoginModel;

public class LoginViewController
{
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private LoginModel model;

  public LoginViewController()
  {
  }

  public void init(ViewHandler viewHandler, LoginModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset()
  {
    usernameField.setText("");
    passwordField.setText("");
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void loginButtonPressed()
  {
    String username = usernameField.getText();
    String password = passwordField.getText();
    try
    {
      model.validateLogin(username, password);
      model.login(username,password);
      errorLabel.setText("Login successful");
      errorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
      viewHandler.openView("overview");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
      errorLabel.setTextFill(javafx.scene.paint.Color.RED);
    }
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.openView("overview");
  }

}
