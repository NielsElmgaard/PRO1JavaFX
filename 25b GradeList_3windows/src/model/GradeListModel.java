package model;

public interface GradeListModel
{
  void addGrade(Grade grade);
  void removeGrade(int index);
  void removeGrade(Grade grade);
  int gradeListSize();
  Grade getGrade(int index);
  Grade getMaxGrade();
  Grade getMinGrade();
  double getAverageGrade();
  boolean isLegalGrade(int grade);
  String validateLogin(String user, String password);
  boolean isLoggedIn();
  boolean logIn(String user, String password);
}
