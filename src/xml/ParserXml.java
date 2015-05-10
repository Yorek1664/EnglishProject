package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.*;
import org.jdom2.output.*;
import org.jdom2.xpath.*;

import Model.PartQuestion;
import Model.PartQuestion.TypeQuestion;
import Model.Question;

public class ParserXml {
	
	private final String xml_file_listening_part1 = "ListQuestionsPart1.xml";
	
	private final String xml_file_listening_part2 = "ListQuestionsPart2.xml";
	
	private final String xml_file_listening_part3 = "ListQuestionsPart3.xml";
	
	private final String xml_file_listening_part4 = "ListQuestionsPart4.xml";
	
	private final String xml_file_reading_part1 = "ListQuestionsPart5.xml";

	
	public List<PartQuestion> getListeningPart1(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_listening_part1);
		List<PartQuestion> listIdq = new ArrayList<PartQuestion>();
		
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();
			
			List<Element> listQuestion = rootNode.getChildren();
			
			String pic, sound;
			String answer;
			String[] choices = new String[4];
			int i;
			//We got all question in part1, we need to build object
			for(Element questionElement : listQuestion){
				
				PartQuestion question = new PartQuestion();
				question.setType(TypeQuestion.Image);
				
				pic = questionElement.getChildText("pic");
				question.setPicture(pic);
				
				sound = questionElement.getChildText("sound");
				question.setSoundFile(sound);
				
				List<Element> choices_xml =  questionElement.getChild("choice").getChildren();
				i = 0;
				Question q = new Question();
				for(Element choice : choices_xml){		
					//System.out.println("Answer? " + choice.getAttribute("answer").getValue().trim());
					if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
						q.setGoodAnswer(choice.getName());
						//System.out.println("Answer " + answer);
					}
					System.out.println(choice.getText());
					q.addAnswers(choice.getName().trim());
					
					//System.out.println("Choice : " + choices[i]);
					
				}
				//System.out.println(pic + " " + sound);
					//listIdq.add(new Question(pic, sound, choices, answer));
				question.addQuestion(q);
				listIdq.add(question);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	public List<PartQuestion> getListeningPart2(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_listening_part2);
		List<PartQuestion> listIdq = new ArrayList<PartQuestion>();
		
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();
			
			List<Element> listQuestion = rootNode.getChildren();
			
			String pic, sound;
			String answer;
			String[] choices = new String[4];
			int i;
			//We got all question in part1, we need to build object
			for(Element questionElement : listQuestion){
				
				PartQuestion question = new PartQuestion();
				question.setType(TypeQuestion.Listen);
				
				sound = questionElement.getChildText("sound");
				question.setSoundFile(sound);
				
				List<Element> choices_xml =  questionElement.getChild("choice").getChildren();
				i = 0;
				Question q = new Question();;
				for(Element choice : choices_xml){		
					//System.out.println("Answer? " + choice.getAttribute("answer").getValue().trim());
					if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
						q.setGoodAnswer(choice.getName());
						//System.out.println("Answer " + answer);
					}
					System.out.println(choice.getText());
					q.addAnswers(choice.getText());
					
					//System.out.println("Choice : " + choices[i]);
					
				}
				//System.out.println(pic + " " + sound);
					//listIdq.add(new Question(pic, sound, choices, answer));
				question.addQuestion(q);
				listIdq.add(question);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	public List<PartQuestion> getListeningPart3(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_listening_part3);
		List<PartQuestion> listIdq = new ArrayList<PartQuestion>();
		
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();

			List<Element> listQuestion = rootNode.getChildren();
			
			String pic, sound;
			String answer;
			String[] choices = new String[4];
			//We got all question in part1, we need to build object
			
