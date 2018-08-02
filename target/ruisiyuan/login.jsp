<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/static/jquery/jquery-1.12.3.js"></script>
<script src="${pageContext.request.contextPath }/static/jquery/layer.js"></script>
<title>CRM首頁</title>
<style type="text/css">
	input[type="button"] {
		width : 200px;
		height : 50px;
		radius : 10px
		color : lightblue;
	}
</style>
</head>
<body >
	<input type="button" value="查询列表数据调试按钮" id="btn_1"/>
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
	<input type="button" value="查询Level" id="btn_7"/>
	<br />
	<form action="${pageContext.request.contextPath }/backstage/social/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file" />
		<input type="hidden" id="token" name="token" value="de550761bf4a42bd8e77575a481b577d_d922717148f64d40bdacaea7d2e1e475"/>
	</form>
	<button id="btn9">上传文件</button>
	<a id="download"><button id="btn8">下载</button></a>
</body>
<script type="text/javascript">
	$('#btn_1').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/classManage/findByPage',
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
			url : '${pageContext.request.contextPath}/backstage/account/insert',
			type : 'post',
			dataType : 'json',
			async : true,
			data :{
				accountName : 'dante',
				password : '123',
				nickName : 'dante',
				headPicture : '',
				emailAddress : '123',
				emailPassword : '123',
				status : 1,
				description : '123'
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	$('#btn_3').on('click',function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/backstage/campus/find',
			type : 'get',
			dataType : 'json',
			async : true,
			data : {
				id : '0e84d99c9c5c4968836eeab95aca9eaf'
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
			url : '${pageContext.request.contextPath}/backstage/account/update',
			type : 'post',
			dataType : 'json',
			async : true,
			data : {
				accountId : 'de550761bf4a42bd8e77575a481b577d',
				accountName : 'system',
				password : 'rsy007',
				nickName : 'rsy007',
				realName :  '最高权限统帅',
				headPicture : '头像',
				emailAddress : '348832103@qq.com',
				emailPassword : 'rsy007',
				description : '最高权限统帅'
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
				accountName : 'system',
				password : 'rsy007'
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
				plevel : 2,
				pageNum : 1,
				pageSize : 5
			},
			success : function(data){
				console.log(data);
			}
		})
	})
	
	$('#btn8').on('click',function(){
		/*$.ajax({
			url : '${pageContext.request.contextPath}/backstage/social/download',
			type : 'get',
			contentType : false,
			async : true,
			data : {token : 'de550761bf4a42bd8e77575a481b577d_d922717148f64d40bdacaea7d2e1e475'},
			success : function(){
			}
		})*/
		$('#download').attr('href','${pageContext.request.contextPath}/backstage/social/download');
	})
	
	$('#btn9').on('click',function(){
		var formData = new FormData();
		formData.append('file',$('#file')[0].files[0]);
		var token = $('#token').val();
		formData.append('token',token);
		console.log(formData);
		$.ajax({
            url: "${pageContext.request.contextPath}/backstage/social/upload",
            data:  formData,
            type: "Post",
            dataType: "formData",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (data) {
				
            },
            error: function (data) {

            }
        })
	})
	
</script>
</html>