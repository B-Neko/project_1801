<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!--easyui-->
<script src="${pageContext.request.contextPath}/easyui/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/fjny.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/superBlue.css" id="themeCss" />
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/easyui/themes/super/super.js"></script>
<script src="${pageContext.request.contextPath}/js/superDemo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body id="main" class="easyui-layout">
	<div data-options="region:'north',border:false" class="super-north">
		<!--顶部-->
		<div class="super-navigation">
			<!--系统名称-->
			<div class="super-navigation-title">SUPER THEME</div>
			<!--自定义导航-->
			<div class="super-navigation-main">
				<div class="super-setting-left">
					<ul>
						<li><i class="fa fa-commenting-o"></i>消息</li>
						<li><i class="fa fa-envelope-o"></i>邮件</li>
						<li><i class="fa fa-bell-o"></i>通知</li>
					</ul>
				</div>
				<div class="super-setting-right">
					<ul>
						<li>
							<div class="super-setting-icon">
								<i class="fa fa-gears"></i>
							</div>
							<div id="mm" class="easyui-menu">
								<div>个人中心</div>
								<div id="themeSetting">主题</div>
								<div class="menu-sep"></div>
								<div id="logout">退出</div>
							</div>
						</li>
						<li class="user"><span class="user-icon"><img
								src="img/favicon.png" /></span>管理员</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'west',title:'MAIN NAVIGATION',border:false"
		class="super-west">
		<!--左侧导航-->
		<div class="easyui-accordion"
			data-options="border:false,fit:true,selected:true">
			<div title="商品管理" data-options="iconCls:'fa fa-table'">
				<ul>
					<li id = "item-list" data-url='item-list'>商品列表</li>
					<li id = "item-add"  data-url='item-add'>添加商品</li>
					<li id = "item-param-list"  data-url='item-param-list'>规则参数</li>
				</ul>
			</div>
			<div title="网站内容管理" data-options="iconCls:'fa fa-table'">
				<ul>
					<li id = "icontent-category" data-url='${pageContext.request.contextPath}/content-category'>内容分类管理</li>
					<li id = "content"  data-url='${pageContext.request.contextPath}/content'>内容管理</li>
				</ul>
			</div>
			<div title="Swagger-UI文档" data-options="iconCls:'fa fa-table'">
			<ul>
				<li><a href="${pageContext.request.contextPath}/swagger/index.html">商家接口文档</a></li>
				<li><a href="http://localhost:8081/swagger-ui.html">apk接口文档</a></li>
			</ul>				
			</div>
		</div>
	</div>
	<div data-options="region:'center'" style="padding-top: 2px;">
		<!--主要内容-->
		<div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
			<div title="首页" data-options="iconCls:'fa fa-home'">
