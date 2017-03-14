package monitors;

//monitor przydzielajacy numery stolikow klientom restauracji
public class Tables {
	private static boolean []tables = new boolean[4];
	
		
	public synchronized static int getTable(){
		for(int i=0;i<4;i++){
			if(tables[i]==false){
				tables[i] = true;
				return ++i;				
			}			
		}
		
		return 0;
	}
	
	public synchronized static void freeTable(int table){
		tables[--table] = false;
	}
}
