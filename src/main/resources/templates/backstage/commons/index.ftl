<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" type="text/css" href="../public/css/base.css">  -->
    <link rel="stylesheet" type="text/css" href="css/b_login.css">
	<title>后台登录页面</title>
</head>
<body>
<div class="login">
	<div class="loginmain">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;飞亚旅游管理系统</h2>
		
			<form action="#" class="form-horizontal">
		           <!-- 让表单在一行中显示form-horizontal -->
		          <div class="form-group">
		              <label for="username" class="col-lg-1 control-label">用户名</label>
		              <div class="col-lg-4">
		                <input type="text" name="username" id="username" class="form-control" placeholder="admin">
		              </div>              
		          </div>
				  <div class="form-group"></div>
				  <div class="form-group"></div>

		          <div class="form-group">
		              <label for="password" class="col-lg-1 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
		              <div class="col-lg-4">
		                <input type="password" name="password" id="password" class="form-control" placeholder="admin">
		              </div>              
		          </div>
                   <div class="form-group"></div>
                   <!-- <div class="form-group"></div> -->

		          <div class="form-group">
		            <div class="col-lg-11 col-lg-offset-1">              
		                <span class="checkbox ">
		                    <label><input type="checkbox" name="" class="checkbox-inline">记住我</label> 
		                </span>           
		            </div>
		          </div>

		          <div class="form-group">
		            <div class="col-lg-4 col-lg-offset-1">
		                <input type="button" name="button" value="登录" class="btn btn-danger btn-lg">
		                <span class="text"></span>              
		            </div>

		          </div>

		    </form>
	</div>
	<div class="rightpic">
		<div id="container">
			<!-- <img src="picture/1.jpg" alt="" width="500px" height="330px"> -->
		</div>
	</div>
</div>

<script src="./public/js/jquery-3.1.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script src="./public/js/delaunay.js"></script>
<script src="./public/js/TweenMax.js"></script>
<script src="js/effect.js"></script>

<script src="js/b_login.js"></script>	
</body>
</html>