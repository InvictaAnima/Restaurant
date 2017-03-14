package monitors;

import java.util.LinkedList;

import tasks.Task;

public class TaskManager {
	static LinkedList <Task> tasks = new LinkedList<Task>();
	
	public synchronized static void addTask(int actor, int table, String action){
		
		tasks.addFirst(new Task(actor, table, action));
		
	}
	
	public synchronized static void removeTask(Task tmp){
		tasks.remove(tmp);
	}
	
	public synchronized static Task getTask(int actor){
		Task tmp = null;
		Task tmpTwo = null;
		
		for(Task i : tasks){
			if(actor == i.getActor()){
				tmp = i;
				tmpTwo = new Task(i);
				
			}
		}
		if(tmp != null){			
			tasks.remove(tmp);			;
		}
		
		return tmpTwo;
	}
	
	public synchronized static Task getTaskClient(int table){
		Task tmp = null;
		Task tmpTwo = null;
		
		for(Task i : tasks){
			if(table == i.getTable() && i.getAction() == "goHome"){
				tmp = i;
				tmpTwo = new Task(i);
				
			}
		}
		if(tmp != null){			
			tasks.remove(tmp);			;
		}
		
		return tmpTwo;
	}
	
	public synchronized static void printList(){
		System.out.println("Lista:");
		for(Task i : tasks){
			System.out.println("Actor:" + i.getActor() +
												 " Table:" + i.getTable() +
												 " Action:"+ i.getAction());
		}		
	}
	public static void printListE(){
		System.out.println("Lista:");
		for(Task i : tasks){
			System.out.println("Actor:" + i.getActor() +
												 " Table:" + i.getTable() +
												 " Action:"+ i.getAction());
		}		
	}
	
}
