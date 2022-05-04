
import sys
from PyQt5 import uic, QtGui
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5.Qt import QPushButton, QSize


form_class = uic.loadUiType("myOmok01.ui")[0]

class MainClass(QMainWindow,form_class):

    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.flag_wb = True
        for i in range(10):
            for j in range(10):
                obj = QPushButton(self)
                obj.setText('')
                obj.setIcon(QtGui.QIcon('0.png'))
                obj.setIconSize(QSize(40,40))
                obj.setGeometry(j*40,i*40,40,40)
                obj.clicked.connect(self.myclick)
        
        self.pb.clicked.connect(self.myreset)
        
        self.show()
        

    def myclick(self):
        if self.flag_wb:
            self.sender().setIcon(QtGui.QIcon('1.png'))
        else:
            self.sender().setIcon(QtGui.QIcon('2.png'))
            
        self.flag_wb = not self.flag_wb
        
    def myreset(self):
        pass
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec_()