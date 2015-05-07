package Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

import Model.ListeningPart1;
import xml.ParserXml;

public class GameListeningP1 extends GameLoop{

	private ArrayList<ListeningPart1> listQuestion;
	
	private int currentQuestion;
	
	private char currentReponse;
	
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		ParserXml parser = new ParserXml();
		listQuestion = parser.getListeningPart1();
		currentQuestion = -1;
		
		/* 
		ArrayList<ListeningPart1> listAllQuestion = parser.getListeningPart1();
		
		listQuestion = new ArrayList<ListeningPart1>();
		boolean end = false, ok = false;
		int max = listAllQuestion.size();
		int[] i_question = new int[5];
		int i = 0;
		while(!end){
			//generate a random number
			i = (int) Math.random() * max;
			ok = true;
			for(int j = 0; j < i_question.length; i++){
				if(i_question[j] == i){
					ok = false;
					break;
				}	
			}
			if(ok)
				listQuestion.add(listAllQuestion.get(i));
			if(listQuestion.size() == 5)
				end = true;
		}
		*/
		
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		System.out.println("Affichage de l'image");
		
		System.out.println("Ecoute attentivement l'extrait suivant ");
		System.out.println("Lecture de l'extrait");
		System.out.println("A                              B");
		System.out.println("C                              D");
		
		
		System.out.println("Quel est votre réponse ?");
		Scanner sc = new Scanner(System.in);
		String reponse = sc.nextLine().trim();
		System.out.println(reponse + " " + reponse.length());
		currentReponse = reponse.charAt(0);
		
		if(currentReponse == listQuestion.get(currentQuestion).getAnswer()){
			System.out.println("Vous avez trouvé la bonne réponse");
		}
		else
			System.out.println("La bonne réponse était : " + listQuestion.get(currentQuestion).getAnswer());
			
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		currentQuestion++;
		
	}

	@Override
	public void Run() {
		// TODO Auto-generated method stub
		Init();
		
		Update();
		
		Render();
			
		
	}
	
	public static void main(String[] args){
		GameListeningP1 g = new GameListeningP1();
		g.Run();
		
	}

}
