package components.android.jeyabalaji.androidplayground.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import components.android.jeyabalaji.androidplayground.R;

public class Adapter extends RecyclerView.Adapter<ViewHolder>
{

    List<Contact> contacts;

    public Adapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactcard, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Contact contactToBeDisplayed = contacts.get(position);
        holder.contactName.setText(contactToBeDisplayed.getName());
        holder.contactNumber.setText(contactToBeDisplayed.getPhoneNumber());
    }

    @Override
    public int getItemCount()
    {
        return contacts.size();
    }
}
