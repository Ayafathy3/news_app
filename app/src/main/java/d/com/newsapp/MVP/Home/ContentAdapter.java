package d.com.newsapp.MVP.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import d.com.newsapp.R;
import d.com.newsapp.Retrofit.ArticlesList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {
    List<ArticlesList> contentList;
    Context context;
    OnClickNews onClickNews;

    public ContentAdapter( List<ArticlesList> contentList, Context context, OnClickNews onClickNews ) {
        this.contentList = contentList;
        this.context = context;
        this.onClickNews = onClickNews;
    }

    public interface OnClickNews {
        void setOnClickNews( int position );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( @NonNull ViewGroup viewGroup, int i ) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_content, viewGroup, false);
        return new MyViewHolder(view, onClickNews);
    }

    @Override
    public void onBindViewHolder( @NonNull MyViewHolder myViewHolder, int position ) {
        ArticlesList articlesList = contentList.get(position);
        Glide.with(context).load(articlesList.getUrlToImage()).into(myViewHolder.img);
        myViewHolder.title.setText(articlesList.getTitle());
        myViewHolder.desc.setText(articlesList.getDescription());

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView title, desc;
        OnClickNews onClickNews;

        public MyViewHolder( @NonNull View itemView, OnClickNews onClickNews ) {
            super(itemView);
            this.onClickNews = onClickNews;
            img = itemView.findViewById(R.id.img_content);
            title = itemView.findViewById(R.id.title_content);
            desc = itemView.findViewById(R.id.desc_content);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick( View view ) {
            onClickNews.setOnClickNews(getAdapterPosition());
        }
    }

}
