package Game;

import java.util.ArrayList;
import java.math.*;
import Model.ListeningPart1;
import xml.ParserXml;

public class GameListeningP1 extends GameLoop{

	ArrayList<ListeningPart1> listQuestion;
	
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		ParserXml parser = new ParserXml();
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
		
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Run() {
		// TODO Auto-generated method stub
		
	}

}
