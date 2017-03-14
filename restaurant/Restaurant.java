package restaurant;

import java.awt.Canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import direction.Direction;

import object.Client;
import object.Map;
import object.Waiter;

public class Restaurant extends Canvas {	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=970, HEIGHT=460;
	private JFrame window;
	private static BufferStrategy bs;
	private static Graphics g;	
	
	public Restaurant(){
		new Images();		
		new Direction();
		
		window = new JFrame("Restaurant");
	}
	
	private void setWindow(JFrame window, Restaurant restaurant){
		window.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		window.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(restaurant);		
		window.setVisible(true);
		
		this.createBufferStrategy(3);
		bs = this.getBufferStrategy();	
		g = bs.getDrawGraphics();		
	}
	
	
	public static void main(String[] args){
		Restaurant restaurant = new Restaurant();
		restaurant.setWindow(restaurant.window,restaurant);
		
		Runnable[] runners = new Runnable[10];
    Thread[] threads = new Thread[10];
		
      runners[0] = new Map(g,bs);
      runners[1] = new Waiter(g,bs);
      runners[2] = new Waiter(g,bs);
      runners[3] = new Client(g,bs);
      runners[4] = new Client(g,bs);
      runners[5] = new Client(g,bs);
      runners[6] = new Client(g,bs);
      runners[7] = new Client(g,bs);
      runners[8] = new Client(g,bs);
		

		for(int i=0; i<9; i++) {
      threads[i] = new Thread(runners[i]);
		}

		for(int i=0; i<3; i++) {
      threads[i].start();
		}
		
		for(int i=3; i<9; i++) {
      threads[i].start();
      try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
}
