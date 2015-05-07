package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.*;
import org.jdom2.output.*;
import org.jdom2.xpath.*;

import Model.ListeningPart1;

public class ParserXml {
	
	private final String xml_file_listening_part1 = "ListQuestionsPart1.xml";
	
	public ArrayList<ListeningPart1> getListeningPart1(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_listening_part1);
		
		ArrayList<ListeningPart1> listIdq = new ArrayList<ListeningPart1>();
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();
			
			XPathFactory xFactory = XPathFactory.instance();
			
			XPathExpression<Element> expr = xFactory.compile("//Questions/Question", Filters.element());
			
			List<Element> listQuestion = expr.evaluate(doc);
			
			String pic, sound;
			char answer;
			String[] choices = new String[4];
			int i;
			//We got all question in part1, we need to build object
			for(Element questionElement : listQuestion){
				
				pic = questionElement.getChildText("pic");
				sound = questionElement.getChildText("sound");
				List<Element> choices_xml =  questionElement.getChild("choice").getChildren();
				i = 0;
				answer = 'E';
				for(Element choice : choices_xml){		
					if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
						answer = choice.getName().charAt(0);
						//System.out.println("Answer " + answer);
					}
					choices[i] = choice.getText();
					//System.out.println("Choice : " + choices[i]);
				}
				//System.out.println(pic + " " + sound);
				if(answer != 'E')
					listIdq.add(new ListeningPart1(pic, sound, choices, answer));
				else
					throw new Exception("Error : answer not found");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	public static void main(String[] args){
		ParserXml p = new ParserXml();
		p.getListeningPart1();
	}
}
