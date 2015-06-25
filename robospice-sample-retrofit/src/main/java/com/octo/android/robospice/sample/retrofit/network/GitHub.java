package com.octo.android.robospice.sample.retrofit.network;

import com.octo.android.robospice.sample.retrofit.model.Contributor;

import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    Contributor.List contributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );
}