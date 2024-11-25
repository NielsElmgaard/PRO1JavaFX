import javafx.application.Application;
import javafx.stage.Stage;
import model.LoginModel;
import model.LoginModelManager;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    LoginModel model = new LoginModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
