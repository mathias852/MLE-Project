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

    private String articleText, picturePath, title;
    private int articleId, landmarkId, userId, likes, commentAmount;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(int commentAmount) {
        this.commentAmount = commentAmount;
    }
}
