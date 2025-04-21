Name the two patterns you wish to implement and explain what advantages you hope to achieve with them.\
Observer Pattern, Template Method Pattern\

Describe how you implement the patterns, including additional interfaces, classes, and how these will integrate with the classes that you already have.\
Observer Pattern - I will create a PurseObserver interface that PursePanel will implement, and in the constructor of PursePanel I will purse.AddObserver to add the pursePanel object to the list of observers that purse will call whenver there is an update.\
Template Method Pattern - I made the existing Register class an abstract class and added a Count method that calls other methods inside of the parent Register class. Then, I made two other classes EURegister and USRegister. \These classes overwrote the defineParameters method of the register class after inheriting the same class. The defineParameters method is also marked as abstract so that you have to implement it in child classes.\This design enabled multiple regions currency to be added.
