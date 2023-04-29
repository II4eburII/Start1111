package com.example.start;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.start.databinding.ActivityMainBinding;
import com.github.library.bubbleview.BubbleTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private RelativeLayout chatLL;  // не здесь
    private ImageButton btnSend;
    private ImageButton btnEmoji;
    private ImageButton btnBackToMenu;
    private ImageButton btnAdd;
    private TextView Name;
    private EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //
        //Лэйауты
        //
        chatLL = binding.chatLayout;
        //
        //Кнопки
        //
        btnSend = binding.btnSend;
        btnEmoji = binding.btnEmoji;
        btnBackToMenu = binding.btnBackToMenu;
        btnAdd = binding.btnAdd;
        //
        //Вьюшки
        //
        Name = binding.name;
        msg = binding.message;

        ArrayList<MyMessage> messages = new ArrayList<>();

        MessageAdapter messageAdapter = new MessageAdapter(messages);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(messageAdapter);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                messageAdapter.AddMessage(new MyMessage("Марк", msg.getText().toString(), 10));

            }
        });
    }
}