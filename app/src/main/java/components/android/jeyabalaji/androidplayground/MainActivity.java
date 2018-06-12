package components.android.jeyabalaji.androidplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import components.android.jeyabalaji.androidplayground.recyclerview.Adapter;
import components.android.jeyabalaji.androidplayground.recyclerview.Contact;
import components.android.jeyabalaji.androidplayground.recyclerview.listener.CardSelectedListener;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter dataAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Contact> contactListInView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.reCyclerView);
        //recyclerView.setHasFixedSize(true);

        dataAdapter = new Adapter(contactListInView);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(dataAdapter);

        addDataToList();

        recyclerView.addOnItemTouchListener(new CardSelectedListener(
                getApplicationContext(),
                recyclerView,
                new CardSelectedListener.CardSelectAction()
                {
                    @Override
                    public void onClick(View view, int position)
                    {
                        Contact selectedContact = contactListInView.get(position);
                        Toast.makeText(getApplicationContext(), selectedContact.getName(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongClick(View view, int position)
                    {

                    }
                }));
    }

    private void addDataToList() {
        Contact jeyaBalaji = new Contact("JeyaBalaji", "902-579-7993");
        contactListInView.add(jeyaBalaji);

        Contact Susila = new Contact("Susila", "902-579-7992");
        contactListInView.add(Susila);

        Contact samuthiravelu = new Contact("Samuthiravelu", "902-579-7991");
        contactListInView.add(samuthiravelu);

        dataAdapter.notifyDataSetChanged();
    }
}
