<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/global.jsp"%>
<link type="text/css" href="${STATIC_PATH}/css/estore/store/list.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<div class="main">
		<div class="main-left">
			<%@ include file="../../common/left.jsp"%>
		</div>
		<div class="main-right">
			<%@ include file="../../common/crumbs.jsp"%>
			<div id="outerId"></div>
		</div>
	</div>
	<script type="text/javascript" src="${STATIC_PATH}/js/estore/store/list.js"></script>
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>