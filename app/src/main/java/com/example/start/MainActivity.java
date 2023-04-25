package com.example.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
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

import com.github.library.bubbleview.BubbleTextView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout chatLL;  // не здесь
    private ImageButton btnSend;
    private ImageButton btnEmoji;
    private ImageButton btnBackToMenu;
    private ImageButton btnAdd;
    private TextView Name;
    private EditText Message;
    private BubbleTextView BublTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Лэйауты
        chatLL = findViewById(R.id.chatLayout); // не здесь
        //Кнопки
        btnSend = findViewById(R.id.btnSend);
        btnEmoji = findViewById(R.id.btnEmoji);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        btnAdd = findViewById(R.id.btnAdd);
        //Вьюшки
        Name = findViewById(R.id.name);
        Message = findViewById(R.id.message);
        BublTXT = findViewById(R.id.BublTXT);
        RelativeLayout.LayoutParams imageViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        BublTXT.setLayoutParams(imageViewLayoutParams);
        chatLL.addView(findViewById(R.id.BublTXT));

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), Message.getText(), Toast.LENGTH_SHORT);
                toast.show();
                setContentView(R.layout.bubble_message_item);
                //BublTXT.setText(Message.getText());
                //chatLL.addView(BublTXT); // не здесь
            }
        });
    }
}