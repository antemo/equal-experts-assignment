package nl.codecat.rover;

import static nl.codecat.rover.Direction.*;

public class Position {

	private long x;

	private long y;

	private Direction direction;

	public Position(final long x, final long y, final Direction direction) {
		if (direction == null) {
			throw new IllegalArgumentException("Direction can't be null");
		}

		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void forward() {
		switch (direction) {
			case EAST -> x++;
			case NORTH -> y++;
			case WEST -> x--;
			case SOUTH -> y--;
		}
	}

	public void back() {
		switch (direction) {
			case EAST -> x--;
			case NORTH -> y--;
			case WEST -> x++;
			case SOUTH -> y++;
		}
	}

	public void left() {
		direction = switch (direction) {
			case EAST -> NORTH;
			case NORTH -> WEST;
			case WEST -> SOUTH;
			case SOUTH -> EAST;
		};
	}

	public void right() {
		direction = switch (direction) {
			case EAST -> SOUTH;
			case NORTH -> EAST;
			case WEST -> NORTH;
			case SOUTH -> WEST;
		};
	}

	@Override
	public String toString() {
		return String.format("(%d, %d) %s", x, y, direction.name());
	}
}
