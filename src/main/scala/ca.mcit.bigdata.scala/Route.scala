package ca.mcit.bigdata.scala

case class Route (route_id:Int, agency_id:String, route_short_name:String, route_long_name:String,
                 route_type:String, route_url:String, route_color:String, route_text_color:String)

object Route extends App {

  def convertLineToRoutes(line: String): Route = {
    val fields: Array[String] = line.split(",", -1)
    Route(fields(0).toInt, fields(1), fields(2), fields(3), fields(4), fields(5), fields(6), fields(7))
  }

  def convertRoutecsv(route: Route): String = {
      route.route_id + "," +
      route.agency_id + ","
      route.route_short_name + "," +
      route.route_long_name + "," +
      route.route_type + "," +
      route.route_url + "," +
      route.route_color + "," +
      route.route_text_color
  }
}
