package com.example.start;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.start.databinding.BubbleMessageItemBinding;

import java.util.ArrayList;

public class AddMessage extends RecyclerView.Adapter<AddMessage.ViewHolder> {

    private ArrayList<Message> Message;

    AddMessage(ArrayList<Message> messages){
        this.Message = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v  = inflater.inflate(R.layout.bubble_message_item,parent,false);
        BubbleMessageItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.bubble_message_item, parent, false);
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(Message.get(position));
    }
    @Override
    public int getItemCount() {
        return Message.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final BubbleMessageItemBinding binding;
        public ViewHolder(@NonNull BubbleMessageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Message message){
            binding.setMessage(message);
        }
    }
}
