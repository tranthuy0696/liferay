<%@include file="init.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<div class="container">
		<!-- 	menu -->
			<jsp:include page="menu.jsp"></jsp:include>

			<div class="tabbable">
				<!-- Only required for left/right tabs -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab1" data-toggle="tab">Thực
							tế</a></li>
					<li><a href="#tab2" data-toggle="tab">Thống kê</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
					<div class="chart-container" style="position: relative;height:70vh; width:76vw">
    					<canvas id="myChart" width="493" height="220" style="display: block; width: 493px; height: 220px;">
    					</canvas>
  				   </div>
					<div>
					<h3 class="text-center" id="memoryUsage"></h3>
					</div>
					</div>
					<div class="tab-pane" id="tab2">
						<aui:select name="dateType" label="Chọn ngày" id="chonNgay">
							<aui:option label="Ngày hiện tại" value="TODAY" selected="true" />
							<aui:option label="1 ngày trước" value="ONE_DATE_AGO" />
							<aui:option label="2 ngày trước" value="TWO_DATE_AGO" />
							<aui:option label="3 ngày trước" value="THREE_DATE_AGO" />
							<aui:option label="4 ngày trước" value="FOUR_DATE_AGO" />
							<aui:option label="5 ngày trước" value="FIVE_DATE_AGO" />
							<aui:option label="6 ngày trước" value="SIX_DATE_AGO" />
						</aui:select>
						<div class="chart-container" style="position: relative;height:70vh; width:76vw">
    					<canvas id="report" width="493" height="220" style="display: block; width: 493px; height: 220px;">
    					</canvas>
  				   </div>
					</div>
				</div>
			</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
