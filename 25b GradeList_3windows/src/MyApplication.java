import javafx.application.Application;
import javafx.stage.Stage;
import model.GradeListModel;
import model.GradeListModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    try
    {
      GradeListModel model = new GradeListModelManager();
      ViewHandler view = new ViewHandler(model);
      view.start(primaryStage);
    }
    catch (Exception e)
    {
      System.out.println("Failed to start the application");
      e.printStackTrace();
    }
  }
}
