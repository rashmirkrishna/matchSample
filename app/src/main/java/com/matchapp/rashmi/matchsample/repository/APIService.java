package com.matchapp.rashmi.matchsample.repository;

import com.matchapp.rashmi.matchsample.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit webservice interface
 */
public interface APIService {

    String GITHUB_BASE_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Repo>> getReposList(@Path("user") String user);
}
