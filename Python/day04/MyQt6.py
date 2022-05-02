
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5 import uic
from PyQt5.Qt import QMainWindow
import random

form_class = uic.loadUiType("MyQt6.ui")[0]

class MainClass(QMainWindow, form_class):
    def __init__(self):
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.show()
        
    
    def myclick(self):
        
        arr45 = list(range(1,45+1))
        arr6 = []
        
        # for i in range(1,45+1):
        #     arr45.append(i)
        
        random.shuffle(arr45)
        
        for i in range(6):
            arr6.append(arr45[i])
        
        self.lbl1.setText(str(arr6[0]))
        self.lbl2.setText(str(arr6[1]))
        self.lbl3.setText(str(arr6[2]))
        self.lbl4.setText(str(arr6[3]))
        self.lbl5.setText(str(arr6[4]))
        self.lbl6.setText(str(arr6[5]))
        
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainClass()
    app.exec()