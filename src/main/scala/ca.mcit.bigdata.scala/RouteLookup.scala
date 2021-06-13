package ca.mcit.bigdata.scala
import ca.mcit.bigdata.scala.Route

class RouteLookup(routes: List[Route]) {
  private val lookupTable: Map[Int, Route] =
    routes.map(route => route.route_id -> route).toMap
  def lookup(routeId: Int): Route = lookupTable.getOrElse(routeId, null)
}
