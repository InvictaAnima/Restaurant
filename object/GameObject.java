package object;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import direction.Point;
import restaurant.Globals;

public abstract class GameObject implements Runnable{
	int x;
	int y;
	
	LinkedList<Point> destiny; //lista watpoint'ow
	int directionX; //wspolzedne nastepne waypoint'u
	int directionY;
	int directionListIdx;
	int movementState; //klatka animacji
	int direction;  //kierunek animacji
	
	boolean busy; // jesli false to przeglada taskList
	
	
	int id;
	BufferedImage image;
	Globals globals;
	Graphics g;
	BufferStrategy bs;
		
	public GameObject(Graphics g, BufferStrategy bs){
		destiny = new LinkedList<Point>();
		
		x = 0;
		y = 0;	
		directionListIdx = 0;
		globals = new Globals();
		this.g= g;
		this.bs= bs;
		
		busy = false;
	}	
	
	public abstract void update();
	public abstract void updateAnimations();
	public abstract void draw(Graphics g);
	public abstract void setMovementState();
	public abstract void throwTask();
	
	public void move(int x, int y){
		if(this.x < x){
			this.x++;
		}
		
		if(this.x > x){
			this.x--;
		}
		
		if(this.y < y){
			this.y++;
		}
		
		if(this.y > y){
			this.y--;
		}	
	}
	
	public void updateDirectionXY(){
		
		if(destiny!=null){
			Point tmp; 
			if(directionListIdx == destiny.size()){
				throwTask();
			}
			
			if(directionListIdx < destiny.size()){
				tmp = destiny.get(directionListIdx);
			} else {
				tmp = null;
			}
			
			if(tmp != null){
				this.directionX = tmp.getX();
				this.directionY = tmp.getY();
			}
			directionListIdx++;		
			}
	}
	
	public void setX(int x){
		this.x=x;
	}	
	public void setY(int y){
		this.y=y;
	}	
	public void setDirectionX(int x){
		this.directionX=x;
	}	
	public void setDirectionY(int y){
		this.directionY=y;
	}			
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public int getId(){
		return id;
	}	
	
}
