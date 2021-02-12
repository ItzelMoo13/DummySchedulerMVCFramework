import java.awt.Component;

import javax.swing.JFrame;

import controllers.DefaultController;
import controllers.EventListController;
import controllers.NewEventController;
import views.DefaultView;

public class SchedulerController extends DefaultController {
	private EventListController eventListController = new EventListController();
	private NewEventController newEventController = new NewEventController(eventListController);
	
	@Override
	protected void initControllers() {
		eventListController.run();
		newEventController.run();
	}
	
	

	@Override
	protected void initDefaultView(JFrame frame) {
		defaultView = new DefaultView(this, mainFrame);
		addView("DefaultView", defaultView);
		
	}



	public Component getEventListView()
	{
		return eventListController.getView();
	}
	
	public Component getNewEventView()
	{
		return newEventController.getView();
	}
}
