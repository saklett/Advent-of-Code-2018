import scala.util.Try

def calculateFrequence(start: Long, current: String): Long = {
  val num = current.drop(1).toLong
  if(current(0) == '+') start + num
  else  start - num
}

def findFirst(input: Seq[String]): Long = {
  var frequencies = Set.empty[Long]
  val inputSize = input.size
  var counter = 0
  var answer = 0l

  while(!frequencies.contains(answer)) {
    frequencies = frequencies ++ Set(answer)
    answer = calculateFrequence(answer, input(counter % inputSize))
    counter = counter + 1
  }
  answer
}

// Read in input data
val path = "/Users/sklett/src/advent-of-code/day1/input.txt"
val data = spark.read.csv(path).collect.map(row => row.getString(0))

// Calculate the answer
val answer = findFirst(data)

println("The newly calibrated frequency is " + answer)
