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
  private ShowLoginViewController showLoginViewController;

  public ViewHandler(LoginModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("overview");
  }

  public void openView(String id)
  {
    Region root = null;
    try
    {
      switch (id)
      {
        case "overview":
          root = loadShowLoginView("ShowLoginView.fxml");
          break;
        case "login":
          root = loadLoginView("LoginView.fxml");
          break;
      }
      if (root != null)
      {
        currentScene.setRoot(root);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
      }
      else
      {
        System.out.println("Failed to load view: " + id);
      }
    }
    catch (Exception e)
    {
      System.out.println("Error opening view: " + id);
    }
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

    return loginViewController.getRoot();
  }

  private Region loadShowLoginView(String fxmlFile)
  {
    if (showLoginViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        showLoginViewController = loader.getController();
        showLoginViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        System.out.println("Error loading FXML file: " + fxmlFile);
        e.printStackTrace();
      }
    }

    return showLoginViewController.getRoot();
  }
}