package d.com.newsapp.MVP.Categories;

import java.util.List;

import d.com.newsapp.Retrofit.ArticlesList;

public interface IBasePresenterContract {

    interface View {
        void showNewsList( List<ArticlesList> articlesLists );
    }

    interface Presenter {
        void getNewsApi(String cat);
    }
}
