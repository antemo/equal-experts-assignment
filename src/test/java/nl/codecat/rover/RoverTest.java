package nl.codecat.rover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {

	@Test
	@DisplayName("Method for calculating position should reject invalid starting position")
	public void testInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> new Rover(1, 1, null));
	}

	@Test
	@DisplayName("Method for calculating position should reject null command string")
	public void testNullCommand() {
		final Rover rover = new Rover(1, 1, Direction.NORTH);
		assertThrows(IllegalArgumentException.class, () -> rover.move(null));
	}

	@Test
	@DisplayName("Method for calculating position should return same position in case of empty command string")
	public void testBlankCommand() {
		final Rover rover = new Rover(1, 1, Direction.NORTH);
		final String expected = new Position(1, 1, Direction.NORTH).toString();
		rover.move("");
		assertEquals(expected, rover.result());
	}

	@Test
	@DisplayName("Method for calculating position should give correct solution to assignment example")
	public void testAssignmentExample() {
		final Rover rover = new Rover(4, 2, Direction.EAST);
		final String expected = new Position(6, 4, Direction.NORTH).toString();
		rover.move("FLFFFRFLB");
		assertEquals(expected, rover.result());
	}

	@Test
	@DisplayName("Method for calculating position should ignore invalid characters in command string")
	public void testInvalidCommand() {
		final Rover rover = new Rover(4, 2, Direction.EAST);
		final String expected = new Position(6, 4, Direction.NORTH).toString();
		rover.move("FGKL FJHF YIFU RKFL OWSB");
		assertEquals(expected, rover.result());
	}

	@Test
	@DisplayName("Method for calculating position should accept multiple command calls")
	public void testMultipleCalls() {
		final Rover rover = new Rover(4, 2, Direction.EAST);
		final String expected1 = new Position(6, 4, Direction.NORTH).toString();
		rover.move("FLFFFRFLB");
		assertEquals(expected1, rover.result());
		rover.move("FLFFFRFLB");
		final String expected2 = new Position(4, 6, Direction.WEST).toString();
		assertEquals(expected2, rover.result());
	}

	@Test
	@DisplayName("Method for calculating position should be case sensitive when reading command string")
	public void testCaseSensitive() {
		final Rover rover = new Rover(4, 2, Direction.EAST);
		final String expected = new Position(5, 5, Direction.WEST).toString();
		rover.move("FLfFFrFLb");
		assertEquals(expected, rover.result());
	}

}
