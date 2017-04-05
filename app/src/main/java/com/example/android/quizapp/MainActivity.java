package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring global variables:
    int totalScore = 0;
    String scoreString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the button is clicked. It will display a Toast Message with Score.
     */
    public void getScore(View view) {
        // Reading the first answer of the quiz test.
        CheckBox checkBoxQuestion1 = (CheckBox) findViewById(R.id.answer_1);
        boolean answer_1 = checkBoxQuestion1.isChecked();
        if (answer_1) {
            totalScore++;

        }

        // Reading the second answer.
        EditText editTextQuestion2 = (EditText) findViewById(R.id.answer_2);
        String answer_2 = editTextQuestion2.getText().toString().toLowerCase().trim();
        Log.e("get the string", "The result is: " + answer_2);
        // Checking the result and adding the score if the answer is correct
        if (answer_2.compareTo("pangea") == 0) {
            totalScore++;
        }

        // Reading the third answer and checking the result.
        RadioGroup radioGroupQuestion3 = (RadioGroup) findViewById(R.id.question_3);
        int checkedIdQuestion3 = radioGroupQuestion3.getCheckedRadioButtonId();
        switch (checkedIdQuestion3) {
            case (R.id.op1_question3):
                totalScore++;
                break;
            case (R.id.op2_question3):
                break;
        }

        // Reading the fourth answer and checking the result.
        RadioGroup radioGroupQuestion4 = (RadioGroup) findViewById(R.id.question_4);
        int checkedIdQuestion4 = radioGroupQuestion4.getCheckedRadioButtonId();
        switch (checkedIdQuestion4) {
            case (R.id.op1_question4):
                break;
            case (R.id.op2_question4):
                break;
            case (R.id.op3_question4):
                totalScore++;
                break;
        }

        // Reading the fifth answer.
        EditText editTextAnswer5 = (EditText) findViewById(R.id.answer_5);
        String answer_5 = editTextAnswer5.getText().toString().toLowerCase().trim();
        if (answer_5.compareTo(getString(R.string.answer_question_5)) == 0) {
            totalScore++;
        }

        scoreString = displayScore(totalScore);
        Toast.makeText(this, scoreString, Toast.LENGTH_LONG).show();
        totalScore = 0;
    }

    /**
     * This method is for toasting the final score and based on that some text is displaying
     */
    public String displayScore(int result) {

        String score = "";

        switch (result) {
            case 0:
                score = getString(R.string.score_0_toast);
                break;
            case 1:
                score = getString(R.string.score_1_toast);
                break;
            case 2:
                score = getString(R.string.score_2_toast);
                break;
            case 3:
                score = getString(R.string.score_3_toast);
                break;
            case 4:
                score = getString(R.string.score_4_toast);
                break;
            case 5:
                score = getString(R.string.score_5_toast);
                break;
        }

        return score;
    }

    /**
     * This method is used when the share button is clicked.
     */
    public void shareIntent(View view) {
        // Reading the first answer of the quiz test.
        CheckBox checkBoxQuestion1 = (CheckBox) findViewById(R.id.answer_1);
        boolean answer_1 = checkBoxQuestion1.isChecked();
        if (answer_1) {
            totalScore++;
        }

        // Reading the second answer.
        EditText editTextQuestion2 = (EditText) findViewById(R.id.answer_2);
        String answer_2 = editTextQuestion2.getText().toString().toLowerCase().trim();

        // Checking the result and adding the score if the answer is correct
        if (answer_2.compareTo("pangea") == 0) {
            totalScore++;
        }

        // Reading the third answer and checking the result.
        RadioGroup radioGroupQuestion3 = (RadioGroup) findViewById(R.id.question_3);
        int checkedIdQuestion3 = radioGroupQuestion3.getCheckedRadioButtonId();
        switch (checkedIdQuestion3) {
            case (R.id.op1_question3):
                totalScore++;
                break;
            case (R.id.op2_question3):
                break;
        }

        // Reading the fourth answer and checking the result.
        RadioGroup radioGroupQuestion4 = (RadioGroup) findViewById(R.id.question_4);
        int checkedIdQuestion4 = radioGroupQuestion4.getCheckedRadioButtonId();
        switch (checkedIdQuestion4) {
            case (R.id.op1_question4):
                break;
            case (R.id.op2_question4):
                break;
            case (R.id.op3_question4):
                totalScore++;
                break;
        }

        // Reading the fifth answer.
        EditText editTextAnswer5 = (EditText) findViewById(R.id.answer_5);
        String answer_5 = editTextAnswer5.getText().toString().toLowerCase().trim();
        if (answer_5.compareTo(getString(R.string.answer_question_5)) == 0) {
            totalScore++;
        }
        scoreString = displayScore(totalScore);
        totalScore = 0;

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, scoreString);
        startActivity(share);
    }
}
