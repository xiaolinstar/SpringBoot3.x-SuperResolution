package com.xiaolin.superresolution.service;

/**
 * @author xlxing
 */
public interface UserService {
    /**
     * 根据用户名和密码获取token，如果token不存在则创建
     * @param username: 用户名
     * @param password: 密码
     * @return token
     */
    String getToken(String username, String password);

    /**
     * 增加用户到数据库
     * @param username: 用户名
     * @param password: 密码
     * @return 是否添加用户成功
     */
    boolean addUser(String username, String password);

    /**
     * 判断数据库中用户是否已经存在
     * @param username: 用户名
     * @return 是否存在
     */
    boolean queryUserByUsername(String username);

    /**
     * 更新用户的密码
     * @param username: 用户名
     * @param oldPassword: 原密码
     * @param newPassword: 新密码
     * @return 更新密码是否成功
     */
    boolean updatePassword(String username, String oldPassword, String newPassword);


}
