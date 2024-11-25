package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.GradeListModel;
import model.GradeListModelManager;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private GradeListModel model;
  private GradeListViewController gradeListViewController;
  private AddGradeViewController addGradeViewController;
  private DetailsViewController detailsViewController;

  public ViewHandler(GradeListModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;

    openView("list");
  }

  public void openView(String id)
  {
    Region root = null;
    try
    {
      switch (id)
      {
        case "list":
          root = loadGradeListView("GradeListView.fxml");
          break;
        case "add":
          root = loadAddGradeView("AddGradeView.fxml");
          break;
      case "details":
        root = loadDetailsView("DetailsView.fxml");
        break;
      }
      if (root != null)
      {
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData()!=null){
          title+=root.getUserData();
        }
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

  private Region loadGradeListView(String fxmlFile)
  {
    if (gradeListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        gradeListViewController = loader.getController();
        gradeListViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        System.out.println("Error loading FXML file: " + fxmlFile);
        e.printStackTrace();
      }
    }
    else
    {
      gradeListViewController.reset();
    }
    return gradeListViewController.getRoot();
  }

  private Region loadAddGradeView(String fxmlFile)
  {
    if (addGradeViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addGradeViewController= loader.getController();
        addGradeViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        System.out.println("Error loading FXML file: " + fxmlFile);
        e.printStackTrace();
      }
    }

    return addGradeViewController.getRoot();
  }

  private Region loadDetailsView(String fxmlFile)
  {
    if (detailsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        detailsViewController= loader.getController();
        detailsViewController.init(this,model,root);
      }
      catch (Exception e)
      {
        System.out.println("Error loading FXML file: " + fxmlFile);
        e.printStackTrace();
      }
    }
    else
    {
      detailsViewController.reset();
    }
    return detailsViewController.getRoot();
  }

}