<!-- 外接页面开始 -->
		<link type="text/css" href="/css/css/public.css" rel="stylesheet">
		<link type="text/css" href="/css/css/icon.css" rel="stylesheet">
		<link type="text/css" href="/css/css/index.css" rel="stylesheet">
		<script type="text/javascript">
            document.documentElement.style.fontSize = document.documentElement.clientWidth /768*100 + 'px';
        </script>
        <script src="js/js/echarts.min.js"></script>
				<div class="bg">
	<div class="title">商家数据</div>
    <div class="leftMain">
    	<div class="leftMain_top">
        	<div class="leftMain_topIn">
            	<ul>
                	<li>
                        <div class="liIn">
                            <h3>标题1</h3>
                            <p class="shu"><span class="shu1">6890.69</span><i>元</i></p>
                            <div class="zi"><span class="span1">小标题：文字</span><span>小标题：文字</span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                	<li>
                        <div class="liIn">
                            <h3>标题2</h3>
                            <p class="shu"><span class="shu2">6090.99</span><i>元</i></p>
                            <div class="zi"><span class="span1">小标题：文字</span><span>小标题：文字</span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                	<li>
                        <div class="liIn">
                            <h3>标题3</h3>
                            <p class="shu"><span class="shu3">2890.39</span><i>元</i></p>
                            <div class="zi"><span class="span1">小标题：文字</span><span>小标题：文字</span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                	<li>
                        <div class="liIn">
                            <h3>标题4</h3>
                            <p class="shu"><span class="shu4">7590.15</span><i>元</i></p>
                            <div class="zi"><span class="span1">小标题：文字</span><span>小标题：文字</span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="leftMain_middle">
        	<div class="leftMain_middle_left">
            	<div class="leftMain_middle_leftIn">
                	<h3>图表1</h3>
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom 柱状图表-->
                    <div class="biaoge" style="width:80%; height:25vh" id="chartmain"></div>
                    <script type="text/javascript">
					//window.onload = function () {
								//指定图表的配置项和数据
								var dataAxis = ['1日', '2日', '3日', '4日', '5日', '6日', '7日', '8日', '9日', '10日', '11日', '12日', '13日', '14日', '15日'];
								var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 200];
								var yMax = 500;
								var dataShadow = [];
								
								for (var i = 0; i < data.length; i++) {
									dataShadow.push(yMax);
								}
								
								option = {
									title: {
										text: '',
										subtext: ''
									},
									grid:{
										x:40,
										y:40,
										x2:20,
										y2:20,
										
									},
									xAxis: {
										data: dataAxis,
										axisLabel: {
											/*inside: true,*/
											interval:0,
											textStyle: {
												color: '#fff',
												fontSize: 12
												
											}
										},
										axisTick: {
											show: false,
										},
										axisLine: {
											show: true,
											symbol:['none', 'arrow'],
											symbolOffset: 12,
											lineStyle:{
												color: '#fff',
											}
										},
										z: 10
									},
									yAxis: {
										type: 'value',
										name: '单位：元',
										axisLine: {
											show: true,
											symbol: ['none', 'arrow'],
											symbolOffset: 12,
											lineStyle:{
												color: '#fff',
											}
										},
										axisTick: {
											show: false
										},
										axisLabel: {
											textStyle: {
												color: '#fff',
												fontSize: 12
											}
										}
									},

									dataZoom: [
										{
											type: 'inside'
										}
									],
									series: [
										{ // For shadow
											type: 'bar',
											itemStyle: {
												color: 'rgba(0,0,0,0.05)'
											},
											barGap: '-100%',
											barCategoryGap: '40%',
											data: dataShadow,
											animation: false
										},
										{
											type: 'bar',
											itemStyle: {
												color: new echarts.graphic.LinearGradient(
													0, 0, 0, 1,
													[
														{offset: 0, color: '#0efdff'},
														{offset: 0.5, color: '#188df0'},
														{offset: 1, color: '#188df0'}
													]
												)
											},
											emphasis: {
												itemStyle: {
													color: new echarts.graphic.LinearGradient(
														0, 0, 0, 1,
														[
															{offset: 0, color: '#2378f7'},
															{offset: 0.7, color: '#2378f7'},
															{offset: 1, color: '#0efdff'}
														]
													)
												}
											},
											data: data
										}
									]
								};
								
								// Enable data zoom when user click bar.
								/*var zoomSize = 6;
								myChart.on('click', function (params) {
									console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
									myChart.dispatchAction({
										type: 'dataZoom',
										startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
										endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
									});
								});*/
							
								//获取dom容器
								var myChart = echarts.init(document.getElementById('chartmain'));
								// 使用刚指定的配置项和数据显示图表。
								myChart.setOption(option);
						//};
					</script>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        	<div class="leftMain_middle_right">
            	<div class="leftMain_middle_rightIn">
                	<h3>图表2</h3>
                    <div class="biaoge biaoge_pai" style="width:100%; height:30vh">
                    	<div class="biaoge_paiIn">
                        	<ul>
                            	<li>
                                	<div class="liIn">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第一名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:98.5%;"></div></div>
                                        <p class="num">98.5%</p>
                                    </div>
                                </li>
                             	<li>
                                	<div class="liIn liIn2">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第二名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:88.5%;"></div></div>
                                        <p class="num">88.5%</p>
                                    </div>
                                </li>
                            	<li>
                                	<div class="liIn liIn3">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第三名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:68.5%;"></div></div>
                                        <p class="num">68.5%</p>
                                    </div>
                                </li>
                            	<li>
                                	<div class="liIn liIn4">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第四名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:40.5%;"></div></div>
                                        <p class="num">40.5%</p>
                                    </div>
                                </li>
                            	<li>
                                	<div class="liIn liIn5">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第五名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:22.5%;"></div></div>
                                        <p class="num">22.5%</p>
                                    </div>
                                </li>
                            	<li>
                                	<div class="liIn liIn6">
                                    	<div class="liIn_left"><span class="bot"></span><span class="zi">第六名</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:10.5%;"></div></div>
                                        <p class="num">10.5%</p>
                                    </div>
                                </li>
                           </ul>
                        </div>
                    </div>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        </div>
        <div class="leftMain_middle">
        	<div class="leftMain_middle_left">
            	<div class="leftMain_middle_leftIn">
                	<h3>图表3</h3>
                    <div class="biaoge" style="width:80%; height:25vh" id="chartmain_zhe"></div>
                    <script type="text/javascript">
					//window.onload = function (){
								//指定图表的配置项和数据
								
					option = {
						title: {
							text: ''
						},
						tooltip: {
							trigger: 'axis'
						},
						legend: {
							textStyle: {
								color: '#fff',
								fontSize: 12,
							},
							right:'10%',
							data: ['折线一', '折线二']
						},
						grid:{
								x:40,
								y:40,
								x2:20,
								y2:20,
							},
						toolbox: {
							feature: {
								//saveAsImage: {}
							}
						},
						xAxis: {
							type: 'category',
							boundaryGap: false,
							axisLabel: {
											/*inside: true,*/
											interval:0,
											textStyle: {
												color: '#fff',
												fontSize: 12
												
											}
										},
										axisTick: {
											show: false,
										},
										axisLine: {
											show: true,
											symbol:['none', 'arrow'],
											symbolOffset: 12,
											lineStyle:{
												color: '#fff',
											}
										},
							data: ['00:00', '02:00', '04:00', '06:00', '08:00', '10:00', '12:00']
						},
						yAxis: {
							type: 'value',
							
							axisLine: {
								show: true,
								symbol: ['none', 'arrow'],
								symbolOffset: 12,
								lineStyle:{
									color: '#fff',
								}
							},
							axisTick: {
								show: false
							},
							axisLabel: {
								textStyle: {
									color: '#fff',
									fontSize: 12
								}
							}
						},
						series: [
							{
								name: '折线一',
								type: 'line',
								stack: '总量',
								data: [280, 102, 191, 134, 390, 230, 210],
								itemStyle: {
									 normal: {
									   color: "#0efdff",//折线点的颜色
									   lineStyle: {
									   color: "#0efdff",//折线的颜色
									   width:2,
									  }
									},
								}
							},
							{
								name: '折线二',
								type: 'line',
								stack: '总量',
								data: [100, 132, 131, 234, 290, 330, 110]
							},
						]
					};		
								//获取dom容器
								var myChart = echarts.init(document.getElementById('chartmain_zhe'));
								// 使用刚指定的配置项和数据显示图表。
								myChart.setOption(option);
						//};
					</script>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        	<div class="leftMain_middle_right">
            	<div class="leftMain_middle_rightIn">
                	<h3>收益比例</h3>
                    <div class="biaoge biaoge_bi" style="width:100%; height:25vh">
                    	<ul>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu1">23</p>
                                    <p class="zi">今日收益比例</p>
                                </div>
                            </li>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu2">107</p>
                                    <p class="zi">本月收益比例</p>
                                </div>
                            </li>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu3">107</p>
                                    <p class="zi">历史收益比例</p>
                                </div>
                            </li>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu4">23</p>
                                    <p class="zi">今日收益比例</p>
                                </div>
                            </li>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu5">23</p>
                                    <p class="zi">本月收益比例</p>
                                </div>
                            </li>
                        	<li>
                            	<div class="liIn">
                                	<p class="shu shu6">23</p>
                                    <p class="zi">历史收益比例</p>
                                </div>
                            </li>
                        </ul>
                    
                    </div>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        </div>
    </div>
    <div class="rightMain">
        <div class="rightMain_top">
            <div class="rightMain_topIn">
                <h3>数据统计</h3>
                <div class="biaoge" style="width:80%; height:30vh" id="chartmain_bing"></div>
                <script type="text/javascript">
					option = {
						title: {
							text: '数据情况统计',
							subtext: '',
							left: 'right',
							textStyle: {
								color: '#fff',
								fontSize: 12
							}
						},
						tooltip: {
							trigger: 'item',
							formatter: '{a} <br/>{b} : {c} ({d}%)'
						},
						legend: {
							// orient: 'vertical',
							// top: 'middle',
							type: 'scroll',
							orient: 'vertical',
							right: 10,
							top: 40,
							bottom: 20,
							left: 'right',
							data: ['A', 'B', 'C', 'D', 'F'],
							textStyle: {
								color: '#fff',
								fontSize: 12
							}

						},
						grid:{
							x:'-10%',
							y:40,
							x2:20,
							y2:20,
						},
						color : [ '#09d0fb', '#f88cfb', '#95f8fe', '#f9f390',  '#ecfeb7' ],
						series: [
							{
								type: 'pie',
								radius: '65%',
								center: ['50%', '50%'],
								selectedMode: 'single',
								data: [
									{value: 1548, name: 'A',
									
							},
									{value: 535, name: 'B'},
									{value: 510, name: 'C'},
									{value: 634, name: 'E'},
									{value: 735, name: 'F'}
								],
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}
						]
					};
                //获取dom容器
								var myChart = echarts.init(document.getElementById('chartmain_bing'));
								// 使用刚指定的配置项和数据显示图表。
								myChart.setOption(option);
                
                </script>
                <span class="border_bg_leftTop"></span>
                <span class="border_bg_rightTop"></span>
                <span class="border_bg_leftBottom"></span>
                <span class="border_bg_rightBottom"></span>
            </div>
         </div>
        <div class="rightMain_bottom">
            <div class="rightMain_bottomIn">
                <h3>状态</h3>
                <div class="biaoge biaoge_list" style="width:100%; height:36vh">
                	<div class="biaoge_listIn">
                    	<ul class="ul_title">
                        	<li>用户</li>
                            <li>类型号</li>
                            <li>类别一</li>
                            <li>类别二</li>
                            <li>类别三</li>
                        </ul>
                        <div class="ul_list">
                        	<div class="ul_listIn">
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>11</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>12</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>13</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>14</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>15</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>16</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                 <ul class="ul_con">
                                    <li>张三</li>
                                    <li>11</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>12</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                <ul class="ul_con">
                                    <li>张三</li>
                                    <li>13</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                 <ul class="ul_con">
                                    <li>张三</li>
                                    <li>14</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                 <ul class="ul_con">
                                    <li>张三</li>
                                    <li>15</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                                 <ul class="ul_con">
                                    <li>张三</li>
                                    <li>16</li>
                                    <li>类别一</li>
                                    <li>类别二</li>
                                    <li>类别三</li>
                                </ul>
                            </div>
                       </div>
                   </div>
                
                </div>
                <span class="border_bg_leftTop"></span>
                <span class="border_bg_rightTop"></span>
                <span class="border_bg_leftBottom"></span>
                <span class="border_bg_rightBottom"></span>
            </div>
         </div>
    </div>
    <div style="clear:both;"></div>
