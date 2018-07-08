<%@page import="com.nlu.util.SystemUtil"%>
<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
<!-- Resource style -->
<script src="<%=request.getContextPath()%>/js/modernizr.js"></script>
<!-- Modernizr -->

	<ul class="cd-accordion-menu animated">
		<li class="has-children">
			<input type="checkbox" name ="group-1" id="group-1" checked>
			<label for="group-1">Group 1</label>

      		<ul>
      			<li class="has-children">
      				<input type="checkbox" name ="sub-group-1" id="sub-group-1">
					<label for="sub-group-1">Sub Group 1</label>

					<ul>
						<li><a href="#0">Image</a></li>
						<li><a href="#0">Image</a></li>
						<li><a href="#0">Image</a></li>
					</ul>
      			</li>
      			<li class="has-children">
      				<input type="checkbox" name ="sub-group-2" id="sub-group-2">
					<label for="sub-group-2">Sub Group 2</label>

					<ul>
						<li class="has-children">
							<input type="checkbox" name ="sub-group-level-3" id="sub-group-level-3">
							<label for="sub-group-level-3">Sub Group Level 3</label>

							<ul>
								<li><a href="#0">Image</a></li>
								<li><a href="#0">Image</a></li>
							</ul>
						</li>
						<li><a href="#0">Image</a></li>
					</ul>
      			</li>
      			<li><a href="#0">Image</a></li>
				<li><a href="#0">Image</a></li>
      		</ul>
		</li>

		<li class="has-children">
			<input type="checkbox" name ="group-2" id="group-2">
			<label for="group-2">Group 2</label>

			<ul>
				<li><a href="#0">Image</a></li>
				<li><a href="#0">Image</a></li>
			</ul>
		</li>

		<li class="has-children">
			<input type="checkbox" name ="group-3" id="group-3">
			<label for="group-3">Group 3</label>

			<ul>
				<li><a href="#0">Image</a></li>
				<li><a href="#0">Image</a></li>
			</ul>
		</li>

		<li class="has-children">
			<input type="checkbox" name ="group-4" id="group-4">
			<label for="group-4">Group 4</label>

			<ul>
				<li class="has-children">
					<input type="checkbox" name ="sub-group-3" id="sub-group-3">
					<label for="sub-group-3">Sub Group 3</label>

					<ul>
						<li><a href="#0">Image</a></li>
						<li><a href="#0">Image</a></li>
					</ul>
				</li>
				<li><a href="#0">Image</a></li>
				<li><a href="#0">Image</a></li>
			</ul>
		</li>
	</ul> <!-- cd-accordion-menu -->
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js"></script>
