package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GradeListModelManager implements GradeListModel
{
  private GradeList list;
  private boolean loggedIn;
  private ObservableList<Grade> observableList;

  public GradeListModelManager()
  {
    this.list = new GradeList();
    this.observableList = FXCollections.observableArrayList();
    createDummyData();
    loggedIn = false;
  }

  private void createDummyData()
  {
    Grade grade1 = new Grade(12, "PBL");
    Grade grade2 = new Grade(-3, "SEP1");
    list.addGrade(grade1);
    list.addGrade(grade2);
  }

  @Override public void addGrade(Grade grade)
  {
    list.addGrade(grade);
  }

  @Override public void removeGrade(int index)
  {
    list.removeGrade(index);
  }

  @Override public void removeGrade(Grade grade)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.getGrade(i).equals(grade))
      {
        list.removeGrade(i);
        break;
      }
    }
  }

  @Override public int gradeListSize()
  {
    return list.size();
  }

  @Override public Grade getGrade(int index)
  {
    return list.getGrade(index);
  }

  @Override public Grade getMaxGrade()
  {
    return list.getMaxGrade();
  }

  @Override public Grade getMinGrade()
  {
    return list.getMinGrade();
  }

  @Override public double getAverageGrade()
  {
    return list.getAverage();
  }

  @Override public boolean isLegalGrade(int grade)
  {
    return Grade.isLegalGrade(grade);
  }

  @Override public String validateLogin(String user, String password)
  {

    if (user == null || user.isEmpty())
    {
      return "Username cannot be empty";
    }

    if (password == null || password.length() < 6)
    {
      return "Password must contain at least 6 characters";
    }
    return null;
  }

  @Override public boolean isLoggedIn()
  {
    return loggedIn;
  }

  @Override public boolean logIn(String user, String password)
  {
    if (!loggedIn)
    {
      String validationMessage = validateLogin(user, password);
      if (validationMessage != null)
      {
        System.out.println("Login failed: " + validationMessage);
        return false;
      }
      loggedIn = true;
    }
    return loggedIn;
  }

}
