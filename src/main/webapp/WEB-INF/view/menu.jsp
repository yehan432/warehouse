<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
		</div>
	</div>
	<!-- #sidebar-shortcuts -->
	<ul class="nav nav-list">
		<li class="active">
			<a href="<%=basePath%>/shop"> 
				<i class="menu-icon fa fa-home"></i> 
				<span class="menu-text">店铺管理</span>
			</a> 
			<b class="arrow"></b>
		</li>
		<li>
			<a href="<%=basePath%>/sale"> 
				<i class="menu-icon fa fa-bar-chart-o"></i> 
				<span class="menu-text">销售统计 </span>
			</a> 
		</li>
	</ul>
</div>

