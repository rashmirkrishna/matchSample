package com.matchapp.rashmi.matchsample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matchapp.rashmi.matchsample.R;

public class MainGitHubViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            RepoListFragment fragment = new RepoListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, RepoListFragment.TAG).commit();
        }
    }

    public void displayRepoDetails() {
        RepoDetailsFragment repoDetailsFragment = new RepoDetailsFragment();
        getSupportFragmentManager().beginTransaction().addToBackStack(null)
                .replace(R.id.fragment_container, repoDetailsFragment, RepoDetailsFragment.TAG).commit();

    }
}
