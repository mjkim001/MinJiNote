
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5 import uic
from PyQt5.Qt import QMainWindow

form_class = uic.loadUiType("MyQt5.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        
    
    def myclick(self):
        dan = int(self.le.text())
        str = ""
        for i in range(1,9+1):
            str += "{} * {} = {}\n".format(dan, i , dan*i)
        
        self.te.setText(str)
        
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec()