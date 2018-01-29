package com.mindnode.immipal.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Ad implements Serializable {
    private Integer adId;

    private String adTitle;

    private Long adCreateTime;

    private String adImgUrl;

    private String adLink;

    private Integer adLevel;

    private Date adDate;

    private static final long serialVersionUID = 1L;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public Long getAdCreateTime() {
        return adCreateTime;
    }

    public void setAdCreateTime(Long adCreateTime) {
        this.adCreateTime = adCreateTime;
    }

    public String getAdImgUrl() {
        return adImgUrl;
    }

    public void setAdImgUrl(String adImgUrl) {
        this.adImgUrl = adImgUrl;
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }

    public Integer getAdLevel() {
        return adLevel;
    }

    public void setAdLevel(Integer adLevel) {
        this.adLevel = adLevel;
    }

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
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
        Ad other = (Ad) that;
        return (this.getAdId() == null ? other.getAdId() == null : this.getAdId().equals(other.getAdId()))
            && (this.getAdTitle() == null ? other.getAdTitle() == null : this.getAdTitle().equals(other.getAdTitle()))
            && (this.getAdCreateTime() == null ? other.getAdCreateTime() == null : this.getAdCreateTime().equals(other.getAdCreateTime()))
            && (this.getAdImgUrl() == null ? other.getAdImgUrl() == null : this.getAdImgUrl().equals(other.getAdImgUrl()))
            && (this.getAdLink() == null ? other.getAdLink() == null : this.getAdLink().equals(other.getAdLink()))
            && (this.getAdLevel() == null ? other.getAdLevel() == null : this.getAdLevel().equals(other.getAdLevel()))
            && (this.getAdDate() == null ? other.getAdDate() == null : this.getAdDate().equals(other.getAdDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdId() == null) ? 0 : getAdId().hashCode());
        result = prime * result + ((getAdTitle() == null) ? 0 : getAdTitle().hashCode());
        result = prime * result + ((getAdCreateTime() == null) ? 0 : getAdCreateTime().hashCode());
        result = prime * result + ((getAdImgUrl() == null) ? 0 : getAdImgUrl().hashCode());
        result = prime * result + ((getAdLink() == null) ? 0 : getAdLink().hashCode());
        result = prime * result + ((getAdLevel() == null) ? 0 : getAdLevel().hashCode());
        result = prime * result + ((getAdDate() == null) ? 0 : getAdDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adId=").append(adId);
        sb.append(", adTitle=").append(adTitle);
        sb.append(", adCreateTime=").append(adCreateTime);
        sb.append(", adImgUrl=").append(adImgUrl);
        sb.append(", adLink=").append(adLink);
        sb.append(", adLevel=").append(adLevel);
        sb.append(", adDate=").append(adDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}