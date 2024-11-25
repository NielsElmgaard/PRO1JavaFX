package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.LoginModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private LoginModel model;
  private LoginViewController loginViewController;

  public ViewHandler(LoginModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView();
  }

  public void openView()
  {
    Region root = loadLoginView("/view/LoginView.fxml");
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadLoginView(String fxmlFile)
  {
    if (loginViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        loginViewController = loader.getController();
        loginViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        System.out.println("Error loading FXML file: " + fxmlFile);
        e.printStackTrace();
      }
    }
    else {
      loginViewController.reset();
    }
    return loginViewController.getRoot();
  }
}