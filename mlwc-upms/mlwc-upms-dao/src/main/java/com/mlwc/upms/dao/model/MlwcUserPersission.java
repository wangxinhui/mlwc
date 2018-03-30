package com.mlwc.upms.dao.model;

import java.io.Serializable;

public class MlwcUserPersission implements Serializable {
    private Integer userPersissionId;

    private Integer userId;

    private Integer permisisionId;

    private Byte type;

    private static final long serialVersionUID = 1L;

    public Integer getUserPersissionId() {
        return userPersissionId;
    }

    public void setUserPersissionId(Integer userPersissionId) {
        this.userPersissionId = userPersissionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermisisionId() {
        return permisisionId;
    }

    public void setPermisisionId(Integer permisisionId) {
        this.permisisionId = permisisionId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userPersissionId=").append(userPersissionId);
        sb.append(", userId=").append(userId);
        sb.append(", permisisionId=").append(permisisionId);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
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
        MlwcUserPersission other = (MlwcUserPersission) that;
        return (this.getUserPersissionId() == null ? other.getUserPersissionId() == null : this.getUserPersissionId().equals(other.getUserPersissionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPermisisionId() == null ? other.getPermisisionId() == null : this.getPermisisionId().equals(other.getPermisisionId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserPersissionId() == null) ? 0 : getUserPersissionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPermisisionId() == null) ? 0 : getPermisisionId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}