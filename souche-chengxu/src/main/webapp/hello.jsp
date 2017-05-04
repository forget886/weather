<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="http://assets.souche.com/shop/assets/sso/favicon.ico" type="image/x-icon">
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<title>首页</title>
	<style type="text/css">
		.button{
			padding:.3em .8em;
			border:1px solid rgba(0,0,0,.1);
			background: #6b0 linear-gradient(hsla(0,0%,100%,.2),transparent);
			border-radius:.2em;
			box-shadow: 0 .05em .25em rgba(0,0,0,.5);
			text-shadow:0 -.05em .05em rgba(0,0,0,.5);
			color:white;
			font-size:110%;
			line-height:1.5
		}
	</style>
	
</head>
<body>
  <%@ include file="jsp/head.jsp"%>
	<div style="text-align: center">
		<div>
			<form onsubmit="cleaar()"  action="select.do" method="POST">
				<select name="color" size="1">
					<option value="红色">red</option>
					<option value="黄色">yellow</option>
					<option value="蓝色">blue</option>
				</select>
				<input type="text" name="name" />
				<input type="submit" value="提交" class="button"/>
			</form>
		</div>
		<br><br> 
		<div>
			<form onsubmit="cleaar()" action="download.do" method="POST">
				<span>path:</span><input id="path" type="text" name="path" />
				<span>fileName:</span><input id="filename" type="text" name="filename" />
				<input type="submit" value="下载" class="button" onclick="return check();"/>
			</form>
		</div>
		
		<div id="message" style="display:none"></div>
	</div>
	<div id="time">
		<button type="button" onclick="getTime()">时间</button>
	</div>
	<%@ include file="jsp/foot.jsp"%>
	
</body>
<script type="text/javascript">
		console.log("basePath:" + '${basePath}');
		function getTime(){
			$.ajax({
				url: "time",
				xhrFields: {
				    withCredentials: true
				},
				success: function(data) {
					$('#time').html(data);
					$.ajax({
						url:"http://www.baidu.com",
						success:function(data){
							console.log(data);
						}
						
					});
				}
			});
		}
		
		function check(){
			var path = document.getElementById("path").value;
			var filename = document.getElementById("filename").value;
			//console.log(path + " : " + filename);
			if(path == '' || filename == ''){
				document.getElementById("message").style.display = "block";
				document.getElementById("message").innerHTML = "<span style=\"color:red;font-size:14px\">找不到</span>";
				return false;
			}else{
				
				return true;
			}
		}
		
		document.getElementById("path").addEventListener("input",function(){
			judge("path");
		});
		
		document.getElementById("filename").addEventListener("input", function(e){
			judge('filename');
		});
		
		function judge(id){
			if(document.getElementById(id).value.length > 0){
				document.getElementById("message").style.display = "none";
			}
		}
		
		/* 不要起chear函数名 */
		function cleaar(){
			console.log('clear');
		}

	</script>
</html>