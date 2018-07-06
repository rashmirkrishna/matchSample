package com.matchapp.rashmi.matchsample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matchapp.rashmi.matchsample.R;
import com.matchapp.rashmi.matchsample.databinding.FragmentMainBinding;
import com.matchapp.rashmi.matchsample.model.Repo;
import com.matchapp.rashmi.matchsample.viewModel.RepoViewModel;

import java.util.List;

/**
 * Fragment to display list of repositories in a recyclerview
 */
public class RepoListFragment extends Fragment {

    public static final String TAG = RepoListFragment.class.getSimpleName();

    private FragmentMainBinding mViewBinding;
    private RepoListAdapter mRepoListAdapter;
    RepoViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //get the databinding from the layout
        mViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        mRepoListAdapter = new RepoListAdapter(repoItemClickListener);
        mViewBinding.projectList.setAdapter(mRepoListAdapter);

        return mViewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(RepoViewModel.class);

        subscribeDataStreams(viewModel);
    }

    private void subscribeDataStreams(RepoViewModel viewModel) {
        viewModel.getReposObservable().observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(@Nullable List<Repo> repos) {
                if (repos != null) {
                    mRepoListAdapter.setData(repos);
                }
            }
        });
    }

    private final ItemClickListener repoItemClickListener = new ItemClickListener() {

        @Override
        public void onClick(Repo repo) {
            viewModel.setSelectedRepo(repo);
                ((MainGitHubViewerActivity) getActivity()).displayRepoDetails();
        }
    };
}
