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
<link rel="stylesheet" type="text/css" href="style/assets/css/ace.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-rtl.min.css"  />
<link rel="stylesheet" type="text/css" href="style/assets/css/ace-skins.min.css"  />
<!-- ace settings handler -->
<script src="js/jquery.min.js"></script>
<script src="style/assets/js/bootstrap.min.js"></script>
<script src="style/assets/js/jquery.validate.min.js"></script>
<script src="style/assets/js/ace-elements.min.js"></script>
<script src="style/assets/js/ace.min.js"></script>
<script src="style/assets/js/ace-extra.min.js"></script>
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
									添加
							</small>
						</h1>
					</div>
					<!-- 添加人员  -->
					<div class="row">
						<div class="col-xs-12">
							<form id="createForm" class="form-horizontal" role="form" action="<%=path%>/createWorker" method="post">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="workerNumber"> 工号</label>
									<div class="col-sm-9">
										<input type="text" id="workerNumber" class="col-xs-10 col-sm-4" name="workerNumber"/>
									</div>
								</div>
		
								<div class="space-4"></div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="workerName"> 姓名</label>
									<div class="col-sm-9">
										<input type="text" id="workerName" class="col-xs-10 col-sm-4" name="workerName"/>
									</div>
								</div>
								
								<div class="space-4"></div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="phone"> 联系方式</label>
									<div class="col-sm-9">
										<input type="text" id="phone" class="col-xs-10 col-sm-4" name="phone"/>
									</div>
								</div>
								
								<div class="space-4"></div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="remark"> 备注 </label>
									<div class="col-sm-9">
										<input type="text" id="remark" class="col-xs-10 col-sm-4" name="remark"/>
									</div>
								</div>
		
								<div class="space-4"></div>
		
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<a onclick="history.back()"  class="btn"><i class="icon-reply bigger-110"></i>返&nbsp;回</a>
										&nbsp; &nbsp; &nbsp;
										<a id="submitBtn" class="btn btn-info"><i class="icon-ok bigger-110"></i>提&nbsp;交</a>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- 添加人员 -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#goods").addClass("active");
		// 点击提交
		$("#submitBtn").click(function() {
			$("#createForm").submit();
		});

		// 校验表单
		$("#createForm").validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				workerNumber : {
					required : true,
					remote:{
			               type:"post",
			               url:"<%=path%>/checkWorkerNumber",           
			               data:{ workerNumber: function() { return $("#workerNumber").val(); }} 
					}
				},
				workerName : {
					required : true
				}
			},
			messages : {
				workerNumber : {
					required : "请输入工号",
					remote: "工号已存在"
				},
				workerName : {
					required : "请输入姓名"
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

