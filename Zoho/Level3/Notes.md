## Methods That Leave the Newline Character in the Buffer
These methods **do not consume the newline** and leave it in the input buffer:

- `next()`
- `nextInt()`
- `nextDouble()`
- `nextFloat()`
- `nextLong()`
- `nextShort()`
- `nextByte()`
- `nextBoolean()`

## Methods That Consume the Newline Character
These methods **consume the newline character** and move the scanner to the next line:

- `nextLine()`: Reads and consumes the entire line, including the newline character at the end.

### summary
* all produces new line character at end.
* but only nextLine() consumes newline character while others dont!