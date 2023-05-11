package com.example.start.ui.main;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.start.data.Message;
import com.example.start.data.Post;
import com.example.start.db.RealmDatabase;
import com.example.start.network.Network;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private final RealmDatabase mDatabase;
    private MessagesAdapter mAdapter;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        Realm.init(this.getApplication());

        mDatabase = new RealmDatabase(
                new  RealmConfiguration.Builder().
                        name(Realm.DEFAULT_REALM_NAME).
                        schemaVersion(0).
                        allowWritesOnUiThread(true).
                        deleteRealmIfMigrationNeeded().
                        build());

        mAdapter = new MessagesAdapter(mDatabase.getMessages("time"));

        Network.getInstance().getJSONApi().getPostWithID(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful() && response.body() != null)
                    return;
                Log.d("viewModel", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("viewModel", "Fail");
            }
        });



        //mDatabase.clear(Message.class);
    }
    public MessagesAdapter getAdapter() {
        return mAdapter;
    }
    public void addMessage(Message message){
        mDatabase.insert(message);
    }
    public void deleteMessage(Message message){
        //mDatabase.deleteById(message.getId());
    }
    public Message getContextClickOperation(){
        return mAdapter.getContextClickOperation();
    }
}