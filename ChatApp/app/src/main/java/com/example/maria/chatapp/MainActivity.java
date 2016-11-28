package com.example.maria.chatapp;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private ChatAdapter chat;
    private ChatFactory factory = new ChatFactory();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.chat_list);
        chat = new ChatAdapter(this.getBaseContext());
        listView.setAdapter(chat);

        registerForContextMenu(listView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.chat_list)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle("Delete message");
            getMenuInflater().inflate(R.menu.menu_item, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(item.getItemId() == R.id.remove) {
            chat.messages.remove(info.position);
            chat.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    public	boolean	onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_bar,	menu);
        return	true;
    }

    public	boolean	onOptionsItemSelected(MenuItem	item)
    {
        int	id	=	item.getItemId();
        if	(id	==	R.id.clear)
        {
            chat.clear();
            chat.notifyDataSetChanged();
            return	true;
        } else if(id	==	R.id.reset) {
            chat = new ChatAdapter(this.getBaseContext());
            listView.setAdapter(chat);
        } else if(id	==	R.id.add) {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm:ss a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
            String localTime = date.format(currentLocalTime);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String currentDate = sdf.format(new Date());

            chat.messages.add(new Message(2, "Maria", localTime, currentDate, "another message"));
            chat.notifyDataSetChanged();
            Object _progressTimer = new CountDownTimer(3000, 3000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
                    Date currentLocalTime = cal.getTime();
                    DateFormat date = new SimpleDateFormat("HH:mm:ss a");
                    date.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
                    String localTime = date.format(currentLocalTime);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String currentDate = sdf.format(new Date());

                    chat.messages.add(new Message(3, "Computer", localTime, currentDate, "message from computer"));
                    chat.notifyDataSetChanged();
                }
            }.start();
        }
        return	super.onOptionsItemSelected(item);
    }
}
