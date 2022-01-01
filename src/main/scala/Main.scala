import scala.io.Source


@main def count_increases: Unit = 
  val it = Source.fromFile(path_file).getLines
  var count = 0
  var prev = "-1"
  for (i <- it) 
    if (i > prev) count += 1
    prev = i

  println(f"count = ${count}")

def path_file = "/home/adricu/workspace/fun/data_advent/day_one.csv"
