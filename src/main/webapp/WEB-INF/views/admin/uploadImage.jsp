<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="51拉钩后台管理系统">
<meta name="author" content="云顶畅游">
<link rel="icon" href="<c:url value="/images/icon.png" />">

<title>51拉钩后台管理系统</title>

</head>
<body>
	<form action="<c:url value="/admin/saveUploadImage" />" method="POST"
		enctype="multipart/form-data">
		<input type="file" name="file" /><input type="submit" value="上传" />
	</form>
	<c:if test="${uploadStatus==true}">
		<script type="text/javascript">
			var url = "${url}";
			parent.imageUploaded(url);
		</script>
	</c:if>
</body>
</html>