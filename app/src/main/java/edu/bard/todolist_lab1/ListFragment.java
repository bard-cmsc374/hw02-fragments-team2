package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by marysia on 9/25/16.
 */
public class ListFragment extends Fragment{
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        mListView = (ListView)v.findViewById(R.id.myListView);

        // Create the ArrayList and the ArrayAdapter
        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

        // Bind the listview to the array adapter
        mListView.setAdapter(aa);
        return v;
    }



}
