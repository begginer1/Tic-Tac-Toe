package com.example.tic_tac_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int i, j;
    ImageView iv;
    String winply;
    int playstatus;
    int chances=9;
    //o-o
    //1-x
    // 5=null
    int location[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int winningloc[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv.setText("O's Turn Next");
    }

    public void something(View v) {
        iv = (ImageView) v;
        chances--;
        if(chances==0)
        {
            AlertDialog.Builder ad=new AlertDialog.Builder(this);
            ad.setMessage("Match is Draw\nWanna Play Again?");
            ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    rerun();
                }
            });
            ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    finish();

                }
            });
            ad.setCancelable(false);
            ad.show();
        }

        int position = Integer.parseInt(iv.getTag().toString());
        if (location[position] == -1) {

            if (playstatus == 0) {

                iv.setImageResource(R.drawable.o);
                location[position] = 0;
                tv.setText("X's Turn to Play");
                playstatus = 1;
            }
            else {
                iv.setImageResource(R.drawable.x);
                playstatus = 0;
                tv.setText("0's turn to Play");
                location[position] = 1;
            }

        }
        int sum=9;
         winply="";
        for (i = 0,j=0; i < 8; i++) {

                if((location[winningloc[i][j]]==location[winningloc[i][j+1]])&&(location[winningloc[i][j+1]]==location[winningloc[i][j+2]])&&location[winningloc[i][j+1]]!=-1)
                    sum=location[winningloc[i][j]];
            if (sum == 0 || sum == 1){
                winply = (sum == 0) ? "Player with O" : " Player with X";
            break;
        }
        }
        if(winply!="")
        {
            AlertDialog.Builder ad=new AlertDialog.Builder(this);
            ad.setMessage(winply+" Wins!\nWanna Play Again?");
            ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    rerun();
                }
            });
            ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });
            ad.setCancelable(false);
            ad.show();
        }

    }
    public void rerun()
    {
        for(i=0;i<8;i++)
            location[i]=-1;
        ImageView iv;
        iv=findViewById(R.id.imageView1);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView2);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView3);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView4);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView5);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView6);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView7);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView8);
        iv.setImageResource(0);
        iv=findViewById(R.id.imageView9);
        iv.setImageResource(0);
        tv.setText("0's Player turn");
        playstatus=0;
        chances=9;
        winply="";
    }
}