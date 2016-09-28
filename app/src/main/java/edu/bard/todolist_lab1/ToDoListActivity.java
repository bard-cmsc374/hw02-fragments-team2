package edu.bard.todolist_lab1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.UUID;

public class ToDoListActivity extends FragmentActivity implements ToDoListAddFragment.OnHeadlineSelectedListener{
    private static final String EXTRA_NOTE_ID = "edu.bard.todolist_lab1.note_id";

    public void onArticleSelected(String string){
        Log.i("position",string);

        ToDoListViewFragment toDoListViewFragment = (ToDoListViewFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container_listview);

        if(toDoListViewFragment != null){
            toDoListViewFragment.updateArrayList(string);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new ToDoListAddFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        Fragment fragmentListView = fm.findFragmentById(R.id.fragment_container_listview);
        if(fragmentListView==null){
            fragmentListView=new ToDoListViewFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_listview,fragmentListView)
                    .commit();
        }



    }
    /*
    @Override
    protected Fragment createFragment(){
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_NOTE_ID);

    }*/
}
