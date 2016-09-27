package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jason on 9/26/2016.
 */

public class ToDoListViewFragment extends Fragment {
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_listview, container, false);

        mListView = (ListView)v.findViewById(R.id.myListView);

        // Create the ArrayList and the ArrayAdapter
        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

        mToDoItems.add("hello");
        mToDoItems.add("hello");
        mToDoItems.add("hello");
        mToDoItems.add("hello");

        // Bind the listview to the array adapter
        mListView.setAdapter(aa);



        return v;
    }

}
