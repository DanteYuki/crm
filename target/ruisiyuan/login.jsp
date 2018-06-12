<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/jquery/jquery-1.7.2.js"></script>
<title>CRM首頁</title>
</head>
<body >
	<input type="button" value="查询列表数据调试按钮" id="btn_1"/>
	<br />
	<input type="button" value="查询Level" id="btn_7"/>
	<br />
	<input type="button" value="插入数据调试按钮" id="btn_2"/>
	<br />
	<input type="button" value="查询单条数据调试按钮" id="btn_3"/>
	<br />
	<input type="button" value="删除单条数据调试按钮" id="btn_4"/>
	<br />
	<input type="button" value="修改数据调试按钮" id="btn_5"/>
	<br />
	<input type="button" value="登录" id="btn_6"/>
	<br />
</body>
<script type="text/javascript">
	$('#btn_1').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/permission/findByPage',
			type : 'get',
			dataType : 'json',
			data : {pageNum : 1,pageSize : 5},
			async : true,
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_2').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/permission/insert',
			type : 'post',
			dataType : 'json',
			async : true,
			data : {
				permissionName : '我是权限1',
				permissionType : 1,
				permissionUrl : '我是url',
				parentId : 'qweqweqweqweqweqweqweqweqweqweqw',
				status : 1,
				sortNumber : 3,
				description : '我是权限描述1'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_3').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/role/find',
			type : 'get',
			dataType : 'json',
			async : true,
			data : {
				roleId : 'ee4f881911d1474b8f61187558db70db'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_4').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/role/delete',
			type : 'post',
			dataType : 'json',
			async : true,
			data : {
				roleId : 'f02630b4ede34157a5144100d35ebf32'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_5').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/role/update',
			type : 'post',
			dataType : 'json',
			async : true,
			data : {
				roleId : 'f02630b4ede34157a5144100d35ebf32'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_6').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/account/login',
			type : 'post',
			dataType : 'json',
			async : true,
			data : {
				accountName : '111',
				password : 'yuki931119'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_7').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/permission/findByLevel',
			type : 'get',
			dataType : 'json',
			async : true,
			data : {
				plevel : 1
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	
</script>
</html>