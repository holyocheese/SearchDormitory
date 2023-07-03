package org.searching.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ou
 * @since 2023-07-03
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String userId;

    private String platform;

    private String apiUrl;

    private String apiUrlType;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrlType() {
        return apiUrlType;
    }

    public void setApiUrlType(String apiUrlType) {
        this.apiUrlType = apiUrlType;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id = " + id +
        ", name = " + name +
        ", userId = " + userId +
        ", platform = " + platform +
        ", apiUrl = " + apiUrl +
        ", apiUrlType = " + apiUrlType +
        "}";
    }
}
