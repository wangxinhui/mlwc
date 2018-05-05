package com.mlwc.upms.dao.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: by simple on 2018/5/4.
 */
public class MlwcMenu implements Serializable{
    private static final long serialVersionUID = -5350856301512796288L;

    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private List<MlwcMenu> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<MlwcMenu> getChildren() {
        return children;
    }

    public void setChildren(List<MlwcMenu> children) {
        this.children = children;
    }
}
