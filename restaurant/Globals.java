package restaurant;

public class Globals {
	
	public long sysSavedTimeUpdate;
	public long sysTimeUpdate;
	public long elapsedUpdate;
	
	public long sysSavedTimeDraw;
	public long sysTimeDraw;
	public long elapsedDraw;
	
	public long sysSavedTimeAnimations;
	public long sysTimeAnimations;
	public long elapsedAnimations;
	
	public Globals(){	
	sysSavedTimeUpdate = System.currentTimeMillis();
	sysTimeUpdate = System.currentTimeMillis();
	elapsedUpdate = 0;
	
	sysSavedTimeDraw = System.currentTimeMillis();
	sysTimeDraw = System.currentTimeMillis();
	elapsedDraw = 0;
	
	sysSavedTimeAnimations = System.currentTimeMillis();
	sysTimeAnimations = System.currentTimeMillis();
	elapsedAnimations = 0;
	}
	
	public void updateClocks(){
		sysTimeUpdate = System.currentTimeMillis();			
		elapsedUpdate = sysTimeUpdate - sysSavedTimeUpdate;
		
		sysTimeDraw = System.currentTimeMillis();			
		elapsedDraw = sysTimeDraw - sysSavedTimeDraw;
		
		sysTimeAnimations = System.currentTimeMillis();			
		elapsedAnimations = sysTimeAnimations - sysSavedTimeAnimations;
	}
	
	public void resetSysUpdate(){
		sysSavedTimeUpdate = System.currentTimeMillis();
	}
	
	public void resetSysDraw(){
		sysSavedTimeDraw = System.currentTimeMillis();
	}
	
	public void resetSysAnimations(){
		sysSavedTimeAnimations = System.currentTimeMillis();
	}

}
