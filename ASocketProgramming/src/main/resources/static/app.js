var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
	var socket = new SockJS('/websocket-urlFrontend');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/user', function (greeting) {
        	
        	var myArray = [];
        	myArray = JSON.parse(greeting.body);
        	var x= document.getElementById("userinfo");
        	x.innerHTML="";
        	for(var i=0; i<myArray.length;i++){
        		console.log("1. . . "+myArray[i].name + " 2... " +myArray[i].email);
        		showGreeting(myArray[i].name, myArray[i].email);
        	}
        });
    });
}
connect();
var connection = new SockJS('/websocket-urlFrontend');
connection.onmessage = function(e){
	   var server_message = e.data;
	   console.log("server message "+server_message);
	}
//disconnect();
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/user", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message1,message2) {
    $("#userinfo").append("<tr><td>" + message1 + "</td><td>" + message2 + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});