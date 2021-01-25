package nl.codecat.rover;

public class Rover {

	private final Position position;

	public Rover(final long x, final long y, final Direction direction) {
		position = new Position(x, y, direction);
	}

	public void move(final String command) {
		if (command == null) {
			throw new IllegalArgumentException("Command string can't be null");
		}

		if (command.isBlank()) {
			// nothing to do
			return;
		}

		command.chars().forEach(character -> {
			if (character == 'F') {
				position.forward();
			} else if (character == 'B') {
				position.back();
			} else if (character == 'L') {
				position.left();
			} else if (character == 'R') {
				position.right();
			}
		});
	}

	public String result() {
		return position.toString();
	}

}
