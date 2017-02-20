<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="pages/include/css-include.jsp" />
<title>Insert title here</title>
</head>
<body>


	<form name="indexForm" class="form-horizontal">
	<div class="clearfix"></div>
	<div class="clearfix"></div>
	<div class="clearfix"></div>
	<div class="clearfix"></div>
	<div class="clearfix"></div>
	<div class="clearfix"></div>

		<div class="jumbotron col-xs-4 col-xs-offset-4 navbar-inner">

			<div class="">
				<div class="form-group">

					<div class="control-group col-xs-12">
						<legend class="text-center"> Bem vindo </legend>
					</div>

					<div class="control-group col-xs-12 lead">
						<Label class="label">Login</Label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> 
							<input type="text" id="user" Class="form-control" maxlength="20" required />
						</div>
					</div>

					<div class="control-group col-xs-12 lead">
						<label class="label">Senha</label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-key fa-fw"></i>
							</span> 
							<input type="text" Class="form-control" required maxlength="20" />
						</div>
					</div>

					<div class="control-group col-xs-12  ">
						<button class="btn btn-default btn-lg btn-block" ng-disabled="indexForm.$invalid">
							<a href="http://localhost:8085/Equipar/principal.jsp#/">
								<i class="fa fa-lock"></i>
								Login
							</a>
						</button>
					</div>
				</div>
			</div>
		</div>

	</form>

</body>
</html>