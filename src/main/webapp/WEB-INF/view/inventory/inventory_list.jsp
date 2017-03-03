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
						<li class="active">库存管理</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							库存管理
							<small> 
							<i class="ace-icon fa fa-angle-double-right"></i>
									查看
							</small>
						</h1>
					</div>
					<!-- 店铺管理列表 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/shopList" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
					</form>
					<a href="#my-modal" class="btn btn-sm btn-success" data-toggle="modal" style="margin-bottom: 15px; float: right;">货物入库</a>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>货物名称</th>
											<th>库存量</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="inventory">
											<tr>
												<td>${inventory.goodsName}</td>
												<td>${inventory.quantity}</td>
												<td>
													<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
														<a class="green" href="updateInventory?goodsId=${inventory.goodsId}" title="编辑">
															<i class="ace-icon fa fa-pencil bigger-130"></i>
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
					<!-- 店铺管理列表 -->
				</div>
			</div>
		</div>
	</div>
	
	<div id="my-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">货物入库</h3>
				</div>
				<form id="submitForm" role="form" action="<%=path%>/warehousing" method="post">
					<div class="modal-body">
						<div class="form-group" style="width: 26%;">
							<label for="goodsId">货物：</label>
							<select class="form-control" id ="goodsId" name ="goodsId">
								<c:forEach items="${goodsList}" var="list">
									<option value="${list.goodsId}">${list.goodsName}</option>
								</c:forEach>
							</select> 
	 					</div>
						<div class="form-group" style="width: 26%;">
							<label for="amount">入库数量 ：</label>
							<input class="form-control" type="text" id="quantity" name="quantity" style="width:100%;" maxlength="10"/>
	 					</div>
						<div class="modal-footer">
							<button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" style="margin-left:10px;">
								<i class="ace-icon fa fa-times"></i>
								关闭
							</button>
							<button id="submitBtn" class="btn btn-sm btn-success pull-right">
								<i class="ace-icon fa fa-check"></i>
								提交
							</button>
						</div>
					</div>
				</form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
	
	
	<script type="text/javascript">
		$("#inventory").addClass("active");

		//点击提交
		$("#submitBtn").click(function() {
			$("#submitForm").submit();
		});
		
		// 校验表单
		$("#submitForm").validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				quantity : {
					required : true,
					digits : true
				}
			},
			messages : {
				quantity : {
					required : "请输入入库数量",
					digits : "请输入整数"
				}
			},

			invalidHandler : function(event, validator) { //display error alert on form submit   
				$('.alert-danger', $('.login-form')).show();
			},

			highlight : function(e) {
				$(e).closest('.form-group').removeClass('has-info')
						.addClass('has-error');
			},

			success : function(e) {
				$(e).closest('.form-group').removeClass('has-error')
						.addClass('has-info');
				$(e).remove();
			}
		});
	</script>
</body>
</html>

