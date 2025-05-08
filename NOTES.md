# TODO
- Class Rover:
  
  - Method 'go'
    - Long method
    - Switch statements
    - Feature envy
    - Primitive obsession

- Class RoverState:
  - Data class
  - Primitive obsession

# In progress

Mikado primitive obsession position
 - xPosition:
   - Usage in setStartingPosition
   - Usage in pose
   - Usage in move
 - yPosition:
   - Usage in setStartingPosition
   - Usage in pose
   - Usage in move

# Done
## Readability:
- Class Rover:
  - Unused constructor without parameter
  - Unused method 'g'
  - Non idiomatic constructor
  - Variables are not defined on top level
  - Constructor:
    - Unclear parameter 'p'
    - Unclear variable 's'
  - Method 'go':
    - Unclear parameter 'cms'
    - Unclear variable 'c'
  - Unclear variable name 'xyz'
  - Variable pose is feature envy

- Class RoverState:
  - Unclear variable names
  - Magic constants for direction
  - Magic constants for instruction


Mikado Primitive obsession direction
- Replace usage in init
- Replace usage in go
  - Instruction rotate left
  - Instruction rotate right
  - Instruction move