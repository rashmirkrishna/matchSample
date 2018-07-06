package com.matchapp.rashmi.matchsample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matchapp.rashmi.matchsample.R;
import com.matchapp.rashmi.matchsample.databinding.FragmentRepoDetailsBinding;
import com.matchapp.rashmi.matchsample.model.Repo;
import com.matchapp.rashmi.matchsample.viewModel.RepoViewModel;

/**
 * Fragment to display repository detail view
 */
public class RepoDetailsFragment extends Fragment{
    public static final String TAG = RepoDetailsFragment.class.getSimpleName();
    private FragmentRepoDetailsBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_repo_details, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final RepoViewModel viewModel = ViewModelProviders.of(getActivity()).get(RepoViewModel.class);
        viewModel.getSelectedRepo().observe(this, new Observer<Repo>() {
            @Override
            public void onChanged(@Nullable Repo repo) {
                mBinding.setRepository(repo);
            }

        });
    }
}
