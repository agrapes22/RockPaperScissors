package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button bt_Rock, bt_Scissors, bt_Paper;
    TextView tv_Score;
    ImageView iv_ComputerChoice, iv_HumanChoice;

    int playScore = 0;
    int compScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Rock = (Button) findViewById(R.id.bt_Rock);
        bt_Paper = (Button) findViewById(R.id.bt_Paper);
        bt_Scissors = (Button) findViewById(R.id.bt_Scissors);

        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice = (ImageView) findViewById(R.id.iv_HumanChoice);

        tv_Score = (TextView) findViewById(R.id.tv_Score);

        bt_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: Human: " + Integer.toString(playScore) +
                        " Computer Score: " + Integer.toString(compScore));
            }
        });

        bt_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: Human: " + Integer.toString(playScore) +
                        " Computer Score: " + Integer.toString(compScore));
            }
        });

        bt_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: Human: " + Integer.toString(playScore) +
                        " Computer Score: " + Integer.toString(compScore));
            }
        });


    }

    public String play_turn(String choice)
    {
        String computer_choice = "";
        Random r = new Random();
        int comp_choice_num = r.nextInt(3) + 1;



        if (comp_choice_num == 1)
        {
            computer_choice = "rock";
        }
        else if (comp_choice_num == 2)
        {
            computer_choice = "paper";
        }
        else if (comp_choice_num == 3)
        {
            computer_choice = "scissors";
        }

        if (computer_choice == "rock")
        {
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }
        else if (computer_choice == "paper")
        {
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }
        else if (computer_choice == "scissors")
        {
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }

        if (computer_choice == choice)
        {
            return "Draw. No one won";
        }
        else if (choice == "rock" && computer_choice == "scissors")
        {
            playScore++;
            return "Rock beats scissors. You win.";
        }
        else if (choice == "rock" && computer_choice == "paper")
        {
            compScore++;
            return "Paper beats rock. You lose.";
        }
        else if (choice == "paper" && computer_choice == "scissors")
        {
            compScore++;
            return "Scissors beats paper. You lose.";
        }
        else if (choice == "paper" && computer_choice == "rock")
        {
            playScore++;
            return "Paper beats rock. You win.";
        }
        else if (choice == "scissors" && computer_choice == "rock")
        {
            compScore++;
            return "Rock beats scissors. You lose.";
        }
        else if (choice == "scissors" && computer_choice == "paper")
        {
            playScore++;
            return "Scissors beats paper. You win.";
        }
        else
        {
            return "not sure what happened here";
        }
    }
}