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

    private String articleCommentId, articleId, userId, comment, likes;

    public String getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(String articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
