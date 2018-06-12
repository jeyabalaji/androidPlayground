package components.android.jeyabalaji.androidplayground.recyclerview.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class CardSelectedListener implements RecyclerView.OnItemTouchListener
{
    private GestureDetector gestureDetector;
    public CardSelectAction clickListener;


    public CardSelectedListener(Context applicationContext, RecyclerView recyclerView, CardSelectAction selectAction) {
        this.clickListener = selectAction;
        gestureDetector = new GestureDetector(applicationContext, new CardGestureDetector(recyclerView, selectAction));
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
    {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            //Do the click action only if a TouchEvent happens.
            clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e)
    {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)
    {

    }

    /*
    * Will be defined by the user while using CardSelectedListener
    * */
    public interface CardSelectAction
    {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}

