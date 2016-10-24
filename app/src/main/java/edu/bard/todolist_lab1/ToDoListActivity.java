package edu.bard.todolist_lab1;
/*


CMSC 374
HW #2 Fragments: Feedback

Names: Marysia and Jason

      Rubric
----------------------------------------------------------
40	1. App functions correctly from end user perspective.
20	2. Fragments are correctly created.
10	3. Fragments share information on the adapter arraylist.
5	4. Code is clearly commented.
20	5. Code is readable and well constructed.

Score: 95


----------------

Comments

My comments in your code are marked with XX in a comment.


1. App functions correctly from end user perspective. YES, resources used, too.

2. Fragments are correctly created. YES and managed

3. Fragments share information on the adapter arraylist.

You allow the activity to call the list's update, which is fine for
this exercise.

4. Code is clearly commented.
You ignore commenting important methods.  Also leave an unused class
in the code base.

5. Code is readable and well constructed.
Yes...good throughout.


 */
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
