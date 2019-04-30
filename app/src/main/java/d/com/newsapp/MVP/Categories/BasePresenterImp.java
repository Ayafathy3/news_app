package d.com.newsapp.MVP.Categories;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import d.com.newsapp.R;
import d.com.newsapp.Retrofit.ApiInterface;
import d.com.newsapp.Retrofit.MainContent;
import d.com.newsapp.Retrofit.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasePresenterImp implements IBasePresenterContract.Presenter {

    IBasePresenterContract.View mView;
    Context context;
    Dialog mDialog;

    public BasePresenterImp( IBasePresenterContract.View mView, Context context ) {
        this.mView = mView;
        this.context = context;
        mDialog = new Dialog(context);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.loading_progress);
        mDialog.findViewById(R.id.avi).setVisibility(View.VISIBLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.show();
    }

    @Override
    public void getNewsApi( String cat ) {
        ApiInterface apiInterface = RetrofitInstance.getRetrofit(context).create(ApiInterface.class);
        Call<MainContent> call = apiInterface.getNewsContent("eg", cat, "10cf3320943a4423bb3d1a7d5c216052");
        call.enqueue(new Callback<MainContent>() {
            @Override
            public void onResponse( Call<MainContent> call, Response<MainContent> response ) {
                if (response.isSuccessful()) {
                    Log.i("news_api", "success: " + response.body().getStatus() + " " + String.valueOf(response.body().getTotalResults()));
                    mDialog.dismiss();
                    mView.showNewsList(response.body().getArticles());
                } else {
                    Log.i("news_api", "not success");
                }
            }

            @Override
            public void onFailure( Call<MainContent> call, Throwable t ) {
                Log.i("news_api", "failure " + t.getMessage());
                mDialog.dismiss();
                Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

