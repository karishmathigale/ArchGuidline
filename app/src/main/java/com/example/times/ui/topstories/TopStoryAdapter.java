package com.example.times.ui.topstories;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.times.BR;
import com.example.times.R;
import com.example.times.databinding.TopStoryItemBinding;
import com.example.times.model.TopStory;

import java.util.ArrayList;

/**
 * Created by Karishma on 13/4/18.
 * This class is adapter of top stories recycler view
 */

public class TopStoryAdapter extends RecyclerView.Adapter<TopStoryAdapter.ViewHolder> {

    private ArrayList<TopStory> mTopStories;
    private OnItemClickListener mOnItemClickListener;


    /**
     * Listener for news item click
     */
    interface OnItemClickListener{
        void onClickListener(int position);
    }

    /**
     * set listener for news item click
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }
    public TopStoryAdapter(ArrayList<TopStory> topStories) {
            this.mTopStories = topStories;
    }

    public void addStories(ArrayList<TopStory> topStories){
        this.mTopStories = topStories;
        notifyDataSetChanged();
    }
    @Override
    public TopStoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TopStoryItemBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.top_story_item, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(TopStoryAdapter.ViewHolder holder, int position) {
        holder.bind(mTopStories.get(position));
        holder.mediaAdapter.addMedia(mTopStories.get(position).getMultimediaList());
    }

    @Override
    public int getItemCount() {
        return mTopStories == null ? 0: mTopStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TopStoryMediaAdapter mediaAdapter;
        private  TopStoryItemBinding binding;


        public ViewHolder(TopStoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            //set adapter to media recycler view
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            binding.rvMedia.setHasFixedSize(false);
            binding.rvMedia.setLayoutManager(layoutManager);
            mediaAdapter = new TopStoryMediaAdapter(new ArrayList<>());
            binding.rvMedia.setAdapter(mediaAdapter);

            itemView.setOnClickListener(this);

        }

        /**
         * binding data to ui
         * @param topStory
         */
        public void bind(TopStory topStory){
            binding.setVariable(BR.model, topStory);
        }
        
        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null){
                mOnItemClickListener.onClickListener(getAdapterPosition());
            }
        }
    }
}
