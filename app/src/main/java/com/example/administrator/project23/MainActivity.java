package com.example.administrator.project23;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String Tag="MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new ContractsObserver(new Handler()));

    }
    private final class ContractsObserver extends ContentObserver{
        public ContractsObserver(Handler handler){
            super(handler);
        }
        public void onChange(boolean selfchange){
            Log.v(Tag,"联系人信息发生变化");
            Toast.makeText(MainActivity.this,"联系人信息发生变化",Toast.LENGTH_LONG).show();
        }
    }
}
