package com.example.start.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.start.data.Message;
import com.example.start.R;
import com.example.start.databinding.ActivityMainBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.text.DateFormat;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private DatabaseReference mDatabase;
    private String MSG = "Message";
    EditText EmailText;
    //EditText EmailText;
    //EditText EmailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mDatabase = FirebaseDatabase.getInstance().getReference(MSG);

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_layout);
        //viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        /*binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(viewModel.getAdapter());
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                if (!binding.message.getText().toString().trim().isEmpty()) {
                    viewModel.addMessage(
                            new Message("Марк",
                                    binding.message.getText().toString(),
                                    System.currentTimeMillis() - TimeZone.getDefault().getOffset(System.currentTimeMillis()),
                                    !binding.authorname.getText().toString().isEmpty(), binding.authorname.getText().toString().isEmpty() ? "0" : "1", binding.authorname.getText().toString().isEmpty() ? "1" : "0"));
                    binding.message.getText().clear();
                }
            }
        });*/
            //foreground
        }
        public void onClickLogin(View v){
            Message message = new Message("Марк",
                    "Привет",
                    System.currentTimeMillis() - TimeZone.getDefault().getOffset(System.currentTimeMillis()),
                    true, "0", "1");
            mDatabase.push().setValue(message);
        }
        public void onClickReg(View v){

        }
    }