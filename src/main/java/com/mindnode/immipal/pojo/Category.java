package com.mindnode.immipal.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Category implements Serializable {
    private Integer categoryId;

    private String categoryTitle;

    private Integer categoryLevel;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
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
        Category other = (Category) that;
        return (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryTitle() == null ? other.getCategoryTitle() == null : this.getCategoryTitle().equals(other.getCategoryTitle()))
            && (this.getCategoryLevel() == null ? other.getCategoryLevel() == null : this.getCategoryLevel().equals(other.getCategoryLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryTitle() == null) ? 0 : getCategoryTitle().hashCode());
        result = prime * result + ((getCategoryLevel() == null) ? 0 : getCategoryLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryTitle=").append(categoryTitle);
        sb.append(", categoryLevel=").append(categoryLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}