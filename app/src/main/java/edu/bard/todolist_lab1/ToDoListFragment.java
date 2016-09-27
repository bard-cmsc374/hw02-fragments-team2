package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jason on 9/26/2016.
 */

public class ToDoListFragment extends Fragment {
    private EditText mTitleField;
    private Button mAddButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_todolist, container, false);

        mTitleField = (EditText)v.findViewById(R.id.add_title);
        mAddButton = (Button) v.findViewById(R.id.frag_add_button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Added Note",mTitleField.getText().toString());
                /*
                Bundle bundle = new Bundle();
                bundle.putString("addednote", mTitleField.getText().toString());
                mfragment.setArguments(bundle); //data being send to SecondFragment
                */
            }
        });

        return v;
    }

}
