package assignment17.acadgild.com.assignment17;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MusicPlayerService extends Service {
    //create a variable to hold the mediaplayer
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        //call super on create
        super.onCreate();
        //set the reference of mediaplayer to the play mp3
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.play);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Make toast message that says the music should be playing
        Toast.makeText(MusicPlayerService.this,"Playing Music!",Toast.LENGTH_LONG).show();
        //tells the mediaplayer to start playing music
        mediaPlayer.start();
        //returns the on start command super with intent flags and startid
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean stopService(Intent name) {
        //create a new pending intent since the assignment said use a pendingintent and return it to the mainactivity
        //the requirement really confused me i am not sure what you want me to do with the pending intent and you didnt really do any pendingintent in this class session for 17
        //I have no idea if i should keep this or remove it but assignment required a pendingintent not sure what it is supposed to do though.
        //Id ask but it would take too long to wait for a response.
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,name,PendingIntent.FLAG_UPDATE_CURRENT);
        //try send the pending intent
        try {
            pendingIntent.send();
            //a catch in case the try fails
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
        //tells the mediaplayer to stop playing music
        mediaPlayer.stop();
        //returns the super for on stop with the name intent
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        //Make toast message that says the music should stop playing
        Toast.makeText(MusicPlayerService.this,"Stopping Music!",Toast.LENGTH_LONG).show();
        //released the mediaplayer in case another app needs it or wants it, also frees up memory no use holding onto it when not in use
        mediaPlayer.release();
        //call the super on destroy
        super.onDestroy();

    }
}
