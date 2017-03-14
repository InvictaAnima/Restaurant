package object;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import direction.Direction;
import monitors.BridgeSemaphore;
import monitors.Tables;
import monitors.TaskManager;
import restaurant.Images;
import tasks.Task;

public class Client extends GameObject implements Runnable {
		
	private int table;
	
	public Client(Graphics g, BufferStrategy bs){
		super(g,bs);
		id = 1;			
		image = Images.getImage("client");	
		x = 65;
		y = 420;
		directionX = 65;
		directionY = 420;		
	}
	
	public void update(){
		if(busy == false){
			updateTask();
		}
		
		move(directionX,directionY);
		if(this.x == directionX && this.y == directionY){
			this.updateDirectionXY();
		}
		
		crossBridge();
	}
	
	public void updateAnimations(){
		setMovementState();		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(image.getSubimage(movementState * 64, direction * 64, 64, 64), x, y, null);			
	}
	
	public void setMovementState(){
		if(this.x != directionX || this.y != directionY){
			this.movementState++;
			if(movementState==8){
				movementState = 0;
			}
		} else {
			movementState = 0;
		}
		
		if(this.x < this.directionX){
			direction = 2;
		}
		
		if(this.x > this.directionX){
			direction = 1;
		}
		
		if(this.y < this.directionY){
			direction = 3;
		}
		
		if(this.y > this.directionY){
			direction = 0;
		}
	}
	
	private void updateTask(){
		Task tmp = TaskManager.getTaskClient(table);
		
		if(tmp != null){					
			directionListIdx = 0;
			
			switch (tmp.getTable()) {			
			case 1:
				destiny = Direction.clientOneHome;
				break;
			case 2:
				destiny = Direction.clientTwoHome;
				break;
			case 3:				
				destiny = Direction.clientThreeHome;				
				break;
			default:
				destiny = Direction.clientFourHome;					
			}
			
			busy = true;
		}		
		
	}
	
	public void throwTask(){
		if(y<400){
			TaskManager.addTask(0, table, "getOrder");
		} else {
			Tables.freeTable(table);
		}
	}
	
	private void getTable(){	 		
		do{
			table = Tables.getTable();			
		} while(table == 0);		
		
		switch (table) {
			case 1:
				destiny = Direction.clientOne;
				break;
			case 2:
				destiny = Direction.clientTwo;
				break;
			case 3:
				destiny = Direction.clientThree;  
				break;
			default:				
				destiny = Direction.clientFour;
		}		
		
	}
	
	private void crossBridge(){
		if(direction == 0){
			if(x == 500 && y == 155){
				if(BridgeSemaphore.waitBridge() != true){
					movementState= 0;
					globals.sysSavedTimeUpdate +=  1000;
					globals.sysSavedTimeAnimations +=  1000;
					y++;					
				}
			}			
			
		} else if(direction == 2){ 
			if(x == 680 && y == 80){
				BridgeSemaphore.signalBridge();
			}
		}else if(direction == 1) {
			if(x == 680 && y == 80){
				if(BridgeSemaphore.waitBridge() != true){
					movementState= 0;
					globals.sysSavedTimeUpdate +=  1000;
					globals.sysSavedTimeAnimations +=  1000;
					x++;					
				}
			}
		}else{			
			if(x == 500 && y == 165){
				System.out.println("huehuehue");
				BridgeSemaphore.signalBridge();
			}
		}
	}

	@Override
	public void run(){
		
		getTable();		
		while(true){
			globals.updateClocks();
			
			if(globals.elapsedUpdate >= 30){ //30
				globals.resetSysUpdate();				
				
				this.update();				
			}	
			
			if(globals.elapsedAnimations >= 200){
				globals.resetSysAnimations();
				this.updateAnimations();			
			}	
			
			if(globals.elapsedDraw >= 5){
				globals.resetSysDraw();
				this.draw(g);			
			}	
			
		}
		
	}
	
}
