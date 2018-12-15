import java.io.FileNotFoundException;
import java.io.IOException;

public class WeeklyPlanFileAdapter
{
   private MyFileIO mfio;
   private String fileName;
   
   public WeeklyPlanFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   
   public WeeklyPlanList getAllWeeklyPlans() {
      WeeklyPlanList weeklyPlans = new WeeklyPlanList();
      
      try {
         weeklyPlans = (WeeklyPlanList) mfio.readObjectFromFile(fileName);
      }
      
      catch(FileNotFoundException e){
         System.out.println("File Not Found");
      }
      catch (IOException e) {
         System.out.println("IO error reading files");
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         System.out.println("Class not found");
      }
      
      return weeklyPlans;
   }
   
   public void saveWeeklyPlans(WeeklyPlanList weeklyPlans) {
      try {
         mfio.writeToFile(fileName, weeklyPlans);
      }
      catch(FileNotFoundException e){
         System.out.println("File Not Found");
      }
      catch(IOException e) {
         System.out.println("IO Error writing the file");
      }
   }
   
   public void changeWeeklyPlan(Analysis analysis, String weekSize, double[] numberOfEmpployees)
   {
      WeeklyPlanList weeklyPlans = getAllWeeklyPlans();
      
      for (int i = 0; i < weeklyPlans.size(); i++)
      {
         if(weeklyPlans.get(i).getAnalysis().equals(analysis)
               && weeklyPlans.get(i).getWeekSize().equals(weekSize)) 
         {
            for (int j = 0; j < numberOfEmpployees.length; j++)
            {
               weeklyPlans.get(i).setNumberOfEmployees(j, numberOfEmpployees[j]);
            }
         }
      }
   }
   
}