package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import model.LoginModel;
import javafx.scene.control.Label;

public class ShowLoginViewController
{
  @FXML private Label loginMessageLabel;
  @FXML private Button loginOrLogoutButtonLabel;
  private Region root;
  private ViewHandler viewHandler;
  private LoginModel model;

  public ShowLoginViewController()
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
    if (model.isLoggedIn()==true){
      loginMessageLabel.setText("You are logged in");
      loginOrLogoutButtonLabel.setText("Logout");
    }
    else if (model.isLoggedIn()==false){
      loginMessageLabel.setText("Logged out");
      loginOrLogoutButtonLabel.setText("Login");
    }
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void ShowLoginButtonPressed()
  {
    if (!model.isLoggedIn()){
      viewHandler.openView("login");
    }
    else {
    model.logout();
    loginMessageLabel.setText("You are logged in");
    loginOrLogoutButtonLabel.setText("Logout");
    }
  }

  @FXML public void ShowCloseButtonPressed()
  {
    viewHandler.closeView();
  }
}
