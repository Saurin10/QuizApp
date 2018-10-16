package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Score variable
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        score = resetScore();
        displayScoreHeading("Score Card:");
        score = calculateScore(score);
        String sName = ((EditText) findViewById(R.id.uName)).getText().toString();
        String scoreSummary = getString(R.string.studentName, sName);
        scoreSummary += '\n' + getString(R.string.score, String.valueOf(score));
        String performance = checkPerformance();
        scoreSummary += '\n' + getString(R.string.performance, performance);
        String analysis = detailAnalysis();
        scoreSummary += '\n' + getString(R.string.analysis, analysis);
        displayMessage(scoreSummary);
    }

    private int calculateScore(int s) {
        s += q1();
        s += q2();
        s += q3();
        s += q4();
        s += q5();
        return s;
    }

    private int resetScore() {
        return 0;
    }

    private int q1() {
        boolean q1_B = ((RadioButton) findViewById(R.id.q1_B)).isChecked();
        if (q1_B)
            return 1;
        return 0;
    }

    private int q2() {
        boolean q2_A = ((CheckBox) findViewById(R.id.q2_A)).isChecked();
        boolean q2_B = ((CheckBox) findViewById(R.id.q2_B)).isChecked();
        boolean q2_C = ((CheckBox) findViewById(R.id.q2_C)).isChecked();
        if (q2_A && q2_B && q2_C)
            return 1;
        return 0;
    }

    private int q3() {
        String ans = ((EditText) findViewById(R.id.q3_ans)).getText().toString();
        if (ans.equals("STACK") || ans.equals("STACK "))
            return 1;
        return 0;
    }

    private int q4() {
        boolean q4_B = ((RadioButton) findViewById(R.id.q4_B)).isChecked();
        if (q4_B)
            return 1;
        return 0;
    }

    private int q5() {
        String ans = ((EditText) findViewById(R.id.q5_ans)).getText().toString();
        if (ans.equals("PUSH") || ans.equals("PUSH "))
            return 1;
        return 0;
    }

    private String detailAnalysis() {
        String analysis = "\n";
        if (q1() == 1)
            analysis += "Q1 Correct\n";
        if (q1() == 0)
            analysis += "Q1 Wrong\n";
        if (q2() == 1)
            analysis += "Q2 Correct\n";
        if (q2() == 0)
            analysis += "Q2 Wrong\n";
        if (q3() == 1)
            analysis += "Q3 Correct\n";
        if (q3() == 0)
            analysis += "Q3 Wrong\n";
        if (q4() == 1)
            analysis += "Q4 Correct\n";
        if (q4() == 0)
            analysis += "Q4 Wrong\n";
        if (q5() == 1)
            analysis += "Q5 Correct";
        if (q5() == 0)
            analysis += "Q5 Wrong";
        return analysis;
    }

    private String checkPerformance() {
        if (score >= 4)
            return "Awesome, Excellent Score!!";
        else if (score > 2)
            return "Needs to brush up your knowledge, Average Score!!";
        else
            return "Needs to start from scratch, Poor Score!!";
    }

    private void displayScoreHeading(String message) {
        TextView orderSummaryTextView = findViewById(R.id.score_heading);
        orderSummaryTextView.setText(message);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.score_summary);
        orderSummaryTextView.setText(message);
    }
}
