package Task_2;

public class News {
    private String news_text;
    private String news_headline;
    private String publication_time;

    public News(String news_text, String news_headline, String publication_time) {
        this.news_text = news_text;
        this.news_headline = news_headline;
        if (publication_time.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            this.publication_time = publication_time;
        } else {
            this.publication_time = "2022-01-01";
        }
    }

    public String getnews_text() {
        return news_text;
    }

    public void setnews_text(String hading) {
        this.news_text = news_text;
    }

    public String getnews_headline() {
        return news_headline;
    }

    public void setnews_headline(String text) {
        this.news_headline = news_headline;
    }

    public String getpublication_time() {
        return publication_time;
    }

    public void setpublication_time(String publication_time) {
        this.publication_time = publication_time;
    }
}