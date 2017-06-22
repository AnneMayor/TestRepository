function camera(command, leftright, updown) {
	var json = {
		"command" : "change",
		"leftright" : leftright,
		"updown" : updown
	};

	$.ajax({
		// location.host: 이건 ip주소를 동적으로 할당하기 위해서 이렇게 함.
		url : "http://" + location.host + "/SensingCarRemoteWebControl/camera",
		data : json,
		method : "post",
		// data는 controller에서 보내주는 json정보가 담겨있음.
		success : function(data) {
			if (data.result == "success") {
				// span태그에는 html보단 text 사용. html은 자세한 내용을 첨부.
				$("#cameraStatus").html(
						"leftright=" + data.leftright + "; updown="
								+ data.updown);
				$("#btnLeftright180").attr("onclick", "camera('change', '180', '"+data.updown+"')");
				$("#btnLeftright135").attr("onclick", "camera('change', '135', '"+data.updown+"')");
				$("#btnLeftright90").attr("onclick", "camera('change', '90', '"+data.updown+"')");
				$("#btnLeftright45").attr("onclick", "camera('change', '45', '"+data.updown+"')");
				$("#btnLeftright0").attr("onclick", "camera('change', '0', '"+data.updown+"')");
				$("#btnUpdown10").attr("onclick", "camera('change', '"+data.leftright+"', '10')");
				$("#btnUpdown45").attr("onclick", "camera('change', '"+data.leftright+"', '45')");
				$("#btnUpdown75").attr("onclick", "camera('change',  '"+data.leftright+"', '75')");
			}
		}
	});
}