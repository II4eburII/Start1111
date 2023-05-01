package com.example.start;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.start.databinding.MessageItemBinding;

import java.util.ArrayList;
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private ArrayList<Message> messages;

    MessagesAdapter(ArrayList<Message> messages){
        this.messages = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MessageItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.message_item, parent, false);
        Log.w("myApp", "здесь");
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(messages.get(position));
    }
    @Override
    public int getItemCount() {
        return messages.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MessageItemBinding binding;
        public ViewHolder(@NonNull MessageItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Message message){
                binding.setMsg(message);
        }
    }
    public void addMessage(Message msg){
        this.messages.add(msg);
        notifyItemInserted(this.messages.size() - 1);//мы добавили элемент на последнее место, поэтому можно не использовать notifyDataSetChanged, который обновляет весь список
        //notifyDataSetChanged();
    }
    public Message getItem(int position) {
        return messages.get(position);
    }
}
