package edu.bard.todolist_lab1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class ToDoListActivity extends FragmentActivity {
    private static final String EXTRA_NOTE_ID = "edu.bard.todolist_lab1.note_id";
    /*
    @Override
    protected Fragment createFragment(){
        UUID noteId = (UUID) getIntent().getSerializableExtra(EXTRA_NOTE_ID);
        return ToDoListFragment.newInstance(noteId);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new ToDoListFragment();
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
}
