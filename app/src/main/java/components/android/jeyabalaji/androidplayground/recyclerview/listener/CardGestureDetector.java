package components.android.jeyabalaji.androidplayground.recyclerview.listener;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class CardGestureDetector extends GestureDetector.SimpleOnGestureListener
{
    RecyclerView recyclerView;
    CardSelectedListener.CardSelectAction clickListener;

    public CardGestureDetector(RecyclerView recyclerView, CardSelectedListener.CardSelectAction clickListener) {
        this.recyclerView = recyclerView;
        this.clickListener = clickListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null) {
            clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
        }
    }
}
