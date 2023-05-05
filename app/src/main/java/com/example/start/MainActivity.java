package com.example.start;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.start.databinding.ActivityMainBinding;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.RealmConfiguration;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME).schemaVersion(1).build();
        Realm realm = Realm.getInstance(realmConfiguration);
        Realm.setDefaultConfiguration(realmConfiguration);
        RealmResults<Message> messages_realm = realm.where(Message.class).findAll();
        OrderedRealmCollection<Message> messages = messages_realm.createSnapshot();
        MessagesAdapter messagesAdapter = new MessagesAdapter(messages);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerView.setAdapter(messagesAdapter);
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                viewModel.addMessage_VM(new Message("Марк", binding.message.getText().toString(), 10, binding.authorname.getText().toString().equals("Я")));
                binding.message.setText("");
            }
        });
    }
}