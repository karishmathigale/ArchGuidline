package com.example.times.ui.topstories;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.times.BR;
import com.example.times.R;
import com.example.times.databinding.TopStoryMediaItemBinding;
import com.example.times.model.Multimedia;

import java.util.ArrayList;

/**
 * Created by Karishma on 13/4/18.
 * This calss is adapter for media recycler view(Nested Recycler View)
 */

public class TopStoryMediaAdapter extends RecyclerView.Adapter<TopStoryMediaAdapter.ViewHolder> {

    private ArrayList<Multimedia> mMultimediaList;

    public TopStoryMediaAdapter(ArrayList<Multimedia> multimediaList) {
        this.mMultimediaList = multimediaList;
    }

    public void addMedia(ArrayList<Multimedia> multimediaList){
        mMultimediaList.clear();
        this.mMultimediaList.addAll(multimediaList);
        notifyDataSetChanged();
    }
    @Override
    public TopStoryMediaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TopStoryMediaItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.top_story_media_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TopStoryMediaAdapter.ViewHolder holder, int position) {
        holder.bind(mMultimediaList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMultimediaList == null ? 0 : mMultimediaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TopStoryMediaItemBinding binding;

        public ViewHolder(TopStoryMediaItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Multimedia multimedia){
            binding.setVariable(BR.model,multimedia);
        }
    }
}
