package Task_2;

import java.sql.*;

public class NewsConnection {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "1551erlan";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createNews(News news) {
        String sqlInsertNews = "insert into news (news_text, news_headline, publication_time) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(sqlInsertNews);
            preparedStatement.setString(1, news.getnews_text());
            preparedStatement.setString(2, news.getnews_headline());
            preparedStatement.setDate(3, Date.valueOf(news.getpublication_time()));
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void displayNews() {
        String sqlSelectNews = "select Newsnews_text, Newsnews_headline, publication_time date from news";
        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectNews);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("news_text")
                        + " " + resultSet.getString("news_headline")
                        + " " + resultSet.getString("publication_time"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteNews(int id) {
        String sqlDeleteNews = "delete from news where id = ?";
        try {
            PreparedStatement prSt = connect().prepareStatement(sqlDeleteNews);
            prSt.setInt(1, id);
            prSt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateNews(News news, int id) {
        String sqlUpdateNews = "update news set news_text = ?, news_headline = ?, publication_time = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(sqlUpdateNews);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, news.getnews_text());
            preparedStatement.setString(2, news.getnews_headline());
            preparedStatement.setDate(3, Date.valueOf(news.getpublication_time()) );
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
