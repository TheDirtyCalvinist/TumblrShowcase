package com.ajh.TumblrShowcase;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

public class MenuActivity extends Activity {

    protected float menuWidth = 400;
    protected LinearLayout contentLayout, titleBar;
    protected FrameLayout menuFrame, contentFrame;
    protected Button menuButton;
    protected TextView menuBarTitle;
    protected MenuFragment menuFragment;
    protected WebViewFragment webViewFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        contentLayout = (LinearLayout) findViewById(R.id.content_layout);
        menuFrame = (FrameLayout) findViewById(R.id.menu_holder);
        contentFrame = (FrameLayout) findViewById(R.id.content_holder);
        menuButton = (Button) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(menuButtonOpenClickListener);
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome.ttf");
        menuButton.setTypeface(fontAwesome);
        menuButton.setText("\uf0c9");

        menuBarTitle = (TextView) findViewById(R.id.menu_title);
        titleBar = (LinearLayout) findViewById(R.id.title_bar);
        titleBar.setOnTouchListener(new TitleBarDragListener());

        menuFragment = new MenuFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.menu_holder, menuFragment);
        transaction.commit();

        webViewFragment = new WebViewFragment();
        transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.content_holder, webViewFragment);
        transaction.commit();

    }

    public void onResume(){
        super.onResume();
        menuFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TumblrBlog tumblr = (TumblrBlog) parent.getAdapter().getItem(position);
                webViewFragment.setURL(tumblr.getURL());
                menuBarTitle.setText(tumblr.getTitle());
                closeMenu();
            }
        });
    }

    protected View.OnClickListener menuButtonOpenClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int[] location = new int[2];
            v.getLocationInWindow(location);
            if(location[0] > 0)
                closeMenu();
            else
                openMenu();
        }
    };


    protected void openMenu(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(contentLayout, View.TRANSLATION_X, menuWidth);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    protected void closeMenu(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(contentLayout, View.TRANSLATION_X, 0);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    protected class TitleBarDragListener implements View.OnTouchListener {

        protected float initialTouchX;
        protected float initialViewX;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                {
                    initialTouchX = event.getRawX();
                    int[] location = new int[2];
                    view.getLocationInWindow(location);
                    initialViewX = location[0];
                    break;
                }
                case MotionEvent.ACTION_MOVE:
                {
                    float deltaX = event.getRawX() - initialTouchX;
                    int[] location = new int[2];
                    view.getLocationInWindow(location);
                    if(initialViewX + deltaX >= 0)
                        contentLayout.setTranslationX(initialViewX + deltaX);
                    break;
                }
                case MotionEvent.ACTION_UP:
                    float deltaX = Math.max(event.getRawX() - initialTouchX, 0);
                    if(deltaX > menuWidth / 2)
                    {
                        openMenu();
                    }
                    else
                    {
                        closeMenu();
                    }
                    initialTouchX = 0;
                    initialViewX = 0;
                    break;
            }
            return true;
        }
    }

}
