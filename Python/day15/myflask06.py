from flask import Flask, jsonify, render_template
from subprocess import call
from flask_socketio import send, SocketIO

app = Flask(__name__)
app.secret_key = "mysecret"

socket_io = SocketIO(app)

@app.route('/')
def hello_world():
    return "Hello Gaemigo Project Home Page!!"

@app.route('/chat')
def chatting():
    return render_template('chat.html')

@app.route('/strike')
def strike():
    return render_template('strike.html')


@socket_io.on("message")
def request(message):
    print("message : "+ message)
    to_client = dict()
    to_client['message'] = message
    to_client['type'] = 'normal'
# emit("response", {'data': message['data'], 'username': session['username']}, broadcast=True)
    send(to_client, broadcast=True)



if __name__ == '__main__':
    socket_io.run(app, host="0.0.0.0", debug=False, port=7777)