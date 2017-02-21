<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="<%=basePath%>/" class="navbar-brand">
				<small>
					<i class="fa fa-leaf"></i>
					WareHouse
				</small>
			</a>
		</div>
		
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue">
					<a href="#" >
						<span class="user-info">
							<small style="margin-top: 10px;">欢迎登陆</small>
						</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>


