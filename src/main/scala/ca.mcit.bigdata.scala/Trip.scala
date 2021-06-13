package ca.mcit.bigdata.scala

case class Trip(route_id:Int, service_id:String, trip_id:String, trip_HeadSign:String,
                 direction_id:Int, shape_id:Int, wheelchair_accessible:Boolean)

object Trip extends App {

  def convertLineToTrip(line: String): Trip = {
    val fields: Array[String] = line.split(",", -1)
    Trip(fields(0).toInt, fields(1), fields(2),fields(3), fields(4).toInt, fields(5).toInt, fields(6).toBoolean)
  }

  def convertTripcsv(trip: Trip): String = {
      trip.route_id + "," +
      trip.service_id + "," +
      trip.trip_id + "," +
      trip.trip_HeadSign + "," +
      trip.shape_id + "," +
      trip.wheelchair_accessible
  }
}
