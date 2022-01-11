package com.zhang.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.realm.Realm;

/**
 * @Author: zhangWs
 * @Date: 2022/1/11 16:06
 * @Classname: MyRealm2
 * @Description: TODO
 */
public class MyRealm2 implements Realm {

    @Override
    public String getName() {
        return "myRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名，和密码
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        //如果用户名错误
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }
        //如果密码错误
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username+"@163.com", password, getName());
    }
}
