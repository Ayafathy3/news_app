package d.com.newsapp.Retrofit;

import java.util.List;

public class MainContent {

    List<ArticlesList> articles;
    String status;
    int totalResults;

    public int getTotalResults() {
        return totalResults;
    }

    public List<ArticlesList> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }
}
