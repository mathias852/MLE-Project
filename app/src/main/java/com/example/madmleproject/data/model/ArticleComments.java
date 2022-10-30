package com.example.madmleproject.data.model;

public class ArticleComments {
    public static final String TAG = ArticleComments.class.getSimpleName();
    public static final String TABLE = "ArticleComments";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ArticleCommentID";
    public static final String COLUMN_FK_ARTICLE_ID = "FK_ArticleID";
    public static final String COLUMN_FK_USER_ID = "FK_UserID";
    public static final String COLUMN_COMMENT_TEXT = "COMMENT";
    public static final String COLUMN_LIKES = "LIKES";

    private int articleCommentId, articleId, userId, likes;
    private String comment;

    public int getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(int articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
