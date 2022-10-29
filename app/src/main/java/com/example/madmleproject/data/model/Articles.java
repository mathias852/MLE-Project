package com.example.madmleproject.data.model;

public class Articles {
    public static final String TAG = Articles.class.getSimpleName();
    public static final String TABLE = "Articles";

    //Labels for table columns names
    public static final String COLUMN_PK_ID = "PK_ArticleID";
    public static final String COLUMN_FK_LANDMARK_ID = "FK_LandmarkID";
    public static final String COLUMN_FK_USER_ID = "FK_UserID";
    public static final String COLUMN_ARTICLE_TEXT = "ArticleText";
    public static final String COLUMN_PICTURE_PATH = "PicturePath";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_LIKES = "Likes";
    public static final String COLUMN_COMMENT_AMOUNT = "CommentAmount";

    private String articleId, landmarkId, userId, article, picturePath, title, likes, commentAmount;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(String landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(String commentAmount) {
        this.commentAmount = commentAmount;
    }
}
