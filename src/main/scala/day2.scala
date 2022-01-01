import scala.io.Source

object day2 {

    sealed trait Command(prefix: String):
        def unapply(s: String): Option[Int] = Option.when(s.startsWith(prefix))(s.drop(prefix.length + 1).toInt)

    case object Forward extends Command("forward")
    case object Down extends Command("down")
    case object Up extends Command("up")

    def part1(input: Seq[String]): Int = 
        val (distance, depth) = input.foldLeft((0, 0)) { case ((distance, depth), command) => 
            command match
                case Forward(value) => (distance + value, depth)
                case Down(value) => (distance, depth + value)
                case Up(value) => (distance, depth - value)
        }
        distance * depth

    def part2(input: Seq[String]): Int =
        val (distance, depth, aim) = input.foldLeft((0, 0, 0)) { case ((distance, depth, aim), command) => 
            command match  
                case Down(value) => (distance, depth, aim + value)
                case Up(value) => (distance, depth, aim - value)
                case Forward(value) => (distance + value, depth + value*aim, aim)    
        }
        distance * depth

    def main(args: Array[String]): Unit =
        def path_file = "/home/adricu/workspace/fun/data_advent/day_two.csv"
        val data = Source.fromFile(path_file).getLines().toSeq
        println(part1(data))
        println(part2(data))

}
