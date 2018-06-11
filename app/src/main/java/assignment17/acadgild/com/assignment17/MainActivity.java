package assignment17.acadgild.com.assignment17;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //create a variable to hold the button start service
    private Button startServiceBtn;
    //create a variable to hold the button stop service
    private Button stopServiceBtn;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the content view to the layout activity main
        setContentView(R.layout.activity_main);
        //reference the variables to the button start id
        startServiceBtn = findViewById(R.id.btn_start);
        //reference the variables to the button stop id
        stopServiceBtn = findViewById(R.id.btn_stop);
        // set a click listener for when someone clicks the button start
        startServiceBtn.setOnClickListener(this);
        // set a click listener for when someone clicks the button stop
        stopServiceBtn.setOnClickListener(this);


    }

    //Click listener below
    @Override
    public void onClick(View v) {
        //get the id from the button thats clicked and then use case
        switch (v.getId()){
            //check the id from the button thats clicked if its button start then do this below
            case R.id.btn_start:
                //create a new start intent that starts the service that plays the song
                Intent startIntent = new Intent(MainActivity.this,MusicPlayerService.class);
//                pendingIntent = new PendingIntent(MainActivity.this);
                //starts the service with the intent
                startService(startIntent);
                //break out of the case statement otherwise it would continue on
                break;
            //check the id from the button thats clicked if its button stop then do this below
            case R.id.btn_stop:
                //create a new start intent that stops the service that was playing the song
                Intent stopIntent = new Intent(MainActivity.this,MusicPlayerService.class);
                //stops the service with the intent
                stopService(stopIntent);
                //break out of the case statement otherwise it would continue on
                break;
        }
    }


}
