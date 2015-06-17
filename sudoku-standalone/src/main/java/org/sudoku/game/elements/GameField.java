package org.sudoku.game.elements;

import org.sudoku.game.conf.GameFieldConfiguration;
import org.sudoku.game.strategies.ResolverByBlock;
import org.sudoku.game.strategies.StrategiesFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GameField
		implements StrategiesFactory {

	public static final String ROW_SEPARATOR = " --- --- --- --- --- --- --- --- --- ";
	public static final char COLUMN_SEPARATOR = '|';

	private final Square[][] squares;
	private final ReadWriteLock[][] squaresLocks;
	private final int numberOfElementsOnSide;
	private final int numberOfElementsOnSquareSide;
	private final int numberOfSquaresOnSide;

	private GameField(
			final GameFieldConfiguration configuration,
			final Square[][] squares,
			final ReadWriteLock[][] squaresLocks) {
		this.squares = squares;
		this.squaresLocks = squaresLocks;
		numberOfElementsOnSide = configuration.getNumberOfElementsOnSide();
		numberOfElementsOnSquareSide = configuration.getNumberOfElementsOnSquareSide();
		numberOfSquaresOnSide = configuration.getNumberOfSquaresOnSide();
	}

	@Override
	public Runnable build(final int columnIndex, final int rowIndex) {
		int upRowIndex = (columnIndex - 1 + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int upColumnIndex = (rowIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int downRowIndex = (columnIndex + 1 + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int downColumnIndex = (rowIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int centerRowIndex = (columnIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int centerColumnIndex = (rowIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int leftRowIndex = (columnIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int leftColumnIndex = (rowIndex - 1 + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int rightRowIndex = (columnIndex + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		int rightColumnIndex = (rowIndex + 1 + numberOfSquaresOnSide) % numberOfSquaresOnSide;
		return new ResolverByBlock(
				numberOfElementsOnSquareSide,
				numberOfElementsOnSide,
				squares[upColumnIndex][upRowIndex],
				squaresLocks[upRowIndex][upRowIndex].readLock(),
				squares[downColumnIndex][downRowIndex],
				squaresLocks[downColumnIndex][downRowIndex].readLock(),
				squares[centerColumnIndex][centerRowIndex],
				squaresLocks[centerColumnIndex][centerRowIndex],
				squares[leftColumnIndex][leftRowIndex],
				squaresLocks[leftColumnIndex][leftRowIndex].readLock(),
				squares[rightColumnIndex][rightRowIndex],
				squaresLocks[rightColumnIndex][rightRowIndex].readLock()
		);
	}

	public boolean isFilled() {
		for (Square[] rows : squares) {
			for (Square square : rows) {
				if (!square.isFilled()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(ROW_SEPARATOR + "\n");
		for (int i = 0; i < numberOfElementsOnSide; i++) {
			sb.append(COLUMN_SEPARATOR);
			final int squareColumnIndex = calculateSquareColumnIndex(i);
			for (int j = 0; j < numberOfElementsOnSide; j++) {
				final int squareRowIndex = calculateSquareRowIndex(j);
				sb.append(
						squares[squareColumnIndex][squareRowIndex]
								.get(
										calculateColumnOffset(i),
										calculateRowOffset(j)
								)
				).append(COLUMN_SEPARATOR);
			}
			sb.append("\n" + ROW_SEPARATOR + "\n");
		}
		return sb.toString();
	}

	private int calculateRowOffset(final int rowIndex) {
		return rowIndex % numberOfElementsOnSquareSide;
	}

	private int calculateColumnOffset(final int columnIndex) {
		return columnIndex % numberOfElementsOnSquareSide;
	}

	private int calculateSquareRowIndex(final int rowIndex) {
		return rowIndex / numberOfSquaresOnSide;
	}

	private int calculateSquareColumnIndex(final int columnIndex) {
		return columnIndex / numberOfSquaresOnSide;
	}

	public static class Builder {

		private final Square[][] squares;
		private final ReadWriteLock[][] squaresLocks;
		private GameFieldConfiguration configuration;

		public Builder(final GameFieldConfiguration configuration, final Element[][] elements) {
			isInputElementsEnoughLength(configuration, elements);
			this.configuration = configuration;
			final int numberOfSquaresOnSide = configuration.getNumberOfSquaresOnSide();
			squares = new Square[numberOfSquaresOnSide][numberOfSquaresOnSide];
			squaresLocks = new ReadWriteLock[numberOfSquaresOnSide][numberOfSquaresOnSide];
			for (int i = 0; i < numberOfSquaresOnSide; i++) {
				for (int j = 0; j < numberOfSquaresOnSide; j++) {
					squares[i][j] = new Square.Builder(configuration, elements, i, j).build();
					squaresLocks[i][j] = new ReentrantReadWriteLock();
				}
			}
		}

		private void isInputElementsEnoughLength(
				final GameFieldConfiguration configuration,
				final Element[][] elements) {
			final int numberOfElementsOnSide = configuration.getNumberOfElementsOnSide();
			if (elements.length != numberOfElementsOnSide
					&& !isSubArraysHaveProperlyLengths(numberOfElementsOnSide, elements)) {
				throw new NotRightElementArrayLengthException(
						String.format(
								"Game field can contains only %s elements on side but is %s elements on side",
								configuration.getNumberOfElementsOnSquareSide(),
								elements.length
						)
				);
			}
		}

		private boolean isSubArraysHaveProperlyLengths(
				final int numberOfElementsOnSide,
				final Element[][] elements) {
			for (Element[] els : elements) {
				if (els.length != numberOfElementsOnSide) {
					return false;
				}
			}
			return true;
		}

		public GameField build() {
			return new GameField(configuration, squares, squaresLocks);
		}
	}
}
