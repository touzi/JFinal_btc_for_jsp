<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<fieldset class="solid">
	<legend>用户编辑</legend>
	<input type="hidden" name="user.id" value="${user.id}" />
	<input type="hidden" name="user.registerDate" value="${user.registerDate}" />
	<input type="hidden" name="user.userState" value="${user.userState}" />
	<div>
		<label>用户名</label>
		<input type="text" name="user.userName" value="${user.userName}" />${userNameMsg}
	</div>
	<div>
		<label>密码</label>
		<input type="password" name="user.userPass" value="${user.userPass}" />${userPassWordMsg}
	</div>
	<div>
		<label>密码</label>
		<input type="password" name="rePassWord" value="" />${rePassWordMsg}
	</div>
	<div>
		<label>昵称</label>
		<input type="text" name="user.nickName" value="${user.nickName }" />${nickNameMsg}
	</div>
	<div>
		<label>邮箱</label>
		<input type="text" name="user.registerEmail" value="${user.registerEmail }" />${registerEmailMsg}
	</div>
	<div>
		<label>状态</label>
		<select name="user.userEnabled">
			<option value="1">启用</option>
			<option >停用</option>
		</select>	${userEnabledMsg}
	</div>
	<div>
		<label>关于</label>
		<textarea name="user.userInfo" cols="80" rows="10">${user.userInfo}</textarea>${userInfoMsg}
	</div>
	<div>
		<label>&nbsp;</label>
		<input value="提交" type="submit">
	</div>
</fieldset>