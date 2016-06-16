package es.rul3s.raul.wifisecurityauditor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent changeAct;
        switch (item.getItemId()) {
            case R.id.menu_Settings:
                changeAct = new Intent(this,SettingsActivity.class);
                startActivity(changeAct);
                return true;
            case R.id.menu_About:
                changeAct = new Intent(this,AboutActivity.class);
                startActivity(changeAct);
                return true;
            case R.id.menu_Subscribe:
                Toast.makeText(context, "Subscribed to important news", Toast.LENGTH_SHORT).show();
                FirebaseMessaging.getInstance().subscribeToTopic("news");
                return true;
            case R.id.menu_UnSubscribe:
                Toast.makeText(context, "UNSubscribed from important news", Toast.LENGTH_SHORT).show();
                FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void btScan(View view){
        Intent changeAct = new Intent(this,ScanActivity.class);
        startActivity(changeAct);
    }

    public void btManual(View view){
        Intent changeAct = new Intent(this,ManualConnectActivity.class);
        startActivity(changeAct);
    }

    public void btDBSearch(View view){
        Intent changeAct = new Intent(this,ManualConnectActivity.class);
        startActivity(changeAct);
    }

    public void btTestJson(View view){
        Intent changeAct = new Intent(this,TestGetActivity.class);
        startActivity(changeAct);
    }
}
