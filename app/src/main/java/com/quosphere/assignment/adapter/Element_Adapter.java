package com.quosphere.assignment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.quosphere.assignment.R;
import com.quosphere.assignment.helper.ItemTouchHelperAdapter;
import com.quosphere.assignment.model.Elements;

import java.util.Collections;
import java.util.List;

public class Element_Adapter extends RecyclerView.Adapter<Element_Adapter.Gallery_ViewHolder> implements ItemTouchHelperAdapter {
    Context context;
    private final List<Elements> list;
    private Boolean isSelected;
    private RecyclerView recyclerView;

    public Element_Adapter(List<Elements> list, Boolean isSelected) {
        this.list = list;
        this.isSelected = isSelected;
    }

    @NonNull
    @Override
    public Gallery_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context = parent.getContext();
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_element, parent, false);
        return new Gallery_ViewHolder(view);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull Gallery_ViewHolder holder, int position) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        layoutParams.setFullSpan(isSelected && position == 0);
        Elements item = list.get(position);
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, item.getResourceId()));
        holder.title.setText(item.getName());
        holder.imageView.setOnClickListener(v -> {
            onItemMove(position,0);
            isSelected = true;
            notifyItemRangeChanged(0,list.size());
            recyclerView.scrollToPosition(0);
        });
        holder.cardView.setCardBackgroundColor(Color.parseColor(item.getBgColor()));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {


    }

    static class Gallery_ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        CardView cardView;

        private Gallery_ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image);
            this.title = itemView.findViewById(R.id.title);
            this.cardView = itemView.findViewById(R.id.cardView);
        }
    }
}