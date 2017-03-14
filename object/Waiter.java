package object;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import direction.Direction;
import monitors.BridgeSemaphore;
import monitors.TaskManager;
import restaurant.Images;
import tasks.Task;

public class Waiter extends GameObject implements Runnable {

	String state; // stan ktory pokazuje chmurke
	BufferedImage imageState;
	Task taskTmp; //aktualnie wykonywane zadanie
	
	public Waiter(Graphics g, BufferStrategy bs){
		super(g,bs);
		id = 0;
		image = Images.getImage("waiter");	
		x = -90;
		y = 80;
		directionX = -90;
		directionY = 80;	
		destiny = null;
		state = null;
		busy = false;
	}
	
	public void update(){	
			waitTables();
			setBusy();
			
		
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
		//System.out.println("xC:" + directionX + " yC:" + directionY + " x:" + x + " y:" + y);
	}
	
	public void draw(Graphics g){				
		g.drawImage(image.getSubimage(movementState * 64, direction * 64, 64, 64), x, y, null);	
		g.drawImage(imageState, x+16, y-32, null);				
	}
	
	public void setMovementState(){
		if(this.x != directionX || this.y != directionY){
			this.movementState++;
			if(movementState>3){
				movementState = 0;
			}
		} else {
			movementState = 4;
		}
		
		if(this.x < this.directionX){
			direction = 0;
		}
		
		if(this.x > this.directionX){
			direction = 1;
		}
	}	
	
	private void updateTask(){
		Task tmp = TaskManager.getTask(id);
		
		if(tmp != null){			
			taskTmp = tmp;			
			directionListIdx = 0;
			
			switch (tmp.getTable()) {			
			case 1:
				destiny = Direction.oneOne;
				break;
			case 2:
				destiny = Direction.oneTwo;
				break;
			case 3:				
				destiny = Direction.oneThree;				
				break;
			default:
				destiny = Direction.oneFour;					
			}
			
			busy = true; 
			
			switch (tmp.getAction()) {			
			case "getOrder" :
				imageState = Images.getImage("menu");
				break;
			case "getFood" :
				imageState = Images.getImage("food");
				break;
			case "getCash": 
				imageState = Images.getImage("dolar");
				break;
			}
		}		
		
	}
	
	public void throwTask(){
		switch (taskTmp.getAction()){
		case "getOrder" :
			TaskManager.addTask(0,taskTmp.getTable(),"getFood");
			break;
		case "getFood" :
			TaskManager.addTask(0,taskTmp.getTable(),"getCash");
			break;	
		default :
			TaskManager.addTask(1,taskTmp.getTable(),"goHome");
		}
	}
	
	private void waitTables(){
		if(x ==160 & y ==180 ||
			 x ==350 & y ==180 ||
			 x ==740 & y ==60  ||
			 x ==740 & y ==150 ){
			direction = 0;
			movementState= 4;
			globals.sysSavedTimeUpdate +=  3000;
			globals.sysSavedTimeAnimations +=  3000;
		}
	}
	
	private void setBusy(){
		if(x ==-100 && y==80){
			busy = false;
			x = -90;
			directionX = -90;			      
		}
	}
	
	private void crossBridge(){
		if(direction == 1){
			if(x == 685 && y == 90){
				if(BridgeSemaphore.waitBridge() != true){
					movementState= 4;
					globals.sysSavedTimeUpdate +=  1000;
					globals.sysSavedTimeAnimations +=  1000;
					x++;					
				}
			}
			
			if(x == 510 && y == 50){
				BridgeSemaphore.signalBridge();
			}
			
			
		} else {
			if(x == 500 && y == 50){
				if(BridgeSemaphore.waitBridge() != true){
					movementState= 4;
					globals.sysSavedTimeUpdate +=  1000;
					globals.sysSavedTimeAnimations +=  1000;
					x--;					
				}
			}
			
			if(x == 680 && y == 90){				
				BridgeSemaphore.signalBridge();
			}
		}
	}
	
	public void setDirection(int y){
		this.direction=y;
	}

	@Override
	public void run() {
		
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
