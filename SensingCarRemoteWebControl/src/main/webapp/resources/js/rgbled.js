function rgbled(command, red, green, blue) {
	var json = {
			"command" : "change",
			"red" : red,
			"green" : green,
			"blue":blue
		};
	$.ajax({
		// location.host: 이건 ip주소를 동적으로 할당하기 위해서 이렇게 함.
		url : "http://" + location.host + "/SensingCarRemoteWebControl/rgbled",
		data : json,
		method : "post",
		// data는 controller에서 보내주는 json정보가 담겨있음.
		success : function(data) {
			if (data.result == "success") {
				$("#rgbLedStatus").css("background-color", "rgb("+data.red+","+data.green+","+data.blue+")");
			}
		}
	});
}