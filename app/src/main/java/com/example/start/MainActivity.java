package com.example.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Message;
import android.widget.Button;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private BubbleTextView BublTXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //
        //Лэйауты
        //
        chatLL = findViewById(R.id.chatLayout);
        //
        //Кнопки
        //
        btnSend = findViewById(R.id.btnSend);
        btnEmoji = findViewById(R.id.btnEmoji);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        btnAdd = findViewById(R.id.btnAdd);
        //
        //Вьюшки
        //
        Name = findViewById(R.id.name);
        msg = findViewById(R.id.message);
        BublTXT = findViewById(R.id.BublTXT);

        ArrayList<com.example.start.Message> messages = new ArrayList<>();


        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(new AddMessage(messages));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), msg.getText(), Toast.LENGTH_SHORT);
                toast.show();
                messages.add(new com.example.start.Message("Марк", msg.getText().toString(), 10));
                //AddMessage admsg = new AddMessage(new Arraylist(messages));
            }
        });
    }
}