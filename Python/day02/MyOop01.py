class Animal:
    def __init__(self):
        self.age = 0
        
    def getOld(self):
        self.age += 1

class Human(Animal):
    def __init__(self):
        super().__init__()
        self.skill_lang = 0

    def momstouch(self, stroke):
        self.skill_lang += stroke



if __name__ == '__main__':
    ani = Animal()
    print(ani.age)
    ani.getOld()
    print(ani.age)

# hum = Human()
# hum.getOld()
# hum.momstouch(10)

# print(hum.age)
# print(hum.skill_lang)




