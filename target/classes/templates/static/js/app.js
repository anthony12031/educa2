//var url = 'http://'+window.location.host+'/stomp/educa2';
var url = "educa2";
var sock = new SockJS(url);

var stompClient = Stomp.over(sock);
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (greeting) {
        console.log(JSON.parse(greeting.body).content);
    });
    stompClient.send("/app/shout",{},JSON.stringify({'message':'hola from client'}))
});