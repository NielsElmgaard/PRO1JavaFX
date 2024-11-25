package model;

public class Grade
{
  private int grade;
  private String course;
  public static final int[] LEGAL_GRADES = {12, 10, 7, 4, 2, 0, -3};

  public Grade(int grade, String course)
  {
    if (isLegalGrade(grade))
    {
      this.grade = grade;
    }
    else {
      throw new IllegalArgumentException("Not a legal grade");
    }
    if (course!=null&&!course.isEmpty())
    {
      this.course=course;
    }
    else {
      throw new IllegalArgumentException("Course name cannot be null length or empty");
    }
  }

  public Grade(String ectsGrade)
  {
    switch (ectsGrade)
    {
      case "A":
        this.grade = 12;
        break;
      case "B":
        this.grade = 10;
        break;
      case "C":
        this.grade = 7;
        break;
      case "D":
        this.grade = 4;
        break;
      case "E":
        this.grade = 2;
        break;
      case "Fx":
        this.grade = 0;
        break;
      case "F":
        this.grade = -3;
        break;
      default:
        this.grade = -3;
    }
  }

  public int getGrade()
  {
    switch (grade)
    {
      case -3:
        return -3;
      case 0:
        return 0;
      case 2:
        return 2;
      case 4:
        return 4;
      case 7:
        return 7;
      case 10:
        return 10;
      case 12:
        return 12;
      default:
        return -3;
    }
  }

  public String getCourse()
  {
    return course;
  }

  public String getEctsGrade()
  {
    switch (grade)
    {
      case -3:
        return "F";
      case 0:
        return "Fx";
      case 2:
        return "E";
      case 4:
        return "D";
      case 7:
        return "C";
      case 10:
        return "B";
      case 12:
        return "A";
      default:
        return "-3";
    }
  }

  @Override public String toString()
  {
    return "Grade: " + getGrade() + "(" + getEctsGrade()+") ["+course+"]";
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Grade other = (Grade)obj;
    return  grade == other.grade&&course.equals(other.course);
  }

  public static boolean isLegalGrade(int grade)
  {
    for (int i = 0; i < LEGAL_GRADES.length; i++)
    {
      if (grade == LEGAL_GRADES[i])
      {
        return true;
      }
    }
    return false;
  }
}