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
						<li class="active">店铺管理</li>
					</ul>
				</div>
				<div class="page-content">
					<div class="page-header">
						<h1>
							店铺管理
							<small> 
							<i class="ace-icon fa fa-angle-double-right"></i>
									详情
							</small>
						</h1>
					</div>
					<!-- 店铺详细信息 -->
					<a href="#receive-modal" class="btn btn-sm btn-success" data-toggle="modal" style="margin-left:10px;margin-bottom: 15px; float: right;">收    款</a>
					<a href="#send-modal" class="btn btn-sm btn-success" data-toggle="modal" style="margin-bottom: 15px; float: right;">发    货</a>
					<div class="row">
						<div class="col-xs-12">
							<!-- 店铺信息 -->
							<div id="accordionShop" class="accordion-style1 panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionShop" href="#collapseShop"> 
											<i class="icon-angle-down bigger-110" data-icon-hide="icon-angle-down" data-icon-show="icon-angle-right"></i>
												&nbsp;店铺信息
											</a>
										</h4>
									</div>
									<div class="panel-collapse collapse in" id="collapseShop">
										<div class="profile-info-row">
											<div class="profile-info-name"> 店铺名称</div>
											<div class="profile-info-value">
												<span class="editable">${shop.shopName}</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> 加盟费 </div>
											<div class="profile-info-value">
												<span class="editable" style="color: orange;"><i class="fa fa-jpy"></i> ${shop.shopFee}</span>
											</div>
										</div>
									</div>
								</div>
							</div><!-- 店铺信息 -->
						</div>
					</div><!-- 店铺详细信息 -->
					<!-- 交易列表 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/shopDetail" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
						<input type="hidden" id="shopId" name="shopId" value="${shop.shopId}">
					</form>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>交易时间</th>
											<th>交易价格</th>
											<th>交易数量</th>
											<th>交易类型</th>
											<th>货物名称</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="trade">
											<tr>
												<td>${trade.tradeTime}</td>
												<td style="color: <c:if test="${trade.type == 1}">green</c:if><c:if test="${trade.type == 0}">red</c:if>;">
													<i class="fa fa-jpy"></i> ${trade.price}
												</td>
												<td>${trade.amount}</td>
												<td><c:if test="${trade.type == 0}">收款</c:if><c:if test="${trade.type == 1}">发货</c:if></td>
												<td>${trade.goodsName}</td>
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
					<!-- 交易列表 -->
				</div>
			</div>
		</div>
	</div>

	<div id="send-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">店铺发货</h3>
				</div>
				<form id="sendForm" role="form" action="<%=path%>/send" method="post">
					<input type="hidden" id="target" name="target" value="${shop.shopId}">
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
							<label for="amount">发货数量：</label>
							<input class="form-control" type="text" id="amount" name="amount" style="width:100%;" maxlength="10"/>
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="price">单价(元)：</label>
							<input class="form-control" type="text" id="price" name="price" style="width:100%;" maxlength="10"/>
	 					</div>
					</div>
		
					<div class="modal-footer">
						<button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" style="margin-left:10px;">
							<i class="ace-icon fa fa-times"></i>
							关闭
						</button>
						<button id="sendBtn" class="btn btn-sm btn-success pull-right">
							<i class="ace-icon fa fa-check"></i>
							提交
						</button>
					</div>
				</form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>
	
	<div id="receive-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">店铺收款</h3>
				</div>
				<form id="receiveForm" role="form" action="<%=path%>/receive" method="post">
					<input type="hidden" id="target" name="target" value="${shop.shopId}">
					<div class="modal-body">
	 					<div class="form-group" style="width: 26%;">
							<label for="price">收款金额(元)：</label>
							<input class="form-control" type="text" id="price" name="price" style="width:100%;" maxlength="10"/>
	 					</div>
					</div>
		
					<div class="modal-footer">
						<button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" style="margin-left:10px;">
							<i class="ace-icon fa fa-times"></i>
							关闭
						</button>
						<button id="receiveBtn" class="btn btn-sm btn-success pull-right">
							<i class="ace-icon fa fa-check"></i>
							提交
						</button>
					</div>
				</form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div>

	<script type="text/javascript">
		$("#shop").addClass("active");
		
		//点击提交
		$("#sendBtn").click(function() {
			$("#sendForm").submit();
		});
		
		$("#receiveBtn").click(function() {
			$("#receiveForm").submit();
		});
		
		// 校验表单
		$("#sendForm").validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				amount : {
					required : true,
					digits : true
				},
				price : {
					required : true,
					number : true
				}
			},
			messages : {
				amount : {
					required : "请输入发货数量",
					digits : "请输入整数"
				},
				price : {
					required : "请输入单价",
					number : "请输入数字"
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
		
		// 校验表单
		$("#receiveForm").validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				price : {
					required : true,
					number : true
				}
			},
			messages : {
				price : {
					required : "请输入金额",
					number : "请输入数字"
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

