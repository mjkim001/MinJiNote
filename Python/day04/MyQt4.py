
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5 import uic
from PyQt5.Qt import QMainWindow
import random

form_class = uic.loadUiType("MyQt4.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        
        
    
    def myclick(self):
        mine = self.le_mine.text()
        rnd = random.random()
        com = ""
        result = ""
        
        if rnd > 0.5:
            com = "짝"
        else:
            com = "홀"
            
        self.le_com.setText(com)

        if mine == com:
            result = "맞췄습니다."
        else:
            result = "틀렸습니다."
        
        self.le_result.setText(result)
        
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec()