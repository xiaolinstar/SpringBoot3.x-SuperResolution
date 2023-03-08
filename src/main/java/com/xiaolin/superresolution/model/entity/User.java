package com.xiaolin.superresolution.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author xlxing
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 使用字符串传输图像，编码为base64格式，不在数据库中使用该字段
     * 图像在服务器中的存储位置
     */
    private @Id @GeneratedValue Long id;
    private String username;
    private String password;
    private String role;
}
