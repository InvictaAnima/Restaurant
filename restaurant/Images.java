package restaurant;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {	
	
	static BufferedImage map;
	static BufferedImage waiter;
	static BufferedImage client;
	static BufferedImage food;
	static BufferedImage dolar;
	static BufferedImage menu;
		
	public Images(){	
		
		map = loadImage("/map.png");		
		waiter = loadImage("/waiter2d.png");
		client = loadImage("/client.png");		
		food = loadImage("/food.png");	
		dolar = loadImage("/dolar.png");	
		menu = loadImage("/menu.png");	
	}
	
	static public BufferedImage getImage(String name){
		switch(name){		
		case "map": return map;
		case "waiter": return waiter;
		case "client": return client;
		case "food": return food;
		case "dolar": return dolar;
		case "menu": return menu;
		default: return null;
		}
	}

	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(Images.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();			
			System.exit(1);
			return null;
		}
	}
	
}
