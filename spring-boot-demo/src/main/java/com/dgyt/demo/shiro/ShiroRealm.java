package com.dgyt.demo.shiro;

import com.dgyt.demo.entity.User;
import com.dgyt.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 获取用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户输入的用户名和密码
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		log.info("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
		// 用户信息
		User user = userService.findByUserName(userName);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (!password.equals(user.getPassWord())) {
			throw new IncorrectCredentialsException();
		}
		if (user.getStatus().equals("0")) {
			throw new LockedAccountException();
		}
		return new SimpleAuthenticationInfo(user, password, getName());
	}

}
