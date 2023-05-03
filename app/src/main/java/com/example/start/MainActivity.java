package com.example.start;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.start.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String isAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("Марк", "HI", 10, false));

        MessagesAdapter messagesAdapter = new MessagesAdapter(messages);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(messagesAdapter);
        //binding.recyclerView.addItemDecoration();



        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                messagesAdapter.addMessage(new Message("Марк", binding.message.getText().toString(), 10, binding.authorname.getText().toString().equals("Я")));
                binding.message.setText("");
            }
        });
    }
}