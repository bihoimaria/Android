package com.example.maria.mailapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MailAdapter listAdapter;
    private ListView listView;

    private MailFactory mails = new MailFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mail_list);
        listAdapter = new MailAdapter(this.getBaseContext());
        listView.setAdapter(listAdapter);

        registerForContextMenu(listView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.mail_list)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            Mail mail = mails.getMails().get(info.position);
            menu.setHeaderTitle(mail.getSubject());
            getMenuInflater().inflate(R.menu.mail_menu, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(item.getItemId() == R.id.citit) {
            final int first = listView.getFirstVisiblePosition();
            final int child_index = info.position - first;

            View child = listView.getChildAt(child_index);

            TextView sender = (TextView) child.findViewById(R.id.sender);
            TextView subject = (TextView) child.findViewById(R.id.subject);
            TextView content = (TextView) child.findViewById(R.id.content);

            sender.setTextColor(Color.BLUE);
            subject.setTextColor(Color.BLUE);
            content.setTextColor(Color.BLUE);
        }
        else if(item.getItemId() == R.id.necitit) {
            final int first = listView.getFirstVisiblePosition();
            final int child_index = info.position - first;

            View child = listView.getChildAt(child_index);

            TextView sender = (TextView) child.findViewById(R.id.sender);
            TextView subject = (TextView) child.findViewById(R.id.subject);
            TextView content = (TextView) child.findViewById(R.id.content);
            sender.setTextColor(Color.BLACK);
            subject.setTextColor(Color.BLACK);
            content.setTextColor(Color.BLACK);
        } else if(item.getItemId() == R.id.sterge) {

            listAdapter.mails.remove(info.position);
            mails.getMails().remove(info.position);
            listAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }
}
