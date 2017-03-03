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
		<li id="goods">
			<a href="<%=basePath%>/goodsList"> 
				<i class="menu-icon fa fa-cubes"></i> 
				<span class="menu-text">货物管理</span>
			</a> 
		</li>
		<li id="shop">
			<a href="<%=basePath%>/shopList"> 
				<i class="menu-icon fa fa-home"></i> 
				<span class="menu-text">店铺管理</span>
			</a> 
		</li>
		<li id="inventory">
			<a href="<%=basePath%>/inventoryList"> 
				<i class="menu-icon fa fa-truck"></i> 
				<span class="menu-text">库存管理</span>
			</a> 
		</li>
		<li id="statistics">
			<a href="<%=basePath%>/statisticsList"> 
				<i class="menu-icon fa fa-bar-chart-o"></i> 
				<span class="menu-text">销售统计 </span>
			</a> 
		</li>
	</ul>
</div>

