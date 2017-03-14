package tasks;

public class Task {
	private int actor; // -1 = map, 0 = waiter, >0 = client
	private int table;
	private String action;
	
	public Task(int actor, int table, String action){
		this.actor = actor;
		this.table = table;
		this.action = action;		
	}
	
	
	public Task(Task task) {
		this.action = task.action;
		this.actor = task.actor;
		this.table = task.table;
	}


	public int getActor(){
		return actor;
	}
	
	public int getTable(){
		return table;
	}
	
	public String getAction(){
		return action;
	}
}
