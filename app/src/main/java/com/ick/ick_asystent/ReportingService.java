package com.ick.ick_asystent;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class ReportingService extends Service {
    private boolean isRunning  = false;
    private Looper looper;
    private MyServiceHandler myServiceHandler;

    public ReportingService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        SharedPreferences sp = this.getSharedPreferences("com.ick.ick_asystent", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        //Toast.makeText(this, "Service Active", Toast.LENGTH_SHORT).show();

        editor.putString("user", "Uzytkownik Aplikacji");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


private final class MyServiceHandler extends Handler {
    public MyServiceHandler(Looper looper) {
        super(looper);
    }
    @Override
    public void handleMessage(Message msg) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Log.i(TAG, "MyService running...");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Log.i(TAG, e.getMessage());
                }
                if(!isRunning){
                    break;
                }
            }
        }
    }
}
}