			for(Element questionElement : listQuestion){
				
				PartQuestion question = new PartQuestion();
				question.setType(TypeQuestion.Listen);
				
				sound = questionElement.getChildText("sound");
				question.setSoundFile(sound);
				
				for(int i = 1; i < 4; i++){
					Question q = new Question();
					XPathFactory xFactory = XPathFactory.instance();
					
					System.out.println("label[@id='"+i+"']");
					XPathExpression<Element> expr = xFactory.compile("label[@id='"+i+"']", Filters.element());
					List<Element> label = expr.evaluate(questionElement);
					
					q.setQuestion(label.get(0).getText());
					
					
					expr = xFactory.compile("choice[@id='"+i+"']", Filters.element());
					
					List<Element> choices_xml = expr.evaluate(questionElement);
					
					List<Element> elem = choices_xml.get(0).getChildren();
					
					for(Element choice : elem){		
						
						//System.out.println("Answer? " + choice.getAttribute("answer").getValue().trim());
						if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
							q.setGoodAnswer(choice.getName());
							//System.out.println("Answer " + answer);
						}
						System.out.println(choice.getText());
						q.addAnswers(choice.getText());
						
						//System.out.println("Choice : " + choices[i]);
						
					}
					//System.out.println(pic + " " + sound);
						//listIdq.add(new Question(pic, sound, choices, answer));
					question.addQuestion(q);
					}
				listIdq.add(question);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	public List<PartQuestion> getListeningPart4(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_listening_part4);
		List<PartQuestion> listIdq = new ArrayList<PartQuestion>();
		
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();

			List<Element> listQuestion = rootNode.getChildren();
			
			String pic, sound;
			String answer;
			String[] choices = new String[4];
			//We got all question in part1, we need to build object
			
			for(Element questionElement : listQuestion){
				
				PartQuestion question = new PartQuestion();
				question.setType(TypeQuestion.Listen);
				
				sound = questionElement.getChildText("sound");
				question.setSoundFile(sound);
				
				for(int i = 1; i < 4; i++){
					Question q = new Question();
					XPathFactory xFactory = XPathFactory.instance();
					
					System.out.println("label[@id='"+i+"']");
					XPathExpression<Element> expr = xFactory.compile("label[@id='"+i+"']", Filters.element());
					List<Element> label = expr.evaluate(questionElement);
					
					q.setQuestion(label.get(0).getText());
					
					
					expr = xFactory.compile("choice[@id='"+i+"']", Filters.element());
					
					List<Element> choices_xml = expr.evaluate(questionElement);
					
					List<Element> elem = choices_xml.get(0).getChildren();
					
					for(Element choice : elem){		
						
						//System.out.println("Answer? " + choice.getAttribute("answer").getValue().trim());
						if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
							q.setGoodAnswer(choice.getName());
							//System.out.println("Answer " + answer);
						}
						System.out.println(choice.getText());
						q.addAnswers(choice.getText());
						
						//System.out.println("Choice : " + choices[i]);
						
					}
					//System.out.println(pic + " " + sound);
						//listIdq.add(new Question(pic, sound, choices, answer));
					question.addQuestion(q);
					}
				listIdq.add(question);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	
	public List<PartQuestion> getReadingPart1(){
		
		SAXBuilder sax = new SAXBuilder();
		
		File file = new File(xml_file_reading_part1);
		List<PartQuestion> listIdq = new ArrayList<PartQuestion>();
		
		try{
			Document doc = sax.build(file);
			
			Element rootNode = doc.getRootElement();
			
			List<Element> listQuestion = rootNode.getChildren();
			
			String pic, sound;
			String answer;
			String[] choices = new String[4];
			int i;
			//We got all question in part1, we need to build object
			for(Element questionElement : listQuestion){
				
				PartQuestion question = new PartQuestion();
				question.setType(TypeQuestion.read);
				
				
				List<Element> choices_xml =  questionElement.getChild("choice").getChildren();
				i = 0;
				
				Question q = new Question();
				q.setQuestion(questionElement.getChild("label").getText());
				
				System.out.println(questionElement.getChild("label").getText());
				for(Element choice : choices_xml){		
					//System.out.println("Answer? " + choice.getAttribute("answer").getValue().trim());
					if(choice.getAttribute("answer").getValue().trim().compareTo("true") == 0){
						q.setGoodAnswer(choice.getName());
						//System.out.println("Answer " + answer);
					}
					System.out.println(choice.getText());
					q.addAnswers(choice.getText());
					
					//System.out.println("Choice : " + choices[i]);
					
				}
				//System.out.println(pic + " " + sound);
					//listIdq.add(new Question(pic, sound, choices, answer));
				question.addQuestion(q);
				listIdq.add(question);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listIdq;
	}
	
	public static void main(String[] args){
		ParserXml p = new ParserXml();
		//p.getReadingPart1();
		p.getListeningPart4();
	}
}
