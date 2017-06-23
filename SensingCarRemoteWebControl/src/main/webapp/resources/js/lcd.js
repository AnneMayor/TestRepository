function lcd(command) {
	var line0 = $("#lcdline0").val();
	var line1 = $("#lcdline1").val();
	var json = {
		"command" : command, "line0" : line0, "line1" : line1
	};

	$.ajax({
		// location.host: 이건 ip주소를 동적으로 할당하기 위해서 이렇게 함.
		url : "http://" + location.host + "/SensingCarRemoteWebControl/lcd",
		data : json,
		method : "post",
		// data는 controller에서 보내주는 json정보가 담겨있음.
		success : function(data) {
			if (data.result == "success") {
				// span태그에는 html보단 text 사용. html은 자세한 내용을 첨부.
				$("#lcdStatus").html(
						"<br/>line0:" + data.line0 + "<br/>line1:"
								+ data.line1);
				
			}
		}
	});
}