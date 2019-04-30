package d.com.newsapp.MVP.Main;

import java.util.List;

import d.com.newsapp.Retrofit.ArticlesList;

public interface IMainPresenterContract {

    interface View {
        void showMainNewsList( List<ArticlesList> articlesLists );
    }

    interface Presenter {
        void getMainNews();
    }
}
