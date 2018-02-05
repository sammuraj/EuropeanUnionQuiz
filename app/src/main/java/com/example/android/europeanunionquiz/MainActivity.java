package com.example.android.europeanunionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers (View view) {
        //check 1. question
       RadioButton currency = findViewById(R.id.radio_euro);
       //check if the correct answer is chosen
       boolean hasEuro = currency.isChecked();
       //if is add one point and show the green hint
       if (hasEuro) {
           points++;
           TextView hint1 = findViewById(R.id.response_1);
           hint1.setText(R.string.correct);
           hint1.setTextColor(this.getResources().getColor(R.color.colorGreen));
       }
       //if isn't show the red hint
       else {
           TextView hint1 = findViewById(R.id.response_1);
           hint1.setText(R.string.wrong);
           hint1.setTextColor(this.getResources().getColor(R.color.colorRed));
       }
       //check the 2. answer if it's correct
        EditText numberOfCountries = findViewById(R.id.members);
        String members = numberOfCountries.getText().toString();
        //if is add one point and show the green hint
        if (members.contentEquals("28")){
            points++;
            TextView hint2 = findViewById(R.id.response_2);
            hint2.setText(R.string.correct);
            hint2.setTextColor(this.getResources().getColor(R.color.colorGreen));
        }
        //if isn't show the red hint
        else {
            TextView hint2 = findViewById(R.id.response_2);
            hint2.setText(R.string.wrong);
            hint2.setTextColor(this.getResources().getColor(R.color.colorRed));
        }
        //check 3. question
        CheckBox norway = findViewById(R.id.norway);
        boolean hasNorway = norway.isChecked();
        CheckBox poland = findViewById(R.id.poland);
        boolean hasPoland = poland.isChecked();
        CheckBox turkey = findViewById(R.id.turkey);
        boolean hasTurkey = turkey.isChecked();
        CheckBox slovakia = findViewById(R.id.slovakia);
        boolean hasSlovakia = slovakia.isChecked();
        CheckBox switzerland = findViewById(R.id.switzerland);
        boolean hasSwitzerland = switzerland.isChecked();
        CheckBox greece = findViewById(R.id.greece);
        boolean hasGreece = greece.isChecked();

        //only when all countries are correctly checked or unchecked add one point and show green hint
        if (hasNorway && !hasPoland && hasTurkey && !hasSlovakia && hasSwitzerland && !hasGreece) {
            points++;
            TextView hint3 = findViewById(R.id.response_3);
            hint3.setText(R.string.correct);
            hint3.setTextColor(this.getResources().getColor(R.color.colorGreen));
        }
        //if anything is not correct show red hint
        else {
            TextView hint3 = findViewById(R.id.response_3);
            hint3.setText(R.string.wrong);
            hint3.setTextColor(this.getResources().getColor(R.color.colorRed));
        }
        //check if 4. question is correct
        RadioButton anthem = findViewById(R.id.radio_beethoven);
        boolean hasAnthem = anthem.isChecked();
        //if is add one point and show the green hint
        if (hasAnthem) {
            points++;
            TextView hint4 = findViewById(R.id.response_4);
            hint4.setText(R.string.correct);
            hint4.setTextColor(this.getResources().getColor(R.color.colorGreen));
        }
        //if isn't show the red hint
        else{
            TextView hint4 = findViewById(R.id.response_4);
            hint4.setText(R.string.wrong);
            hint4.setTextColor(this.getResources().getColor(R.color.colorRed));
        }

        //check the last question if it's correct
        RadioButton flag = findViewById(R.id.flag_b);
        boolean hasFlag = flag.isChecked();

        //if is add one point and show the green hint
        if (hasFlag) {
            points++;
            TextView hint5 = findViewById(R.id.response_5);
            hint5.setText(R.string.correct);
            hint5.setTextColor(this.getResources().getColor(R.color.colorGreen));
        }
        //if isn't show the red hint
        else {
            TextView hint5 = findViewById(R.id.response_5);
            hint5.setText(R.string.wrong);
            hint5.setTextColor(this.getResources().getColor(R.color.colorRed));
        }

        //show the final status
        TextView finalScore = findViewById(R.id.score_text);
        //status for one earned point
        if (points == 1) {
            finalScore.setText(getString(R.string.number_of_points) + " " + points + " point out of 5.");
        }
        //status for more points
        else {
            finalScore.setText(getString(R.string.number_of_points) + " " + points + " points out of 5.");
        }
        //delete the score
        points =0;
    }
    //method called to delete all changes in the quiz
    public void onReset (View view) {
        //deleting the radiogroups choosen buttons
    RadioGroup radioGroup1 = findViewById(R.id.radio_group1);
    radioGroup1.clearCheck();
    RadioGroup radioGroup2 = findViewById(R.id.radio_group2);
    radioGroup2.clearCheck();
    RadioGroup radioGroup3 = findViewById(R.id.radio_group3);
    radioGroup3.clearCheck();

    //deleting the answer if it's wrong or right
    TextView hint1 = findViewById(R.id.response_1);
    hint1.setText("");
    TextView hint2 = findViewById(R.id.response_2);
    hint2.setText("");
    TextView hint3 = findViewById(R.id.response_3);
    hint3.setText("");
    TextView hint4 = findViewById(R.id.response_4);
    hint4.setText("");
    TextView hint5 = findViewById(R.id.response_5);
    hint5.setText("");

    //delete 2. answer
    EditText numberOfCountries = findViewById(R.id.members);
    numberOfCountries.setText("");

    //delete 3. answer
    CheckBox norway = findViewById(R.id.norway);
    norway.setChecked(false);
    CheckBox poland = findViewById(R.id.poland);
    poland.setChecked(false);
    CheckBox turkey = findViewById(R.id.turkey);
    turkey.setChecked(false);
    CheckBox slovakia = findViewById(R.id.slovakia);
    slovakia.setChecked(false);
    CheckBox switzerland = findViewById(R.id.switzerland);
    switzerland.setChecked(false);
    CheckBox greece = findViewById(R.id.greece);
    greece.setChecked(false);

    //delete the final score message
    TextView finalScore = findViewById(R.id.score_text);
    finalScore.setText(R.string.number_of_points);
    points = 0;
    }
}