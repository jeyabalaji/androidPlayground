package components.android.jeyabalaji.androidplayground;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    public TextView contactName;
    public TextView contactNumber;

    public ViewHolder(View itemView)
    {
        super(itemView);
        contactName = (TextView) itemView.findViewById(R.id.contactName);
        contactNumber = (TextView) itemView.findViewById(R.id.contactNumber);
    }
}
