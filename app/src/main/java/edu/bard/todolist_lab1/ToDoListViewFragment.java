package edu.bard.todolist_lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jason on 9/26/2016.
 */

public class ToDoListViewFragment extends Fragment {
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> mAdapter; // adapter from list to viewlist
    private ListView mListView;

    public static final int REQUEST_DATE=0;

    TextClicked mCallback;

    public static ArrayList<String> getToDoItems(){
        return getToDoItems();
    }

    public void updateArrayList(String string){
        Log.i("ListView Frag", string);
        mToDoItems.add(0, string);
        updateUI();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i("Request code", String.valueOf(requestCode));
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_DATE){
            String date = (String) data.getSerializableExtra(ToDoListAddFragment.EXTRA_NOTE);
            Log.i("Recieved request",date);
        }
    }

    public interface TextClicked{
        public void sendText(String text);
    }

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

        /*
        mAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

        // Bind the listview to the array adapter
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        */
        updateUI();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){  // XX doc???
        if(mAdapter == null){
            mAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, mToDoItems);
            mListView.setAdapter(mAdapter);
        } else{
            mAdapter.notifyDataSetChanged();
        }
    }


}
