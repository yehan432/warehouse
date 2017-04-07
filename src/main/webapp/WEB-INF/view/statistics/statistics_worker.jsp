<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>销售统计</title>
<!-- basic styles -->
<link rel="stylesheet" type="text/css" href="style/assets/css/bootstrap.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="style/assets/css/fonts.googleapis.com.css" />
<link rel="stylesheet" type="text/css" href="style/assets/css/ace.min.css "  class="ace-main-stylesheet" id="main-ace-style"/>
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-rtl.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-skins.min.css"  />
<!-- ace settings handler -->
<script src="js/jquery.min.js"></script>
<script src="style/assets/js/bootstrap.min.js"></script>
<script src="style/assets/js/jquery.validate.min.js"></script>
<script src="style/assets/js/ace-elements.min.js"></script>
<script src="style/assets/js/ace.min.js"></script>
<script src="style/assets/js/ace-extra.min.js"></script>
<script src="style/assets/js/bootbox.js"></script>
</head>

<body class="no-skin">
	<%@ include file="../head.jsp"%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div>
			<%@ include file="../menu.jsp"%>
			<!-- 主页面 -->
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="<%=basePath%>/">主页</a>
						</li>
						<li class="active">销售统计</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							销售统计
							<small> 
							<i class="ace-icon fa fa-angle-double-right"></i>
									人员统计
							</small>
						</h1>
					</div>
					<!-- 销售统计 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/workerStatisticsList" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
						<label style="margin-left:20px;">查询区间: </label>
						<div style="display:inline-block;" class="form-group">
							<select name="type" style="height:34px;width:163px;">
								<option value="0" <c:if test="${condition.type == 0}">selected</c:if>>全部</option>
								<option value="1" <c:if test="${condition.type == 1}">selected</c:if>>本年</option>
								<option value="2" <c:if test="${condition.type == 2}">selected</c:if>>本月</option>
							</select> 
						</div>
						<button type="submit" id="btn" class="btn btn-sm btn-primary" style="margin-left:20px;margin-top:-3px;">查询</button>
					</form>
					<br/>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>工号</th>
											<th>姓名</th>
											<th>派遣时间合计</th>
											<th>收款合计</th>
											<th>付款合计</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="statistics">
											<tr>
												<td>${statistics.workerNumber}</td>
												<td>${statistics.workerName}</td>
												<td>${statistics.dayTotal}天</td>
												<td style="color: orange;">
													<i class="fa fa-jpy"></i> ${statistics.receiveTotal}
												<td style="color: orange;">
													<i class="fa fa-jpy"></i> ${statistics.sendTotal}
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<c:if test="${page.totalPage > 1}">
									<%@ include file="../page.jsp"%>
								</c:if>
							</div>
						</div>
					</div>
					<!-- 销售统计 -->
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$("#statistics").addClass("active");
	</script>
</body>
</html>

