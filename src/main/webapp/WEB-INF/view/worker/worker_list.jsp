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
									查看
							</small>
						</h1>
					</div>
					<!-- 人员管理列表 -->
					<form id="queryForm" class="form-inline checkForm" action="<%=path%>/workerList" method="get">
						<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
					</form>
					<a href="<%=path%>/createWorker" class="btn btn-sm btn-success" style="margin-bottom: 15px; float: right;">添加员工</a>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>工号</th>
											<th>姓名</th>
											<th>联系方式</th>
											<th>备注</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list}" var="worker">
											<tr>
												<td><a class="blue" href="dispatchList?workerNumber=${worker.workerNumber}">${worker.workerNumber}</a></td>
												<td>${worker.workerName}</td>
												<td>${worker.phone}</td>
												<td>${worker.remark}</td>
												<td>
													<div>
														<a class="blue" href="dispatchList?workerNumber=${worker.workerNumber}" title="查看">
															<i class="ace-icon fa fa-search-plus bigger-130"></i>
														</a>&nbsp;
														<a id="${worker.workerNumber}" class="orange" href="#dispatch-modal" data-toggle="modal" title="派遣">
															<i class="ace-icon fa fa-hand-o-right bigger-130"></i>
														</a>&nbsp;
														<a class="green" href="updateWorker?workerNumber=${worker.workerNumber}" title="编辑">
															<i class="ace-icon fa fa-pencil bigger-130"></i>
														</a>&nbsp;
														<a class="red" href="#" title="删除" onclick="deleteWorker('${worker.workerNumber}');">
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
					<!-- 人员管理列表 -->
				</div>
			</div>
		</div>
	</div>
	
	<div id="dispatch-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">员工派遣  :  <label id="workerNumberText"></label></h3>
				</div>
				<form id="sendForm" role="form" action="<%=path%>/sendWorker" method="post">
					<input type="hidden" id="workerNumber" name="workerNumber">
					<div class="modal-body">
						<div class="form-group" style="width: 26%;">
							<label for="dispatchDate">派遣日期：</label>
							<div class="input-group">
								<input class="form-control datepicker" type="text" id="dispatchDate" name="dispatchDate" style="width:100%;" maxlength="10" />
								<span class="input-group-addon">
									<i class="fa fa-calendar bigger-110"></i>
								</span>
							</div>
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="dispatchTime">派遣时间：</label>
							<select class="form-control" id ="dispatchTime" name ="dispatchTime">
								<option value="0.5">半天</option>
								<option value="1">全天</option>
							</select> 
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="receiveMoney">收款金额(元)：</label>
							<input class="form-control" type="text" id="receiveMoney" name="receiveMoney" style="width:100%;" maxlength="10"/>
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="payMoney">付款金额(元)：</label>
							<input class="form-control" type="text" id="payMoney" name="payMoney" style="width:100%;" maxlength="10"/>
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="workLocation">办公地点：</label>
							<input class="form-control" type="text" id="workLocation" name="workLocation" style="width:100%;" maxlength="10"/>
	 					</div>
	 					<div class="form-group" style="width: 26%;">
							<label for="remark">备注：</label>
							<input class="form-control" type="text" id="remark" name="remark" style="width:100%;" maxlength="10"/>
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
	
	<script type="text/javascript">
		$("#worker").addClass("active");
		// 删除
		function deleteWorker(workerNumber) {
			bootbox.setDefaults("locale","zh_CN");  
			bootbox.confirm("确认删除？", function(re) {
				if (re) {
					location.href = "deleteWorker?workerNumber=" + workerNumber;
				}
			});
		}
		// 派遣
		$(".orange").click(function() {
			$("#workerNumberText").text(this.id);
			$("#workerNumber").val(this.id);
		});
		
		// 日期插件
		$(function () {
	        $(".datepicker").datepicker({
	            language: "zh-CN",
	            autoclose: true,//选中之后自动隐藏日期选择框
	            todayHighlight: true,
	            todayBtn: true,//今日按钮
	            clearBtn: true,//今日按钮
	            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
	        });
	    });
	</script>
</body>
</html>

