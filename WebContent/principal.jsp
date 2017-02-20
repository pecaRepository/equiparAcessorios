<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="appequipar">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="pages/include/css-include.jsp" />


<title>Equipar</title>

</head>
<body onload="piscando();">
	<div class="view-container">
		<jsp:include page="pages/include/menu.jsp" />

		<div id="principal" ng-view class="container view-frame"></div>
	</div>

	<jsp:include page="pages/include/js-include.jsp" />

</body>
</html>