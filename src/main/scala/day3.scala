import scala.io.Source

object day3 {
  
    type Binary = Seq[Boolean]

    val path = "/home/adricu/workspace/fun/data_advent/day_one.csv"
    val data = Source.fromFile(path).getLines().map(_.toString).toSeq

    def part1(input: Seq[String]): Int = input.groupBy(record => (record.charAt, ))
    
    def binaryParser(s: String): Binary = s.map(_ == 1)

    def parseBinaries(input: String): Seq[Binary] = input.linesIterator.map(binaryParser).toSeq

    


    def parseBinaries(input: String): Seq[Binary] = input.linesIterator.map(parseBinary).toSeq

}
