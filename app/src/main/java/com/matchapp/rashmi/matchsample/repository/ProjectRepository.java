package com.matchapp.rashmi.matchsample.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.matchapp.rashmi.matchsample.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Repository class to handle data operations
 */
public class ProjectRepository {
    private APIService mGithubAPIService;
    private static ProjectRepository mProjectRepository;

    private ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mGithubAPIService = retrofit.create(APIService.class);

    }

    public synchronized static ProjectRepository getInstance() {
        if (mProjectRepository == null) {
            if (mProjectRepository == null) {
                mProjectRepository = new ProjectRepository();
            }
        }
        return mProjectRepository;
    }

    /**
     * Method to fetch list of repositories for a specified user using retrofit webservice
     * @param username username to fetch repositories
     * @return livedata list of repo
     */
    public LiveData<List<Repo>> getReposList(String username) {
        final MutableLiveData<List<Repo>> data = new MutableLiveData<>();

        mGithubAPIService.getReposList(username).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}

