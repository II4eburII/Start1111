package com.example.start;
import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;

import com.example.start.Message;
import com.example.start.RealmDatabase;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivityViewModel extends AndroidViewModel {
    private final RealmDatabase mDatabase;
    private MessagesAdapter mAdapter;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        mDatabase = new RealmDatabase(
                new  RealmConfiguration.Builder().
                        name(Realm.DEFAULT_REALM_NAME).
                        schemaVersion(0).
                        allowWritesOnUiThread(true).
                        deleteRealmIfMigrationNeeded().
                        build());

        //mDatabase.clear(Operation.class);
    }
    public MessagesAdapter getAdapter() {
        if (mAdapter != null)
            return mAdapter;

        mAdapter = new MessagesAdapter(mDatabase.getMessages("sender"));
        return mAdapter;
    }
    public void addMessage_VM(Message message){
        mDatabase.insert(new Message(message));
    }
    public void deleteMessage(Message message){
        mDatabase.deleteById(message.getId());
    }
    public Message getContextClickOperation(){
        return mAdapter.getContextClickOperation();
    }
}