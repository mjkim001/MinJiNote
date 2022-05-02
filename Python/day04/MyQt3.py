
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5 import uic
from PyQt5.Qt import QMainWindow

form_class = uic.loadUiType("MyQt3.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        
    
    def myclick(self):
        num1 = int(self.le1.text())
        num2 = int(self.le2.text())
        self.le3.setText(str(num1+num2))
        
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec()