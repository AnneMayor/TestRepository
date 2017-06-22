function laseremitter(command, status) {
	var json = {"command":command, "status":status};
	$.ajax({
		url : "http://" + location.host + "/SensingCarRemoteWebControl/laseremitter",
		data : json,
		method : "post",
		// data는 controller에서 보내주는 json정보가 담겨있음.
		success : function(data) {
			if (data.result == "success") {
				$("#laseremitterStatus").html(data.status);
			}
		}
	});
}