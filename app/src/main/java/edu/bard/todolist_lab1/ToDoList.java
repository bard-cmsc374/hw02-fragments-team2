package edu.bard.todolist_lab1;
/*
  Most basic Todo List in two fragments.
 */
//import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class ToDoList extends FragmentActivity {
    public static String TAG = "todolab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment1 = fm.findFragmentById(R.id.button_fragment_container);
        Fragment fragment2 = fm.findFragmentById(R.id.list_fragment_container);

        if (fragment1 == null){
            fragment1 = new ButtonFragment();
            fm.beginTransaction()
                    .add(R.id.button_fragment_container, fragment1)
                    .commit();
        }

        if (fragment2 == null){
            fragment2 = new ListFragment();
            fm.beginTransaction()
                    .add(R.id.list_fragment_container, fragment2)
                    .commit();
        }



        Log.i(TAG, "Entered onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }


}


