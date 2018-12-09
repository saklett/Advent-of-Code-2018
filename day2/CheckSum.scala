import scala.util.Try

def letterCounts(id: String): Seq[(String, Int)] = {
  val letterMap = id
    .map(letter => (letter, 1))
    .groupBy(_._1)
    .mapValues(_.length)
    .filter(pair => pair._2 == 2 || pair._2 == 3)

}

def checkSum(code: String): Boolean= {
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
