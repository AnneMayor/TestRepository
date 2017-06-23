function ultrasonicsensor(command, angle) {
	var json = {
		"command" : command,
		"angle" : angle
	};

	$.ajax({
		// location.host: 이건 ip주소를 동적으로 할당하기 위해서 이렇게 함.
		url : "http://" + location.host + "/SensingCarRemoteWebControl/ultrasonicsensor",
		data : json,
		method : "post",
		// data는 controller에서 보내주는 json정보가 담겨있음.
		success : function(data) {
			if (data.result == "success") {
				// span태그에는 html보단 text 사용. html은 자세한 내용을 첨부.
				$("#ultrasonicsensorStatus").html(
						"angle=" + data.angle + "; distance="
								+ data.distance);
				
			}
		}
	});
}