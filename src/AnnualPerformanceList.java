import java.io.Serializable;
import java.util.ArrayList;

public class AnnualPerformanceList implements Serializable
{

   private ArrayList<AnnualPerformance> comments;

   /*
    * A contructor which takes elements of type AnnualPerformance
    */
   public AnnualPerformanceList()
   {
      comments = new ArrayList<AnnualPerformance>();
   }

   /**
    * A method that adds an employee's preference to the list of preferences or
    * perfomanceList
    * 
    * @param annualPerformance
    *           the employee's preference to add to the list
    */
   public void addAnnualPerformance(AnnualPerformance annualPerformance)
   {
      comments.add(annualPerformance);
   }

   /**
    * @param annualPerformance
    */
   
   public void removeAnnualPerformance(AnnualPerformance annual)
   {
      comments.remove(annual);
   }

   public void sortByName()
   {

   }

   public int getSize()
   {
      return comments.size();
   }
   
   public void removeIndex(int i)
   {
      comments.remove(i);
   }

   public AnnualPerformance getAnnualPerformance(int index)
   {
      return comments.get(index);
   }
   
   
   //This methos was added by Sabin today
   public String getComment(String initials, String name) {
      for(int i = 0;i<comments.size();i++) {
         if(comments.get(i).matchComment(initials, name))
            return comments.get(i).getComment();
      }
      return "";
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof AnnualPerformanceList))
      {
         return false;
      }
      AnnualPerformanceList temp = (AnnualPerformanceList) obj;
      return temp.comments.equals(comments);

   }

   public String toString()
   {
      String str = "";
      for (int i = 0; i < comments.size(); i++)
         str += comments.get(i);
      return str;
   }
}
