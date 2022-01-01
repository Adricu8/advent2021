import scala.io.Source

object day1 {

  
    def path_file = "/home/adricu/workspace/fun/data_advent/day_one.csv"

    def part1(input: Seq[Int]): Int = input.sliding(2).count { case Seq(x, y) => y > x }

    def part2(input: Seq[Int]): Int = part1(input.sliding(3).map(_.sum).toSeq)

    def main(args: Array[String]): Unit =
        val data = Source.fromFile(path_file).getLines().map(_.toInt).toSeq
        println(part1(data))
        println(part2(data))

}
