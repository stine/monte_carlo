package monte_carlo

// An application that estimates pi using the Monte Carlo method
object MonteCarlo extends App {
	// In interval notation, this is the cartesian product [0, 1] x [0, 1]
	val unitSquare = ((0f, 1f), (0f, 1f))

	val trials = 100000000

	val (ptsInCircle, t) = time {
		import math.pow

		var ptsInCircle = 0

		// The par function returns a "parallel collection". Scala will use
		// multiple CPU cores to evaluate the closure at each element of the range
		(0 until trials).par.foreach(n => {
			val pt = chooseInRect(unitSquare)

			// Checks if pt is in the unit circle quarter inscribed within the unit
			// square
			if (distSquared(pt) <= 1) {
				ptsInCircle += 1
			}
		})

		ptsInCircle
	}

	val pi = ptsInCircle.toFloat * 4f / trials.toFloat
	println("Estimated pi as " + pi + " with " + trials + " trials in "
		+ t / (1000 * 1000 * 1000f) + " seconds")
}