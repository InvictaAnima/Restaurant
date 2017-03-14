package direction;

import java.util.LinkedList;

public class Direction {
	//nazwy list: ktoKtoryStolik
	//oneOne.add(new Point(0,0));
	public static LinkedList<Point> oneOne;
	public static LinkedList<Point> oneTwo;
	public static LinkedList<Point> oneThree;
	public static LinkedList<Point> oneFour;
	
	public static LinkedList<Point> twoOne;
	public static LinkedList<Point> twoTwo;
	public static LinkedList<Point> twoThree;
	public static LinkedList<Point> twoFour;
	
	public static LinkedList<Point> clientOne;	
	public static LinkedList<Point> clientTwo;
	public static LinkedList<Point> clientThree;
	public static LinkedList<Point> clientFour;
	
	public static LinkedList<Point> clientOneHome;	
	public static LinkedList<Point> clientTwoHome;
	public static LinkedList<Point> clientThreeHome;
	public static LinkedList<Point> clientFourHome;
	
	// -100,80
	
	
	public Direction(){		
		oneOne = new LinkedList<Point>();
		oneOne.add(new Point(20,80));		
		oneOne.add(new Point(160, 180));		
		oneOne.add(new Point(20,80));
		oneOne.add(new Point(-100,80));
		
		oneTwo = new LinkedList<Point>();
		oneTwo.add(new Point(0,80));		
		oneTwo.add(new Point(220, 80));
		oneTwo.add(new Point(350, 180));
		oneTwo.add(new Point(220, 80));		
		oneTwo.add(new Point(0,80));
		oneTwo.add(new Point(-100,80));
		
		oneThree = new LinkedList<Point>();
		oneThree.add(new Point(0,80));
		oneThree.add(new Point(30, 55));
		oneThree.add(new Point(510, 50));
		oneThree.add(new Point(550, 90));
		oneThree.add(new Point(680, 90));
		oneThree.add(new Point(687, 90));
		oneThree.add(new Point(740, 60));
		oneThree.add(new Point(687, 90));		
		oneThree.add(new Point(680, 90));
		oneThree.add(new Point(550, 90));
		oneThree.add(new Point(510, 50));
		oneThree.add(new Point(30, 55));
		oneThree.add(new Point(0,80));
		oneThree.add(new Point(-100,80));
		
		oneFour = new LinkedList<Point>();
		oneFour.add(new Point(0,80));
		oneFour.add(new Point(30, 55));
		oneFour.add(new Point(510, 50));
		oneFour.add(new Point(550, 90));
		oneFour.add(new Point(680, 90));
		oneFour.add(new Point(687, 90));
		oneFour.add(new Point(740, 150));
		oneFour.add(new Point(687, 90));		
		oneFour.add(new Point(680, 90));
		oneFour.add(new Point(550, 90));
		oneFour.add(new Point(510, 50));
		oneFour.add(new Point(30, 55));
		oneFour.add(new Point(0,80));
		oneFour.add(new Point(-100,80));
		
		
		
		twoOne = new LinkedList<Point>();
		twoOne.add(new Point(0,80));		
		twoOne.add(new Point(30, 115));
		twoOne.add(new Point(160, 180));		
		twoOne.add(new Point(30, 115));
		twoOne.add(new Point(0,80));
		twoOne.add(new Point(-100,80));
		
		twoTwo = new LinkedList<Point>();
		twoTwo.add(new Point(0,80));
		twoTwo.add(new Point(30, 115));
		twoTwo.add(new Point(220, 115));
		twoTwo.add(new Point(350, 180));
		twoTwo.add(new Point(220, 115));
		twoTwo.add(new Point(30, 115));
		twoTwo.add(new Point(0,80));
		twoTwo.add(new Point(-100,80));
		
		twoThree = new LinkedList<Point>();
		twoThree.add(new Point(0,80));
		twoThree.add(new Point(30, 115));
		twoThree.add(new Point(480, 140));
		twoThree.add(new Point(550, 90));
		twoThree.add(new Point(680, 90));
		twoThree.add(new Point(740, 60));	
		twoThree.add(new Point(680, 90));
		twoThree.add(new Point(550, 90));
		twoThree.add(new Point(480, 140));
		twoThree.add(new Point(30, 115));
		twoThree.add(new Point(0,80));
		twoThree.add(new Point(-100,80));
		
		twoFour = new LinkedList<Point>();
		twoFour.add(new Point(0,80));
		twoFour.add(new Point(30, 115));
		twoFour.add(new Point(480, 140));
		twoFour.add(new Point(550, 90));
		twoFour.add(new Point(680, 90));
		twoFour.add(new Point(740, 150));
		twoFour.add(new Point(680, 90));
		twoFour.add(new Point(550, 90));
		twoFour.add(new Point(480, 140));
		twoFour.add(new Point(30, 115));
		twoFour.add(new Point(0,80));
		twoFour.add(new Point(-100,80));

		
		
		
		clientOne = new LinkedList<Point>();
		clientOne.add(new Point(65,420));
		clientOne.add(new Point(65,230));
		clientOne.add(new Point(255,230));
		clientOne.add(new Point(255,180));
		clientOne.add(new Point(235,180));	
		
		clientTwo = new LinkedList<Point>();
		clientTwo.add(new Point(65,420));
		clientTwo.add(new Point(65,230));
		clientTwo.add(new Point(455,230));
		clientTwo.add(new Point(455,180));
		clientTwo.add(new Point(425,180));
		
		clientThree = new LinkedList<Point>();
		clientThree.add(new Point(65,420));
		clientThree.add(new Point(65,230));
		clientThree.add(new Point(500,230));
		clientThree.add(new Point(500,150));
		clientThree.add(new Point(500,80));
		clientThree.add(new Point(820,80));
		clientThree.add(new Point(820,52));
		clientThree.add(new Point(810,52));
		
		clientFour = new LinkedList<Point>();
		clientFour.add(new Point(65,420));
		clientFour.add(new Point(65,230));
		clientFour.add(new Point(500,230));
		clientFour.add(new Point(500,150));
		clientFour.add(new Point(500,80));
		clientFour.add(new Point(820,80));
		clientFour.add(new Point(820,148));
		clientFour.add(new Point(810,148));
		
		clientOneHome = new LinkedList<Point>();
		clientOneHome.add(new Point(235,180));
		clientOneHome.add(new Point(255,180));
		clientOneHome.add(new Point(255,230));
		clientOneHome.add(new Point(65,230));
		clientOneHome.add(new Point(65,420));
		
		clientTwoHome = new LinkedList<Point>();
		clientTwoHome.add(new Point(425,180));
		clientTwoHome.add(new Point(455,180));
		clientTwoHome.add(new Point(455,230));
		clientTwoHome.add(new Point(65,230));
		clientTwoHome.add(new Point(65,420));
		
		clientThreeHome = new LinkedList<Point>();
		clientThreeHome.add(new Point(810,52));
		clientThreeHome.add(new Point(820,52));
		clientThreeHome.add(new Point(820,80));
		clientThreeHome.add(new Point(500,80));
		clientThreeHome.add(new Point(500,150));
		clientThreeHome.add(new Point(500,230));
		clientThreeHome.add(new Point(65,230));
		clientThreeHome.add(new Point(65,420));
		
		clientFourHome = new LinkedList<Point>();
		clientFourHome.add(new Point(810,148));
		clientFourHome.add(new Point(820,148));
		clientFourHome.add(new Point(820,80));
		clientFourHome.add(new Point(500,80));
		clientFourHome.add(new Point(500,150));
		clientFourHome.add(new Point(500,230));
		clientFourHome.add(new Point(65,230));
		clientFourHome.add(new Point(65,420));
		
                
	}
}
