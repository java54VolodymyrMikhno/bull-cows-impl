# bulls-cows-implementations
## Implementation base for Bulls and Cows application core
## Functional Classes
### Move
  DTO class for transferring client sequence from the client to the server
### MoveResult
  DTO class for transferring move's result from the server to the client
### Game
  Data about Game <br>
  Move's processing
### BullsCowsService
  Interface as abstract layer of any BullsCows controlling implementations
### BullsCowsMapImpl
 The interface implementation based on HashMap containing associations of game ID's and game states
## Dependencies
No dependencies
## Test classes
### BullsCowsTest
abstract class for testing of a game logics for any implementation
### BullsCowsMapImplTest
extends BullsCowsTest<br>
contains only creating real object of the implementation and providing reference to Game only for testing purpose
