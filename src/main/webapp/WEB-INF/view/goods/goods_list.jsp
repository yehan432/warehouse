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
						<li class="active">货物管理</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							货物管理
							<small> 
							<i class="ace-icon fa fa-angle-double-right"></i>
									查看
							</small>
						</h1>
					</div>
					<!-- 货物管理列表 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/goodsList" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
					</form>
					<a href="<%=path%>/createGoods" class="btn btn-sm btn-success" style="margin-bottom: 15px; float: right;">添加货物</a>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>货物名称</th>
											<th>货物品牌</th>
											<th>产品规格</th>
											<th>备注</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="goods">
											<tr>
												<td>${goods.goodsName}</td>
												<td>${goods.brand}</td>
												<td>${goods.specification}</td>
												<td>${goods.remark}</td>
												<td>
													<div>
														<a class="blue" href="goodsDetail?goodsId=${goods.goodsId}" title="查看">
															<i class="ace-icon fa fa-search-plus bigger-130"></i>
														</a>
														<a class="green" href="updateGoods?goodsId=${goods.goodsId}" title="编辑">
															<i class="ace-icon fa fa-pencil bigger-130"></i>
														</a>
														<a class="red" href="#" title="删除" onclick="deleteGoods('${goods.goodsId}');">
															<i class="ace-icon fa fa-trash-o bigger-130"></i>
														</a>
													</div>
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
					<!-- 货物管理列表 -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#goods").addClass("active");
		// 删除
		function deleteGoods(id) {
			bootbox.setDefaults("locale","zh_CN");  
			bootbox.confirm("确认删除？", function(re) {
				if (re) {
					location.href = "deleteGoods?goodsId=" + id;
				}
			});
		}
	</script>
</body>
</html>

