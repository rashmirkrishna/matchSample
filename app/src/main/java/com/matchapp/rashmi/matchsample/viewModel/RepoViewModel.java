package com.matchapp.rashmi.matchsample.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.matchapp.rashmi.matchsample.model.Repo;
import com.matchapp.rashmi.matchsample.repository.ProjectRepository;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Viewmodel class to hold UI-related data
 */
public class RepoViewModel extends AndroidViewModel {
    private final LiveData<List<Repo>> mObservableRepos;
    private final MutableLiveData<Repo> selectedRepo = new MutableLiveData<Repo>();

    public RepoViewModel(Application application) {
        super(application);

        mObservableRepos = ProjectRepository.getInstance().getReposList("Square");
    }

    public LiveData<List<Repo>> getReposObservable() {
        return mObservableRepos;
    }

    public void setSelectedRepo(Repo repo) {
        selectedRepo.setValue(repo);
    }

    public LiveData<Repo> getSelectedRepo() {
        return selectedRepo;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