</div>
<!--数字增长累加动画-->
<script src="js/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/js/jquery.numscroll.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(".shu1").numScroll();
	$(".shu2").numScroll();
	$(".shu3").numScroll();
	$(".shu4").numScroll();
	$(".shu5").numScroll();
	$(".shu6").numScroll();

	/*$(".num2").numScroll({
		time:5000
	});*/
</script>
<!-- 外接页面结束 -->
			</div>
		</div>
	</div>
	<div data-options="region:'south'" class="super-south">
		<!--页脚-->
		<div class="super-footer-info">
			<span><i class="fa fa-info-circle"></i> 作者：FDL</span> <span><i
				class="fa fa-copyright"></i> CopyRight 2020 版权所有 <i
				class="fa fa-caret-right"></i></span>
		</div>
	</div>
	<!--主题设置弹窗-->
	<div id="win">
		<div class="themeItem">
			<ul>
				<li>
					<div class="superGreen" style="background: #1abc9c;">green</div>
				</li>
				<li class="themeActive">
					<div class="superBlue" style="background: #3498db;">blue</div>
				</li>
				<li>
					<div class="superGray" style="background: #95a5a6;">gray</div>
				</li>
				<li>
					<div class="superAmethyst" style="background: #9b59b6;">purple</div>
				</li>
				<li>
					<div class="superBlack" style="background: #34495e;">black</div>
				</li>
				<li>
					<div class="superYellow" style="background: #e67e22;">yellow</div>
				</li>
				<li>
					<div class="superEmerald" style="background: #2ecc71;">emerald</div>
				</li>
				<li>
					<div class="superRed" style="background: #e74c3c;">red</div>
				</li>
			</ul>
		</div>
	</div>
	</body>
</html>