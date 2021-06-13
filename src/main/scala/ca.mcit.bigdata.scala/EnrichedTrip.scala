package ca.mcit.bigdata.scala
import scala.io.Source
import java.io.{BufferedWriter, FileWriter}

object EnrichedTrip extends App {

  val output = new BufferedWriter(new FileWriter("C:/Users/Vish/IdeaProjects/Assigment3/data/final.csv"))

  val stmTrip: List[Trip] = Source.fromFile("C:/Users/Vish/IdeaProjects/Assigment3/data/trips.csv").getLines().toList.tail.map(Trip(_))

  val stmRoute: List[Route] = Source.fromFile("C:/Users/Vish/IdeaProjects/Assigment3/data/routes.csv").getLines().toList.tail.map(Route(_))

  val stmCalendar: List[Calendar] = Source.fromFile("C:/Users/Vish/IdeaProjects/Assigment3/data/calendar.csv").getLines().toList.tail.map(Calendar(_))

  val tripRouteJoin: List[JoinValue] = new MapJoin[Trip, Route]((x) => x.route_id.toString)((y) => y.route_id.toString).join(stmTrip, stmRoute)

  val enrichedTripJoin = new GenericNestedLoopJoin[Calendar, JoinValue]((x, y) => x.service_id == y.left.asInstanceOf[Trip].service_id).join(stmCalendar, tripRouteJoin)

  val pt = enrichedTripJoin.map(joinOutput => {
      val trip = Trip.convertTripcsv(joinOutput.right.getOrElse("").asInstanceOf[JoinValue].left.asInstanceOf[Trip])
      val route = Route.convertRoutecsv(joinOutput.right.getOrElse("").asInstanceOf[JoinValue].right.getOrElse("").asInstanceOf[Route])
      val calendar = Calendar.convertCalnedercsv(joinOutput.left.asInstanceOf[Calendar])
    trip + "," + route + "," + calendar})

  for (i <- pt) {
      output.newLine()
      output.write(i)
  }
      output.close()
}

