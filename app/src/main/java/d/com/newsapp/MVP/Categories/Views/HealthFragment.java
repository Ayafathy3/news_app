package d.com.newsapp.MVP.Categories.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import d.com.newsapp.MVP.Categories.BasePresenterImp;
import d.com.newsapp.MVP.Categories.IBasePresenterContract;
import d.com.newsapp.MVP.ContentWebView.DetailsActivity;
import d.com.newsapp.MVP.Home.ContentAdapter;
import d.com.newsapp.MVP.Home.HomeActivity;
import d.com.newsapp.R;
import d.com.newsapp.Retrofit.ArticlesList;

public class HealthFragment extends Fragment implements IBasePresenterContract.View ,ContentAdapter.OnClickNews{
    RecyclerView mainRecycler;
    List<ArticlesList> contentList;
    BasePresenterImp basePresenterImp;

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated(view, savedInstanceState);

        intiViews(view);
        createInstances();
    }

    private void intiViews( View view ) {
        mainRecycler = view.findViewById(R.id.recycler_view);
         }

    private void createInstances() {
        contentList = new ArrayList<>();
        basePresenterImp = new BasePresenterImp(this,getActivity());
        basePresenterImp.getNewsApi("health");
    }

    @Override
    public void showNewsList( List<ArticlesList> contentLists ) {
        this.contentList = contentLists;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(manager);
        mainRecycler.setAdapter(new ContentAdapter(contentList, getActivity(),this));
    }

    @Override
    public void setOnClickNews( int position ) {
        String url = contentList.get(position).getUrl();
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            intent.putExtra("URL", url);
            getActivity().startActivity(intent);
        }
    }
}

