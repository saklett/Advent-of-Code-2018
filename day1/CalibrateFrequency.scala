import scala.util.Try

def calculateFrequence(start: Long, current: String): Long = {
  val num = current.drop(1).toLong
  if(current(0) == '+') start + num
  else  start - num
}

// Read in input data
val path = "/Users/sklett/src/advent-of-code/day1/input.txt"
val data = spark.read.csv(path).collect.map(row => row.getString(0))

// Calculate the answer
val answer = data.foldLeft(0l)(calculateFrequence)

println("The newly calibrated frequency is " + answer)
