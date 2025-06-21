package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //0->X   1->O 2->NULL
    boolean gameactive=true;
    int activeplayer=0;
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int w=0;
    int[][] winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void clicked1(View view){
        ImageView img= (ImageView) view;
        TextView textView6=findViewById(R.id.textView6);
        int tappedposition=Integer.parseInt(img.getTag().toString());
        tappedposition=tappedposition-1;
        if(gamestate[tappedposition]==2 && gameactive){

            gamestate[tappedposition]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==0){
                w=w+1;

                img.setImageResource(R.drawable.x1);
                activeplayer=1;
                textView6.setText("O's TURN");
            }
            else{
                    w=w+1;
                img.setImageResource(R.drawable.o1);
                activeplayer=0;
                textView6.setText("X's TURN");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        if(w>4){
            for(int[] win:winposition){
                if(gamestate[win[0]]==gamestate[win[1]] && gamestate[win[1]]==gamestate[win[2]] && gamestate[win[1]]!=2){
                    if(activeplayer==0){
                    textView6.setText("O WON");
                    gameactive=false;}
                    else{
                        textView6.setText("X WON");
                    gameactive=false;}
                }
                }
            }

    }
    public void bclicked1(View view){
        gameactive=true;
        Button b=findViewById(R.id.button3);
        activeplayer=0;
        TextView textView6=findViewById(R.id.textView6);
        textView6.setText("X's TURN");
        for(int i=0;i<9;i++){
            gamestate[i]=2;
        }
        w=0;
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}