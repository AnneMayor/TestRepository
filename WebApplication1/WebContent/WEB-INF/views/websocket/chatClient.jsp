<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>Home</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var ws = null;
	function handleBtnConnect() {
		ws = new WebSocket("ws://" + window.location.host
				+ "/WebApplication1/websocket/chat");
		// onclick과 유사하다고 볼 수 있음.(다 함수!) 
		ws.onopen = onOpen;
		ws.onmessage = onMessage;
		ws.onclose = onClose;
		console.log(ws);
	}

	function onOpen() {
		display("[연결성공]");
		$("#btnConnect").attr("disabled", true);
		$("#btnDisconnect").attr("disabled", false);
	}

	function onMessage(event) {
		var strMessage = event.data;
		$("#divDisplay").append(strMessage + "<br/>");
	}

	function onClose() {
		display("[연결끊김]");
		$("#btnConnect").attr("disabled", false);
		$("#btnDisconnect").attr("disabled", true);
	}

	function handleBtnDisconnect() {
		if (ws != null) {
			ws.close();
			ws = null;
		}
	}

	function handleBtnSend() {
		var strName = $("#txtName").val();
		var strMessage = $("#txtMessage").val();
		ws.send("&lt" + strName + "&gt" + strMessage);
	}

	function display(message) {
		$("#divDisplay").append(
				"<span style='display:block;'>" + message + "</span>");
		if ($("#divDisplay span").length > 20) {
			$("#divDisplay span").first().remove();
		}
		$("#divDisplay").scrollTop($("#divDisplay").height());
	}
</script>
</head>
<body>
	<h3>WebSocket-Chat</h3>
	<hr />
	<div>
		<button id="btnConnect" onclick="handleBtnConnect()"
			class="btn btn-warning">연결하기</button>
		<button id="btnDisconnect" onclick="handleBtnDisconnect()"
			class="btn btn-danger">연결끊기</button>
	</div>
	<div>
		채팅명: <input id="txtName" type="text" />
	</div>
	<div>
		<input id="txtMessage" type="text" />
		<button id="btnSend" onclick="handleBtnSend()" class="btn btn-info">메시지 전송</button>
	</div>
	<div>
		<div id="divDisplay"
			style="width: 600px; height: 300px; padding: 5px; overflow-y: scroll; border: 1px solid black; margin-top: 5px;"></div>
	</div>
</body>
</html>