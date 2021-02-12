package controllers;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;
import views.EventListView;

public class EventListController extends Controller 
{
	private EventListView eventListView;
	private JTable eventTable;
	
	@Override
	public void run() 
	{
		eventTable = new JTable(getDataColumns(), getNameColumns());
		eventListView = new EventListView(this, eventTable);
	}
	
	public void addNewRow(Object[] values) 
	{
		((DefaultTableModel) eventTable.getModel()).addRow(values);
	}
	
	public EventListView getView()
	{
		return eventListView;
	}
	
	public Vector<String> getNameColumns() 
	{
		Vector<String> nameColumns = new Vector<String>();
		
		nameColumns.add("Date");
		nameColumns.add("Description");
		nameColumns.add("Frequency");
		nameColumns.add("E-mail");
		nameColumns.add("Alarm");
		
		return nameColumns;
	}
	
	public Vector<Vector<Object>> getDataColumns() 
	{
		Vector<Vector<Object>> dataColumns = null;

		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			schedulerIO.attach(eventListView);
			dataColumns = schedulerIO.getEvents();
		} catch (Exception ex) { }

		return dataColumns;
	}
}
