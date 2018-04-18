package edu.ap.spring.model;
import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EightBall {

	private Random gen;
	private int[] randomNumberArray;
    @Autowired
    private QuestionRepository repository;

	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};

	private int counter;
	public String getRandomAnswer(String question) {
        Question questionInDb = repository.findByQuestion(question);
        String answer = "";
        if (questionInDb != null) {
            if(questionInDb.getQuestion() == question) {
                return questionInDb.getAnswer();
            }
        }else{
            answer = answers[randomNumberArray[counter]];
            counter++;
            if(counter > 9){
                counter = 0;
                fillRandomNumberArray();
            }
        }
        return answer;
	}

    public EightBall() {
	    gen = new Random();
        randomNumberArray = new int[answers.length];
        fillRandomNumberArray();
        counter = 0;
    }

    public void fillRandomNumberArray(){
        for (int i = 0; i < randomNumberArray.length; i++) {
            randomNumberArray[i] = gen.nextInt(10);
        }
    }

    public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
