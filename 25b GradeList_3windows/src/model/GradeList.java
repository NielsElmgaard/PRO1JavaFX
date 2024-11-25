package model;

import java.util.ArrayList;

public class GradeList
{
  private ArrayList<Grade> grades;

  public GradeList()
  {
    this.grades = new ArrayList<>();;

  }

  public int size(){
    return grades.size();
  }

  public void addGrade(Grade grade)
  {
    grades.add(grade);
  }

  public void addGrade(int index, Grade grade)
  {
    if (index >= 0 && index <= grades.size())
    {
      grades.add(index,grade);
    }
  }

  public void removeGrade(int index)
  {
   grades.remove(index);
  }

  public Grade getGrade(int index)
  {
   return grades.get(index);
  }

  public Grade getMaxGrade()
  {
    Grade max = grades.get(0);
    for (int i = 1; i < size(); i++) // first garde already considered
    {
      if (grades.get(i).getGrade() > max.getGrade())
      {
        max = grades.get(i);
      }
    }
    return max;
  }

  public Grade getMinGrade()
  {
    Grade min = grades.get(0);
    for (int i = 1; i < size(); i++) // first garde already considered
    {
      if (grades.get(i).getGrade() < min.getGrade())
      {
        min = grades.get(i);
      }
    }
    return min;
  }

  public double getAverage()
  {
    int total = 0;
    for (int i = 0; i < size(); i++)
    {
      total += grades.get(i).getGrade();
    }
    return (double) total / size();
  }

  public int getGradeCount(int grade)
  {
    int countGrade = 0;
    for (int i = 0; i < size(); i++)
    {
      if (grades.get(i).getGrade() == grade)
      {
        countGrade++;
      }
    }
    return countGrade;
  }

  public String getGradeDistribution()
  {
    int[] gradeCounts = new int[Grade.LEGAL_GRADES.length];
    for (int i = 0; i < size(); i++)
    {
      for (int j = 0; j < Grade.LEGAL_GRADES.length; j++)
      {
        if (grades.get(i).getGrade() == Grade.LEGAL_GRADES[j])
        {
          gradeCounts[j]++;
        }
      }
    }
    String distribution = "";
    for (int i = 0; i < Grade.LEGAL_GRADES.length; i++)
    {
      distribution += Grade.LEGAL_GRADES[i] + " (" + gradeCounts[i] + ")";
      if (i < Grade.LEGAL_GRADES.length - 1)
      {
        distribution += ", ";
      }
    }
    return distribution;
  }

  @Override public String toString()
  {
    String result = "";
    for (int i = 0; i < size(); i++)
    {
      result += grades.get(i);
      if (i < size() - 1) //removes last comma
      {
        result += ", ";
      }
    }
    return "{" + result + "}";
  }

  @Override public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    GradeList other = (GradeList) obj;
    return grades.equals(other.grades);
  }
}
