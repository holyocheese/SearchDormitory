package org.searching.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author ou
 * @since 2023-07-03
 */
@TableName("account_info")
public class AccountInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String longName;

    private String des;

    private Double fan;

    private String fanUnit;

    private LocalDate searchingDate;

    private Double up;

    private String upUnit;

    private Double focus;

    private String focusUnit;

    private Double fanCompareToLastweek;

    private String fanCompareToLastweekUnit;

    private Double fallowCompareToLastweekCopy1;

    private String fallowCompareToLastweekUnitCopy1;

    private Double likeCompareToLastweekCopy1Copy1;

    private String likeCompareToLastweekUnitCopy1Copy1;

    private Double fallowCompareToLastweekCopy1Copy1;

    private String fallowCompareToLastweekUnitCopy1Copy1;

    private String accountInfocol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Double getFan() {
        return fan;
    }

    public void setFan(Double fan) {
        this.fan = fan;
    }

    public String getFanUnit() {
        return fanUnit;
    }

    public void setFanUnit(String fanUnit) {
        this.fanUnit = fanUnit;
    }

    public LocalDate getSearchingDate() {
        return searchingDate;
    }

    public void setSearchingDate(LocalDate searchingDate) {
        this.searchingDate = searchingDate;
    }

    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }

    public String getUpUnit() {
        return upUnit;
    }

    public void setUpUnit(String upUnit) {
        this.upUnit = upUnit;
    }

    public Double getFocus() {
        return focus;
    }

    public void setFocus(Double focus) {
        this.focus = focus;
    }

    public String getFocusUnit() {
        return focusUnit;
    }

    public void setFocusUnit(String focusUnit) {
        this.focusUnit = focusUnit;
    }

    public Double getFanCompareToLastweek() {
        return fanCompareToLastweek;
    }

    public void setFanCompareToLastweek(Double fanCompareToLastweek) {
        this.fanCompareToLastweek = fanCompareToLastweek;
    }

    public String getFanCompareToLastweekUnit() {
        return fanCompareToLastweekUnit;
    }

    public void setFanCompareToLastweekUnit(String fanCompareToLastweekUnit) {
        this.fanCompareToLastweekUnit = fanCompareToLastweekUnit;
    }

    public Double getFallowCompareToLastweekCopy1() {
        return fallowCompareToLastweekCopy1;
    }

    public void setFallowCompareToLastweekCopy1(Double fallowCompareToLastweekCopy1) {
        this.fallowCompareToLastweekCopy1 = fallowCompareToLastweekCopy1;
    }

    public String getFallowCompareToLastweekUnitCopy1() {
        return fallowCompareToLastweekUnitCopy1;
    }

    public void setFallowCompareToLastweekUnitCopy1(String fallowCompareToLastweekUnitCopy1) {
        this.fallowCompareToLastweekUnitCopy1 = fallowCompareToLastweekUnitCopy1;
    }

    public Double getLikeCompareToLastweekCopy1Copy1() {
        return likeCompareToLastweekCopy1Copy1;
    }

    public void setLikeCompareToLastweekCopy1Copy1(Double likeCompareToLastweekCopy1Copy1) {
        this.likeCompareToLastweekCopy1Copy1 = likeCompareToLastweekCopy1Copy1;
    }

    public String getLikeCompareToLastweekUnitCopy1Copy1() {
        return likeCompareToLastweekUnitCopy1Copy1;
    }

    public void setLikeCompareToLastweekUnitCopy1Copy1(String likeCompareToLastweekUnitCopy1Copy1) {
        this.likeCompareToLastweekUnitCopy1Copy1 = likeCompareToLastweekUnitCopy1Copy1;
    }

    public Double getFallowCompareToLastweekCopy1Copy1() {
        return fallowCompareToLastweekCopy1Copy1;
    }

    public void setFallowCompareToLastweekCopy1Copy1(Double fallowCompareToLastweekCopy1Copy1) {
        this.fallowCompareToLastweekCopy1Copy1 = fallowCompareToLastweekCopy1Copy1;
    }

    public String getFallowCompareToLastweekUnitCopy1Copy1() {
        return fallowCompareToLastweekUnitCopy1Copy1;
    }

    public void setFallowCompareToLastweekUnitCopy1Copy1(String fallowCompareToLastweekUnitCopy1Copy1) {
        this.fallowCompareToLastweekUnitCopy1Copy1 = fallowCompareToLastweekUnitCopy1Copy1;
    }

    public String getAccountInfocol() {
        return accountInfocol;
    }

    public void setAccountInfocol(String accountInfocol) {
        this.accountInfocol = accountInfocol;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
        "id = " + id +
        ", name = " + name +
        ", longName = " + longName +
        ", des = " + des +
        ", fan = " + fan +
        ", fanUnit = " + fanUnit +
        ", searchingDate = " + searchingDate +
        ", up = " + up +
        ", upUnit = " + upUnit +
        ", focus = " + focus +
        ", focusUnit = " + focusUnit +
        ", fanCompareToLastweek = " + fanCompareToLastweek +
        ", fanCompareToLastweekUnit = " + fanCompareToLastweekUnit +
        ", fallowCompareToLastweekCopy1 = " + fallowCompareToLastweekCopy1 +
        ", fallowCompareToLastweekUnitCopy1 = " + fallowCompareToLastweekUnitCopy1 +
        ", likeCompareToLastweekCopy1Copy1 = " + likeCompareToLastweekCopy1Copy1 +
        ", likeCompareToLastweekUnitCopy1Copy1 = " + likeCompareToLastweekUnitCopy1Copy1 +
        ", fallowCompareToLastweekCopy1Copy1 = " + fallowCompareToLastweekCopy1Copy1 +
        ", fallowCompareToLastweekUnitCopy1Copy1 = " + fallowCompareToLastweekUnitCopy1Copy1 +
        ", accountInfocol = " + accountInfocol +
        "}";
    }
}
