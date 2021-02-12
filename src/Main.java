import core.Controller;
import controllers.DefaultController;

public class Main 
{
	public static void main(String[] args) 
	{
		Controller c = new SchedulerController();
		
		try {
		   c.run();
		} catch (Exception e) {
		   e.printStackTrace();	
		}
	}
}
