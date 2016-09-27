package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by marysia on 9/25/16.
 */
public class ButtonFragment extends Fragment {
    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_button, container, false);

        // Get references to UI widgets
        mEditText = (EditText)v.findViewById(R.id.myEditText);
        mItemButton = (Button)v.findViewById(R.id.addButton);

        // Add key listener to add the new todo item
        // when the middle D-pad button is pressed.
        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //mToDoItems.add(0, mEditText.getText().toString());
                //aa.notifyDataSetChanged();
                mEditText.setText("");
            }
        });

        return v;
    }



}