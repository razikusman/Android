package com.example.crypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<String> images, txt1,txt2;
    protected PhotoListener photoListener;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1,textView2;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);
            textView1=itemView.findViewById(R.id.txttitle);
            textView2=itemView.findViewById(R.id.txttitle2);
        }

        public TextView getTextView1(){
            return textView1;
        }

    }

    public MyAdapter(Context context, List<String> images, List<String> txt1 , List<String> txt2, PhotoListener photoListener) {
        this.context = context;
        this.images = images;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.gallery_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String image=images.get(position);
        Glide.with(context).load(image).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoListener.onPhotoClick(image);
            }
        });

        final String path =txt1.get(position);
        holder.getTextView1().setText(path);
    }

    @Override
    public int getItemCount() {
        if(images != null)
        {
            return images.size();
        }

        return 0;
    }

    public interface PhotoListener{
        void onPhotoClick(String path);
    }

}