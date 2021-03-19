# Dependency Inversion Principle

> In object-oriented design, the dependency inversion principle is a specific form of loosely coupling software modules. When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed, thus rendering high-level modules independent of the low-level module implementation details. The principle states:
> - High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
> - Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.  
> 
> [Wikipedia.org](https://en.wikipedia.org/wiki/Dependency_inversion_principle)

An ***abstraction*** is an abstract class or interface that gives a signature of the operation that it performs, but is not the concrete implementation.  When we code using abstraction it is easier to change implementation without breaking anything.

Say we want some kind of application that models relationships between people.