package com.mindnode.immipal.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class News implements Serializable {
    private Integer newsId;

    private Integer categoryId;

    private String newsTitle;

    private String newsAuthor;

    private String newsTranslator;

    private Long newsCreateTime;

    private String showImgUrls;

    private Integer showImgCount;

    private Boolean newsTop;

    private Boolean hasVideo;

    private Boolean recommend;

    private String categoryTitle;

    private Date newsDate;

    private String videoUrl;

    private String newsContent;

    private static final long serialVersionUID = 1L;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public String getNewsTranslator() {
        return newsTranslator;
    }

    public void setNewsTranslator(String newsTranslator) {
        this.newsTranslator = newsTranslator;
    }

    public Long getNewsCreateTime() {
        return newsCreateTime;
    }

    public void setNewsCreateTime(Long newsCreateTime) {
        this.newsCreateTime = newsCreateTime;
    }

    public String getShowImgUrls() {
        return showImgUrls;
    }

    public void setShowImgUrls(String showImgUrls) {
        this.showImgUrls = showImgUrls;
    }

    public Integer getShowImgCount() {
        return showImgCount;
    }

    public void setShowImgCount(Integer showImgCount) {
        this.showImgCount = showImgCount;
    }

    public Boolean getNewsTop() {
        return newsTop;
    }

    public void setNewsTop(Boolean newsTop) {
        this.newsTop = newsTop;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        News other = (News) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
            && (this.getNewsAuthor() == null ? other.getNewsAuthor() == null : this.getNewsAuthor().equals(other.getNewsAuthor()))
            && (this.getNewsTranslator() == null ? other.getNewsTranslator() == null : this.getNewsTranslator().equals(other.getNewsTranslator()))
            && (this.getNewsCreateTime() == null ? other.getNewsCreateTime() == null : this.getNewsCreateTime().equals(other.getNewsCreateTime()))
            && (this.getShowImgUrls() == null ? other.getShowImgUrls() == null : this.getShowImgUrls().equals(other.getShowImgUrls()))
            && (this.getShowImgCount() == null ? other.getShowImgCount() == null : this.getShowImgCount().equals(other.getShowImgCount()))
            && (this.getNewsTop() == null ? other.getNewsTop() == null : this.getNewsTop().equals(other.getNewsTop()))
            && (this.getHasVideo() == null ? other.getHasVideo() == null : this.getHasVideo().equals(other.getHasVideo()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getCategoryTitle() == null ? other.getCategoryTitle() == null : this.getCategoryTitle().equals(other.getCategoryTitle()))
            && (this.getNewsDate() == null ? other.getNewsDate() == null : this.getNewsDate().equals(other.getNewsDate()))
            && (this.getVideoUrl() == null ? other.getVideoUrl() == null : this.getVideoUrl().equals(other.getVideoUrl()))
            && (this.getNewsContent() == null ? other.getNewsContent() == null : this.getNewsContent().equals(other.getNewsContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getNewsAuthor() == null) ? 0 : getNewsAuthor().hashCode());
        result = prime * result + ((getNewsTranslator() == null) ? 0 : getNewsTranslator().hashCode());
        result = prime * result + ((getNewsCreateTime() == null) ? 0 : getNewsCreateTime().hashCode());
        result = prime * result + ((getShowImgUrls() == null) ? 0 : getShowImgUrls().hashCode());
        result = prime * result + ((getShowImgCount() == null) ? 0 : getShowImgCount().hashCode());
        result = prime * result + ((getNewsTop() == null) ? 0 : getNewsTop().hashCode());
        result = prime * result + ((getHasVideo() == null) ? 0 : getHasVideo().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getCategoryTitle() == null) ? 0 : getCategoryTitle().hashCode());
        result = prime * result + ((getNewsDate() == null) ? 0 : getNewsDate().hashCode());
        result = prime * result + ((getVideoUrl() == null) ? 0 : getVideoUrl().hashCode());
        result = prime * result + ((getNewsContent() == null) ? 0 : getNewsContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsAuthor=").append(newsAuthor);
        sb.append(", newsTranslator=").append(newsTranslator);
        sb.append(", newsCreateTime=").append(newsCreateTime);
        sb.append(", showImgUrls=").append(showImgUrls);
        sb.append(", showImgCount=").append(showImgCount);
        sb.append(", newsTop=").append(newsTop);
        sb.append(", hasVideo=").append(hasVideo);
        sb.append(", recommend=").append(recommend);
        sb.append(", categoryTitle=").append(categoryTitle);
        sb.append(", newsDate=").append(newsDate);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", newsContent=").append(newsContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}