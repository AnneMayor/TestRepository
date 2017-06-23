function backtire(command, direction, speed) {
	var json = {"command":command, "direction":direction, "speed":speed};
	$.ajax({
		url:"http://"+location.host+"/SensingCarRemoteWebControl/backtire",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#backtireStatus").html(
						"direction=" + data.direction + "; speed="
								+ data.speed);
				$("#btnBackTire0").attr("onclick", "backtire('change', '"+data.direction+"', '0')");
				$("#btnBackTire1").attr("onclick", "backtire('change', '"+data.direction+"', '500')");
				$("#btnBackTire2").attr("onclick", "backtire('change', '"+data.direction+"', '700')");
				$("#btnBackTire3").attr("onclick", "backtire('change', '"+data.direction+"', '1000')");
				$("#btnBackTire4").attr("onclick", "backtire('change', '"+data.direction+"', '1300')");
				$("#btnBackTire5").attr("onclick", "backtire('change', '"+data.direction+"', '1600')");
				$("#btnBackTire6").attr("onclick", "backtire('change', '"+data.direction+"', '1900')");
				$("#btnBackTire7").attr("onclick", "backtire('change', '"+data.direction+"', '2100')");
				$("#btnBackTire8").attr("onclick", "backtire('change', '"+data.direction+"', '2400')");
				$("#btnBackTire9").attr("onclick", "backtire('change', '"+data.direction+"', '2700')");
				$("#btnBackTire10").attr("onclick", "backtire('change', '"+data.direction+"', '3000')");
				$("#btnBackTireForward").attr("onclick", "backtire('change',  'forward', '"+data.speed+"')");
				$("#btnBackTireBackward").attr("onclick", "backtire('change',  'backward', '"+data.speed+"')");
			}
		}
	});
}