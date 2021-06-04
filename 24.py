'''
Level 1

Question: Define a class, which have a class parameter and have a same instance parameter.

Hints: Define a instance parameter, need add it in init method You can init a object with construct parameter or set the value later
'''
class Person:
    # Define the class parameter "name"
    name = "Person"
    
    def __init__(self, name = None):
        # self.name is the instance parameter
        self.name = name

navneet = Person("Navneet")
print("%s name is %s" % (Person.name, navneet.name))

nikita = Person()
nikita.name = "Nikita"
print("%s name is %s" % (Person.name, nikita.name))
