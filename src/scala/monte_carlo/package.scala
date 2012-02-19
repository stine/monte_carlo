package object monte_carlo {
	// Times a task and returns a tuple containing the task's return value and
	// the run time in nanoseconds
	def time[T](task: => T) = {
		val startTime = System.nanoTime
		val value = task
		val endTime = System.nanoTime
		(value, endTime - startTime)
	}

	def chooseInRect(rect: Product2[(Float, Float), (Float, Float)]) =
		(chooseInInterval(rect._1), chooseInInterval(rect._2))

	def chooseInInterval(interval: (Float, Float)) =
		scala.util.Random.nextFloat * (interval._2 - interval._1) + interval._1

	def distSquared(pt: (Float, Float)) = {
		import math.pow

		pow(pt._1, 2) + pow(pt._2, 2)
	}
}