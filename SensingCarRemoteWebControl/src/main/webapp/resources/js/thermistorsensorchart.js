var thermistorSensorChart;
$(function() {
	thermistorSensorChart = new Highcharts.Chart({
		// chart의 객체에 대한 자세한 내용이 아래에서 제시됨.
		chart : {
			// 어디에 차트를 그릴건지 결정하는 코드
			renderTo : "thermistorSensorChartContainer",
			type : "spline",
			events: {
				// load 다음은 함수명이 나옴. 이건 아래에서 선언해줘야 함!
				load: requestThermistorSensorData
			}
		},
		// 라인별로 색깔을 지정해주는 코드
		colors: ['cyan'],
		title: {
			text: "ThermistorSensor(온도센서)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "온도",
				margin: 30
			}
		},
		series: [{
			name: "온도",
			data: []
		}],
		plotOptions: {
			series: {
				marker: {
					enabled: true
				}
			}
		}
	});
});

function requestThermistorSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/thermistorsensor");
	// 함수를 바로 대입해도 괜찮음.메시지가 도착했을 때 시행
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = thermistorSensorChart.series[0];
		// 쌓이면서 20개가 넘어가면 왼쪽으로 그래프를 이동시키겠다는 의미
		var shift = series.data.length > 20;
		// 그래프 위에 점을 추가하겠다는 의미
		series.addPoint([data.time, data.temperature], true, shift);
	};
}