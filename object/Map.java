package object;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import restaurant.Images;

public class Map extends GameObject implements Runnable{	
	
	public Map(Graphics g, BufferStrategy bs) {
		super(g,bs);
		id = -1;
		image = Images.getImage("map");
	}

	public void update(){
		
	}
	
	public void updateAnimations(){
		
	}
	
	public void draw(Graphics g){				
		g = bs.getDrawGraphics();
		bs.show();
		
		g.drawImage(image, x, y, null);
	}
	
	public void setMovementState(){
		
	}
	
	public void throwTask(){
		
	}

	@Override
	public void run() {
		
		while(true){
			globals.updateClocks();
			
			if(globals.elapsedUpdate >= 30){
				globals.resetSysUpdate();				
				
				this.update();				
			}	
			
			if(globals.elapsedAnimations >= 200){
				globals.resetSysAnimations();
				this.updateAnimations();			
			}	
			
			if(globals.elapsedDraw >= 30){
				globals.resetSysDraw();
				this.draw(g);			
			}	
			
		}
		
	}
	
}
