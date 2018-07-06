package com.matchapp.rashmi.matchsample.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.matchapp.rashmi.matchsample.R;
import com.matchapp.rashmi.matchsample.databinding.RepoListItemBinding;
import com.matchapp.rashmi.matchsample.model.Repo;

import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoItemViewHolder> {
    private List<Repo> githubRepos;
    private final ItemClickListener itemClickListener;

    public RepoListAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Repo> githubRepos) {
        this.githubRepos = githubRepos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         RepoListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.repo_list_item, parent,false);

         binding.setHandler(itemClickListener);

        return new RepoItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoItemViewHolder holder, int position) {
        holder.binding.setRepository(githubRepos.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return githubRepos == null ? 0 : githubRepos.size();
    }

    class RepoItemViewHolder extends RecyclerView.ViewHolder {
        final RepoListItemBinding binding;

        private RepoItemViewHolder(RepoListItemBinding repoListItemBinding) {
            super(repoListItemBinding.getRoot());
            this.binding = repoListItemBinding;
        }
    }
}
