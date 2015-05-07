package Model;

public class Pyramid {

	private final int maxIndScore = 35;
	
	private final int eachLevel = 5;
	
	private int[] listScore;
	
	private int[] listLevel;
	
	private int indCurrentScore;
	
	public Pyramid(){
		
		listScore = new int[maxIndScore];
		listLevel = new int[(maxIndScore/eachLevel)];
		int j = 0;
		for(int i = 0; i < listScore.length; i++){
			listScore[i] = (i+1) * 100;
			System.out.println(i+1 + " % " + eachLevel + " = " + (i+1)%eachLevel);
			if((i+1) % (eachLevel) == 0){
				listLevel[j] = (i+1) * 100;
			}
		}
	}
	
	public void increment(){
		if(indCurrentScore < maxIndScore)
			indCurrentScore++;
	}
	
	public boolean isLevel(){
		boolean level = false;
		if(( (indCurrentScore+1) % (eachLevel) ) == 0)
			level = true;
		return level;
	}
	
	public int getCurrentScore(){
		return listScore[indCurrentScore];
	}
	
	public static void main(String[] args){
		Pyramid p = new Pyramid();
		for(int i = 0; i < 35; i++){
			System.out.println(p.getCurrentScore() + " est un palier ? " + p.isLevel());
			p.increment();
		}
	}
}
