package com.mindnode.immipal.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 5289057923174754642L;

    private Integer categoryId;

    private String categorytitle;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategorytitle() {
        return categorytitle;
    }

    public void setCategorytitle(String categorytitle) {
        this.categorytitle = categorytitle;
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
            && (this.getCategorytitle() == null ? other.getCategorytitle() == null : this.getCategorytitle().equals(other.getCategorytitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategorytitle() == null) ? 0 : getCategorytitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categorytitle=").append(categorytitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}