package com.example.start;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.start.databinding.BubbleMessageItemBinding;

import java.util.ArrayList;

public class AddMessage extends RecyclerView.Adapter<AddMessage.ViewHolder> {

    private ArrayList<MyMessage> MyMessage;

    AddMessage(ArrayList<MyMessage> messages){
        this.MyMessage = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BubbleMessageItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.bubble_message_item, parent, false);
        Log.w("myApp", "здесь");
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(MyMessage.get(position));
    }
    @Override
    public int getItemCount() {
        return MyMessage.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final BubbleMessageItemBinding binding;
        public ViewHolder(@NonNull BubbleMessageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(MyMessage message){
            binding.setMsg(message);
        }
    }
}
