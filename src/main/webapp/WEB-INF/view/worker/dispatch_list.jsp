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
<link rel="stylesheet" type="text/css" href="style/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style"/>
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-rtl.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-skins.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/css/bootstrap-datepicker3.min.css"  />
<!-- ace settings handler -->
<script src="js/jquery.min.js"></script>
<script src="style/assets/js/bootstrap.min.js"></script>
<script src="style/assets/js/ace-elements.min.js"></script>
<script src="style/assets/js/ace.min.js"></script>
<script src="style/assets/js/ace-extra.min.js"></script>
<script src="style/assets/js/bootbox.js"></script>
<script src="style/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="style/assets/js/date-time/bootstrap-datepicker.zh-CN.min.js"></script>
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
						<li class="active">人员管理</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							人员管理
							<small> 
							<i class="ace-icon fa fa-angle-double-right"></i>
									详细
							</small>
						</h1>
					</div>
					<!-- 人员详细列表 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/workerList" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
					</form>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>派遣日期</th>
											<th>派遣时间</th>
											<th>收款金额</th>
											<th>付款金额</th>
											<th>工作地点</th>
											<th>备注</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="dispatch">
											<tr>
												<td>${dispatch.dispatchDate}</td>
												<td>
													<c:if test="${dispatch.dispatchTime == 0.5}">半天</c:if>
													<c:if test="${dispatch.dispatchTime == 1}">全天</c:if>
												</td>
												<td style="color: orange;"><i class="fa fa-jpy"></i>${dispatch.receiveMoney}</td>
												<td style="color: orange;"><i class="fa fa-jpy"></i>${dispatch.payMoney}</td>
												<td>${dispatch.workLocation}</td>
												<td>${dispatch.remark}</td>
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
					<!-- 人员详细列表 -->
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$("#worker").addClass("active");
	</script>
</body>
</html>

