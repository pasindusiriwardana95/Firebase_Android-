package com.pasindusiriwardana.firebase_fund;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText mChildValueEditText;
    private Button mAddButton,mRemoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChildValueEditText=(EditText)findViewById(R.id.childValueEditText);
        mAddButton=(Button)findViewById(R.id.addButton);
        mRemoveButton=(Button)findViewById(R.id.removeButton);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference mRef=database.getReference("pasindu");

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //writing data
                String childValue=mChildValueEditText.getText().toString();
                mRef.setValue(childValue);
            }
        });
        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.removeValue(); //removing data
            }
        });

    }
}
