
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5 import uic
from PyQt5.Qt import QMainWindow

form_class = uic.loadUiType("MyQt.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        
    
    def myclick(self):
        print(self.lbl.text())
        self.lbl.setText("good evening")
        
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec()