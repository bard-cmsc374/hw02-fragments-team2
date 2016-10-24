package edu.bard.todolist_lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Jason on 9/26/2016.
 */

public class ToDoListAddFragment extends Fragment {
    private EditText mTitleField;
    private Button mAddButton;

    OnHeadlineSelectedListener mCallback; // XX need documentation here and at the method

    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(String string);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    private static final String ARG_NOTE_ID = "note_id";
    public static final String EXTRA_NOTE = "edu.bard.todolist_lab1.note";

    private void sendResult(int resultCode, String date){
        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOTE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

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

                String noteString = mTitleField.getText().toString();
                Log.i("Added Note",noteString);
                //sendResult(Activity.RESULT_OK, noteString);
                mTitleField.setText("");
                mCallback.onArticleSelected(noteString);

            }
        });

        return v;
    }


    public static ToDoListAddFragment newInstance(UUID noteId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE_ID,noteId);

        ToDoListAddFragment toDoListAddFragment = new ToDoListAddFragment();
        toDoListAddFragment.setArguments(args);
        return toDoListAddFragment;
    }

}
