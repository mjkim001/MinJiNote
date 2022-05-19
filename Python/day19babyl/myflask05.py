from flask import Flask,render_template, request,jsonify
from day10.dao_emp import DaoEmp

app = Flask(__name__,static_url_path='',static_folder='./static')


@app.route('/')
def emp():
    return render_template('babyl3.html')


if __name__ == '__main__':
    app.run(debug=True)
   