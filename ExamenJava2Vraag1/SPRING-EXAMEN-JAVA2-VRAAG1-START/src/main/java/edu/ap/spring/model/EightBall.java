package edu.ap.spring.model;
import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EightBall {

	private Random gen;
	private List<Integer> randomNumberArray;
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
            System.out.println("log:" + questionInDb.getQuestion());
            if(questionInDb.getQuestion().equals(question)) {
                return questionInDb.getAnswer();
            }
        }else{
            if(counter >= answers.length){
                counter = 0;
                fillRandomNumberArray();
            }
            answer = answers[randomNumberArray.get(counter)];
            counter++;
        }
        Question questionToSave = new Question(question,answer);
        repository.save(questionToSave);
        return answer;
	}

    public EightBall() {
	    gen = new Random();
        //randomNumberArray = new int[answers.length];
        randomNumberArray = new ArrayList<>();
        fillRandomNumberArray();
        counter = 0;
    }

    public void fillRandomNumberArray(){
	    randomNumberArray.clear();
	    int randomNumber;
        for (int i = 0; i < answers.length; i++) {

            randomNumber = gen.nextInt(answers.length);
            while (randomNumberArray.contains(randomNumber)){
                randomNumber = gen.nextInt(answers.length);
            }
            randomNumberArray.add(i,randomNumber);
        }
    }

    public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
