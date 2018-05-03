package com.ebookfrenzy.floatingbuttonapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;

/**
 * Created by subhita.menon on 25/04/2018.
 */

public class MyAdapter extends BaseAdapter {
    Context ct;
    ArrayList<Integer> al;
    MyAdapter(Context c)
    {
        ct=c;
        al = new ArrayList<>();
        addItem();

    }

    void addItem()
    {
        for(int i=0; i<20;i++)
        {
            al.add(R.drawable.image1);
        }

    }
    @Override
    public int getCount() {
        return al.size();
    }


    @Override
    public Object getItem(int i)
        {
            return al.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckableLayout cl;
        ImageView iv;
        if(view == null)
        {
            iv = new ImageView(ct);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new LayoutParams(100,100));

            cl = new CheckableLayout(ct);
            cl.setLayoutParams(new LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT));

            cl.addView(iv);

        }
        else
        {
            cl = (CheckableLayout)view;
            iv = (ImageView)cl.getChildAt(0);
        }

        iv.setImageResource((int)al.get(i));
        return cl;

        /*Activity at = (Activity)ct;
        View v = at.getLayoutInflater().inflate(R.layout.my_layout,null);

        ImageView iv = v.findViewById(R.id.iv);

        iv.setImageResource((int)al.get(i));


        return v;*/
    }

    class CheckableLayout extends FrameLayout implements Checkable
    {
        boolean isChecked = false;

        CheckableLayout(Context c)
        {
            super(c);
        }
        @Override
        public void setChecked(boolean b) {
            if (isChecked != b)
            {
                isChecked = b;
                refreshDrawableState();
            }


        }

        @Override
        public boolean isChecked() {
            return isChecked;
        }

        @Override
        public void toggle() {

        }


    }
}
