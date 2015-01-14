<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link href="/css/manage.css" media="screen" rel="stylesheet"type="text/css" />
<script src="/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<title>用户管理</title>
</head>
<body>
	<div class="manage_container">
		<%@ include file="/common/_head.jsp"%>
		<div class="main">
			<h1>用户管理&nbsp;&nbsp; <a href="/user/add">创建用户</a></h1>
			<div class="table_box">
				<table class="list">
					<tbody>
						<tr>
							<th>行号</th>
							<th>用户名</th>
							<th>昵称</th>
							<th>国家</th>
							<th>状态</th>
							<th>注册时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${userList}" var="user" varStatus="status">
							<tr>
								<td style="text-align: left;">${status.count}</td>
								<td style="text-align: left;">${user.userName}</td>
								<td style="text-align: left;">${user.nickName}</td>
								<td style="text-align: left;">${user.userState}</td>
								<td style="text-align: left;">
									<c:if test="${!empty user.userEnabled }">启用</c:if>
									<c:if test="${empty user.userEnabled }">停用</c:if>
								</td>
								<td style="text-align: left;">${user.registerDate}</td>
								<td style="text-align: left;">${user.alterDate}</td>
								<td>
									<a href="/user/edit/${user.id }">修改</a>
									<a href="/user/delete/${user.id }">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>