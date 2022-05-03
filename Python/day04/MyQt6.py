
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
        arr45 = list(range(1,45+1)) #list를 붙여주면 배열로 
        arr6 = []
        
        # for i in range(1,45+1):
        #     arr45.append(i)
        
        
        # 랜덤으로 뽑아서 0번째 자리와 자리를 바꿔 여러번 반복
        # rnd = int(random.random()*45)
        # a = arr45[rnd]
        # b = arr45[0]
        # arr45[0] = a
        # arr45[rnd] = b

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