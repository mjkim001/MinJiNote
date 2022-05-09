from flask import Flask
from flask.globals import request

app = Flask(__name__)

@app.route('/',methods=['POST'])
def home():
    #a = request.args.get('a')
    a = request.form.get('a')
    return 'Hello, Python!'+a

if __name__ == '__main__':
    app.run(debug=True)
