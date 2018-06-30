package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    final String answerToQuestion3 = "LIONS";
    final String answerToQuestion4 = "TEMPERATURE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void calculateScore(){
        RadioButton radioButton1 = findViewById(R.id.radiobutton_answer1);
        RadioButton radioButton2 = findViewById(R.id.radiobutton_answer2);
        EditText submitAnswer3 = findViewById(R.id.answer_question3);
        EditText submitAnswer4 = findViewById(R.id.answer_question4);
        CheckBox answer1 = findViewById(R.id.checkbox_answer1);
        CheckBox answer2 = findViewById(R.id.checkbox_answer2);
        CheckBox answer3 = findViewById(R.id.checkbox_answer3);
        CheckBox answer4 = findViewById(R.id.checkbox_answer4);
        CheckBox option1 = findViewById(R.id.checkbox_option1);
        CheckBox option2 = findViewById(R.id.checkbox_option2);
        CheckBox option3 = findViewById(R.id.checkbox_option3);
        CheckBox option4 = findViewById(R.id.checkbox_option4);
        String userAnswer3 = submitAnswer3.getText().toString().toUpperCase();
        String userAnswer4 = submitAnswer4.getText().toString().toUpperCase();

        if(radioButton1.isChecked()){
            score+=1;
        }

        if(radioButton2.isChecked()){
            score+=1;
        }

        checkFreeText(answerToQuestion3, userAnswer3);
        checkFreeText(answerToQuestion4, userAnswer4);

        checkMultipleChoice(answer1, answer2, option1, option2);
        checkMultipleChoice(answer3, answer4, option3, option4);

    }


    /** This method determines if the answer submitted for the free text questions is correct
     * @param answer is the correct answer to the question
     * @param submitted  is the answer submitted by the user
     **/
    public void checkFreeText(String answer, String submitted){
        if (submitted.equals(answer)){
            score+=1;
        }
    }

    /** This method determines if the answer submitted for the free text questions is correct
     * @param answer1 is a correct option answer to the question
     * @param answer2 is a correct option answer to the question
     * @param option1 is a wrong option answer to the question
     * @param option2 is a wrong option answer to the question
     **/
    public void checkMultipleChoice(CheckBox answer1, CheckBox answer2, CheckBox option1, CheckBox option2){
        if (answer1.isChecked() &&  answer2.isChecked()){
            if(!option1.isChecked() && !option2.isChecked()){
                score+=1;
            }
        }
    }

    public void displayScore(View view){
        calculateScore();
        Toast.makeText(this, "You answered "+ score +" of 6 questions correctly.", Toast.LENGTH_SHORT).show();
        score = 0;
    }
}
